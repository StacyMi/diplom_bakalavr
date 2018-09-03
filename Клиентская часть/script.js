function getForm(url) {
  var xhr = new XMLHttpRequest();
  xhr.open('GET', url, false);
  xhr.withCredentials = true;
  xhr.send();
  return xhr.responseText;
}
function postForm(url, body) {
  var xhr = new XMLHttpRequest();
  xhr.open('POST', url, false);
  xhr.withCredentials = true;
  xhr.send(body);
  return xhr.responseText;
}

var stop = 0; // для того, чтобы мы могли получить форму только один раз
//document.getElementById("doSome").onclick = function() {
  if (stop == 0) {
    stop = 1;

    <!--alert("Hello");-->
    var form = getForm("http://109.202.0.226/adapter-web/rest/pgu-forms/b6acb1fb-6f55-491f-87ee-28fee6eed727");
    var ui = JSON.parse(form).ui;
    var elements = JSON.parse(ui);
    var n = elements.length;
    var k = 0;
    var maxLenF = 0, maxLenI = 0, maxLenO = 0;
    for (var i = 0; i < n; i++) {

      if (elements[i].class == ".Group") {
        var h1 = document.createElement("h1");
        h1.innerHTML = elements[i].description;
        h1.className = 'Zag';
        div1.insertBefore(h1, div1.children[k]);
        k++;
        var m = elements[i].components.length;

        for (var j = 0; j < m; j++) {

          if (elements[i].components[j].type == "javax.xml.datatype.XMLGregorianCalendar") {
            var p = document.createElement("p");
            p.innerHTML = elements[i].components[j].description;
            var text = document.createElement("input");
            text.type = "date";
            text.id = 'data_birthday';
            text.className = 'box1';
            p.className = 'pp';
              div1.insertBefore(p, div1.children[k]);
              k++;
            div1.insertBefore(text, div1.children[k]);
            k++;
          }

          if (elements[i].components[j].type == "java.lang.String") {
            if (elements[i].components[j].description != "Пол") {
              var p = document.createElement("p");
              var text = document.createElement("input");
              p.innerHTML = elements[i].components[j].description;
              text.className = 'box1';
              p.className = 'pp';
              div1.insertBefore(p, div1.children[k]);
              k++;
              if (elements[i].components[j].description == "Имя") {
                maxLenI = elements[i].components[j].max;
                text.id = 'TextLenghtName';
              }
              if (elements[i].components[j].description == "Фамилия") {
                maxLenF = elements[i].components[j].max;
                text.id = 'TextLenghtLastName';
              }
              if (elements[i].components[j].description == "Отчество") {
                maxLenO = elements[i].components[j].max;
                text.id = 'TextLenghtSName';
              }
              div1.insertBefore(text, div1.children[k]);
              k++;

            }
            if (elements[i].components[j].description == "Пол") {
              var p = document.createElement("p");
              p.innerHTML = elements[i].components[j].description;
              p.className = 'pp';
              var strRender = elements[i].components[j].renderHint;
              var dictionary = '';
              for(var k = 0; k < strRender.length; k++) {
                  if (strRender[k] == 'd') {
                    if (strRender[k + 1] == 'i') {
                      if (strRender[k + 2] == 'c') {
                        k = k + 11;
                        var flag = 0;
                        while(flag != 1) {
                          if (strRender[k] != ',') {
                            dictionary = dictionary + strRender[k];
                            k++;
                          } else {
                            flag = 1;
                          }
                        }
                      }
                    }
                  }
              }
              var form2 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/" + dictionary);
              var elements2 = JSON.parse(form2);
              var n2 = elements2.documents.length;
              var mySelect = document.createElement("select");
              mySelect.className = 'box1';
              mySelect.options.length = n2;
              for (var k2 = 0; k2 < n2; k2++) {
                mySelect.options[k2].text = elements2.documents[k2].label;
                mySelect.options[k2].value = elements2.documents[k2].value;
              }
              div1.insertBefore(p, div1.children[k]);
              k++;
              div1.insertBefore(mySelect, div1.children[k]);
              k++;
            }
          }
        }

      } else {
        if (elements[i].type == "java.lang.String") {
            var p = document.createElement("p");
            p.innerHTML = elements[i].description;
            var text = document.createElement("input");
            text.className = 'box1';
            p.className = 'pp';
              div1.insertBefore(p, div1.children[k]);
              k++;
            div1.insertBefore(text, div1.children[k]);
            k++;
        }
        if (elements[i].type == "java.lang.Boolean") {
            var p = document.createElement("p");
            var text = document.createTextNode(elements[i].description);
            var cht = document.createElement("input");
            cht.type = "checkbox";
            cht.value = "Vanilla";
            text.className = 'ppp';
            cht.className = 'pp';
            div1.insertBefore(p, div1.children[k]);
            k++;
            div1.insertBefore(cht, div1.children[k]);
            k++;
            div1.insertBefore(text, div1.children[k]);
            k++;
        }
        if (elements[i].type == "java.io.File") {
            var p = document.createElement("p");
            p.innerHTML = elements[i].description;
            var text = document.createElement("input");
            text.className = 'pp';
            text.type = "file";
            p.className = 'pp';
              div1.insertBefore(p, div1.children[k]);
              k++;
            div1.insertBefore(text, div1.children[k]);
            k++;
        }
        if (elements[i].type == "javax.xml.datatype.XMLGregorianCalendar") {
            var p = document.createElement("p");
            p.innerHTML = elements[i].description;
            var text = document.createElement("input");
            text.type = "date";
            text.className = 'box1';
            p.className = 'pp';
            div1.insertBefore(p, div1.children[k]);
            k++;
            div1.insertBefore(text, div1.children[k]);
            k++;
        }
      }
    }

    // ограничим поле ввода с id = TextLenght 3 символами

    $('#TextLenghtName').keyup( function(){
      var $this = $(this);
      if($this.val().length > maxLenI) {
        alert('Максимльно вводимая длинна: ' + maxLenI);
        $this.val($this.val().substr(0, maxLenI));
      }
    });
    $('#TextLenghtLastName').keyup( function(){
      var $this = $(this);
      if($this.val().length > maxLenF) {
        alert('Максимльно вводимая длинна: ' + maxLenF);
        $this.val($this.val().substr(0, maxLenF));
      }
    });
    $('#TextLenghtSName').keyup( function(){
      var $this = $(this);
      if($this.val().length > maxLenO) {
        alert('Максимльно вводимая длинна: ' + maxLenO);
        $this.val($this.val().substr(0, maxLenO));
      }
    });

    // проверяем чтобы дата рождения не превышала текущую дату
  var dateToday = new Date();
//			alert(dateToday);

    $('#data_birthday').change(function () {
        var DateB = new Date($(this).val());

        if (DateB.getFullYear() >= dateToday.getFullYear()) {
          if (DateB.getFullYear() > dateToday.getFullYear()) {
            alert('Дата рождения превышает текущую дату!');
            $(this).val(dateToday);
          } else {
            if (DateB.getMonth() >= dateToday.getMonth()) {
              if (DateB.getMonth() > dateToday.getMonth()) {
                alert('Дата рождения превышает текущую дату!');
                $(this).val(dateToday);
              } else {
                if (DateB.getDate() >= dateToday.getDate()) {
                  if (DateB.getDate() > dateToday.getDate()) {
                    alert('Дата рождения превышает текущую дату!');
                    $(this).val(dateToday);
                  }
                }
              }
            }
          }
        }
    });


  }
//}





function changeNodeXml(xml, selector, context){
  var parser = new DOMParser();
  var xmlDoc = parser.parseFromString(xml, "text/xml");
  var selectedNode = xmlDoc.querySelector(selector);
  var nodeValue = selectedNode.textContent;
  selectedNode.textContent = context;
  return new XMLSerializer().serializeToString(xmlDoc);
}

function NodeXml(xml, selector){
  var parser = new DOMParser();
  var xmlDoc = parser.parseFromString(xml, "text/xml");
  var selectedNode = xmlDoc.querySelector(selector);
  return selectedNode.textContent;
}

var m = ["LASTNAME", "FITSTNAME", "MIDDLENAME", "SEX", "DATE_BIRTH"];





var klik = 0;

document.getElementById("Send").onclick = function() {
if ((document.getElementById("TextLenghtLastName").value != "") && (document.getElementById("TextLenghtName").value != "") && (document.getElementById("TextLenghtSName").value != "")) {
  document.getElementById('div2').innerHTML = '';
  $('#tab1').prop('checked', false);
  $('#tab2').prop('checked', true);

//  var tab1 = document.getElementById("tab1");
//  tab1.checked = false;
//  var tab2 = document.getElementById("tab1");
//  tab2.checked = true;

  var requestXML = "<AppData>"+
    "<LASTNAME></LASTNAME>"+
    "<FITSTNAME></FITSTNAME>"+
    "<MIDDLENAME></MIDDLENAME>"+
    "<SEX></SEX>"+
    "<DATE_BIRTH></DATE_BIRTH>"+
    "</AppData>";

  for (var i = 0; i < 5; i++) {
    var text = document.getElementsByTagName("input")[i + 1];
    var val=text.value;
    requestXML = changeNodeXml(requestXML, "AppData > " + m[i], val);
  }


  var response = getForm("http://localhost:8081/test/smart?lastname=" + document.getElementById("TextLenghtLastName").value + "&firstname=" +
  document.getElementById("TextLenghtName").value + "&patronymic=" + document.getElementById("TextLenghtSName").value);

  console.log("its" + response);

  var g = 0;
  var zagl = document.createElement("h1");
  zagl.innerHTML = "Форма ответа";
  zagl.className = 'Zag';
  div2.insertBefore(zagl, div2.children[g]);
  g++;

  if (response == "") {
    var p = document.createElement("p");
    var p2 = document.createElement("p");
    p.innerHTML = "Данных по человеку отсутствуют в базе данных!";
    p2.innerHTML = "Повторите ввод данных!";
    p.className = 'pp';
    p2.className = 'pp';
    div2.insertBefore(p, div2.children[g]);
    g++;
    div2.insertBefore(p2, div2.children[g]);
    g++;
//  div2.insertBefore(text, div1.children[k]);
//  k++;
  }



  //alert();
  var p = document.createElement("p");

  var text = document.createTextNode(NodeXml(response, "SNILS"));
  p.className = 'pp1';
  p.innerHTML = "Снилс: " + text.nodeValue;
  div2.insertBefore(p, div2.children[g]);
  g++;

  var p = document.createElement("p");
  var text = document.createTextNode(NodeXml(response, "FIO"));
  p.className = 'pp1';
  p.innerHTML = "ФИО: " + text.nodeValue;
  div2.insertBefore(p, div2.children[g]);
  g++;

  var p = document.createElement("p");
  var text = document.createTextNode(NodeXml(response, "SEX"));
  p.className = 'pp1';
  p.innerHTML = "Пол: " + text.nodeValue;
  div2.insertBefore(p, div2.children[g]);
  g++;

  var p = document.createElement("p");
  var text = document.createTextNode(NodeXml(response, "DATA_BIRTH"));
  p.className = 'pp1';
  p.innerHTML = "Дата рождения: " + text.nodeValue;
  div2.insertBefore(p, div2.children[g]);
  g++;

  var p = document.createElement("p");
  var text = document.createTextNode(NodeXml(response, "DATE_CREATE"));
  p.className = 'pp1';
  p.innerHTML = "Дата создания запроса: " + text.nodeValue;
  div2.insertBefore(p, div2.children[g]);
  g++;
} else {
  alert("Заполните поля!");
}
}

document.getElementById("tab3").onclick = function() {
  document.getElementById('div3').innerHTML = '';

  var g2 = 0;
  var zagl = document.createElement("h1");
  zagl.innerHTML = "История запросов";
  zagl.className = 'Zag';
  div3.insertBefore(zagl, div3.children[g2]);
  g2++;


  var form = getForm("http://localhost:8081/test/hist");
  var elements2 = JSON.parse(form);
  var i = 0, flag = 0;
  var tbdy = document.createElement('tbody');

  var tbl = document.createElement('table');
  tbl.style.width = '100%';
  tbl.setAttribute('border', '0');

  while (flag != 1) {


    if (elements2[i] == undefined) {
      flag = 1;
    } else {
      var tr = document.createElement('tr');


      var td = document.createElement('td');
      td.appendChild(document.createTextNode(elements2[i].sex));
        i == 1 && j == 1 ? td.setAttribute('rowSpan', '2') : null;
        tr.appendChild(td)
      td.id = 'i0_'+i;
      td.className="nev";

      var td = document.createElement('td');
      td.appendChild(document.createTextNode(elements2[i].lastname))
        i == 1 && j == 1 ? td.setAttribute('rowSpan', '2') : null;
        tr.appendChild(td)
      td.id="inf0_"+i;


      var td = document.createElement('td');
      td.appendChild(document.createTextNode(elements2[i].firstname))
        i == 1 && j == 1 ? td.setAttribute('rowSpan', '2') : null;
        tr.appendChild(td)
      td.id="inf1_"+i;

      var td = document.createElement('td');
      td.appendChild(document.createTextNode(elements2[i].patronymic))
        i == 1 && j == 1 ? td.setAttribute('rowSpan', '2') : null;
        tr.appendChild(td)
      td.id="inf2_"+i;

        var td = document.createElement('td');
        td.appendChild(document.createTextNode(elements2[i].snils))
          i == 1 && j == 1 ? td.setAttribute('rowSpan', '2') : null;
          tr.appendChild(td)
        td.id = "i2_"+i;
        td.className="nev";

        var td = document.createElement('td');
        td.appendChild(document.createTextNode(elements2[i].data_create))
          i == 1 && j == 1 ? td.setAttribute('rowSpan', '2') : null;
          tr.appendChild(td)

        var td = document.createElement('td');
        if (elements2[i].ok == true) {
          var img = document.createElement("IMG");
          img.src = "images/true.png"
          img.className = 'imgH';
        } else {
          var img = document.createElement("IMG");
          img.src = "images/false.png"
          img.className = 'imgH';
        }
        td.appendChild(img)
          i == 1 && j == 1 ? td.setAttribute('rowSpan', '2') : null;
          tr.appendChild(td)

        var td = document.createElement('td');
        var data_b = document.createTextNode(elements2[i].data_b);
        td.appendChild(data_b)
          i == 1 && j == 1 ? td.setAttribute('rowSpan', '2') : null;
          tr.appendChild(td);
        td.id = "i1_"+i;
        td.className="nev";

        var td = document.createElement('td');
        var btn = document.createElement (('v' == '\v') ? '<input name="myName">' : 'input'); btn.name = 'myName';
        btn.type = 'button';
        btn.id = "button_"+i;
        btn.className = 'buttonH';
        btn.setAttribute("onclick", "pars(this.id)");
        td.appendChild(btn)
          i == 1 && j == 1 ? td.setAttribute('rowSpan', '2') : null;
          tr.appendChild(td);

    }
      i++;
      tbdy.appendChild(tr);
  }
  tbl.appendChild(tbdy);
  div3.appendChild(tbl);
}


function pars(b) {
  document.getElementById('div2').innerHTML = '';
  $('#tab3').prop('checked', false);
  $('#tab2').prop('checked', true);

  var pip = document.getElementById("inf0_"+b[7]);
  var pip1 = document.getElementById("inf1_"+b[7]);
  var pip2 = document.getElementById("inf2_"+b[7]);

  var elem = document.getElementById("i0_"+b[7]);
  var elem1 = document.getElementById("i1_"+b[7]);
  var elem2 = document.getElementById("i2_"+b[7]);
  //if ((elem.innerHTML != "") && (elem1.innerHTML != "") && (elem2.innerHTML != "")) {
    //alert("Пол: "+elem.innerHTML + "\nДата рождения: " + elem1.innerHTML + "\nСнилс: " + elem2.innerHTML);
  //} else {
    //alert("Статус запроса false!\nДополнительные данные по запросу отсутствуют!");
  //}


  var g = 0;
  var zagl = document.createElement("h1");
  zagl.innerHTML = "Данные о запросе";
  zagl.className = 'Zag';
  div2.insertBefore(zagl, div2.children[g]);
  g++;

  if ((elem.innerHTML != "") && (elem1.innerHTML != "") && (elem2.innerHTML != "")) {

    var p = document.createElement("h2");
    p.className = 'Zag';
    p.innerHTML = pip.innerHTML + " " + pip1.innerHTML + " " + pip2.innerHTML + ":";
    div2.insertBefore(p, div2.children[g]);
    g++;

    var p = document.createElement("p");
    p.className = 'pp1';
    p.innerHTML = "Пол: " + elem.innerHTML;
    div2.insertBefore(p, div2.children[g]);
    g++;
    var p = document.createElement("p");
    p.className = 'pp1';
    p.innerHTML = "Дата рождения: " + elem1.innerHTML;
    div2.insertBefore(p, div2.children[g]);
    g++;
    var p = document.createElement("p");
    p.className = 'pp1';
    p.innerHTML = "Снилс: " + elem2.innerHTML;
    div2.insertBefore(p, div2.children[g]);
    g++;

  } else {
    var p = document.createElement("h2");
    p.className = 'Zag';
    p.innerHTML = pip.innerHTML + " " + pip1.innerHTML + " " + pip2.innerHTML + ":";
    div2.insertBefore(p, div2.children[g]);
    g++;

    var p = document.createElement("p");
    p.className = 'pp1';
    p.innerHTML = "Статус запроса false!";
    div2.insertBefore(p, div2.children[g]);
    g++;

    var p = document.createElement("p");
    p.className = 'pp1';
    p.innerHTML = "Дополнительные данные по запросу отсутствуют!";
    div2.insertBefore(p, div2.children[g]);
    g++;
  }

}
