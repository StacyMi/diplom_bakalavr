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
function NodeXml(xml, selector){
  var parser = new DOMParser();
  var xmlDoc = parser.parseFromString(xml, "text/xml");
  var selectedNode = xmlDoc.querySelector(selector);
  return selectedNode.textContent;
}

var k = 0;
//Категория заявителя
var form1 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/b9c0e410-ad29-4c78-a0e5-4d4d60b7dfc2");
var elements1 = JSON.parse(form1);
var n1 = elements1.documents.length;
mySelect1.options.length = n1;
for (var k = 0; k < n1; k++) {
  mySelect1.options[k].text = elements1.documents[k].label;
  mySelect1.options[k].value = elements1.documents[k].value;
}
function change() {
    var select = document.getElementById("mySelect1"); // Выбираем  select по id
    var value = select.options[select.selectedIndex].value; // Значение value для выбранного option
    var text = select.options[select.selectedIndex].text; // Текстовое значение для выбранного option
    //alert("Value: " + value + "\nТекст: " + text); // Вывод алерта для проверки значений
    if (value == "357099000000") { //Если "Иное" добавляем поле
      document.getElementById("p1_1").style.display = "block";
      document.getElementById("1_1").style.display = "block";
      //$("#1_1").attr('required', true);
    } else {
      document.getElementById("p1_1").style.display = "none";
      document.getElementById("1_1").style.display = "none";
      //$("#1_1").attr('required', false);
    }

}

//_______________________________________ для сведений об органе власти


//Орган власти
var form2 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/ff549c1f-a593-40fb-b8a1-264e282cf56a");
var elements2 = JSON.parse(form2);
var n2 = elements2.documents.length;
mySelect2.options.length = n2;
for (var k = 0; k < n2; k++) {
  mySelect2.options[k].text = elements2.documents[k].label;
  mySelect2.options[k].value = elements2.documents[k].value;
}
//Регион
var form3 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/fac2d3d4-e7c2-40c4-b7e1-ebabd9d34895");
var elements3 = JSON.parse(form3);
var n3 = elements3.documents.length;
mySelect3.options.length = n3;
for (var k = 0; k < n3; k++) {
  mySelect3.options[k].text = elements3.documents[k].label;
  mySelect3.options[k].value = elements3.documents[k].value;
}
function change2() {
    var select = document.getElementById("mySelect3"); // Выбираем  select по id
    var value = select.options[select.selectedIndex].value; // Значение value для выбранного option
    var text = select.options[select.selectedIndex].text; // Текстовое значение для выбранного option
    //alert("Value: " + value + "\nТекст: " + text); // Вывод алерта для проверки значений
    if ((value == "98") || (value == "99")) {
      document.getElementById("p2_7").style.display = "block";
      document.getElementById("2_7").style.display = "block";
      $("#2_7").attr('required', true);
      document.getElementById("p2_8").style.display = "block";
      document.getElementById("2_8").style.display = "block";
      $("#2_8").attr('required', true);
    } else {
      document.getElementById("p2_7").style.display = "none";
      document.getElementById("2_7").style.display = "none";
      $("#2_7").attr('required', false);
      document.getElementById("p2_8").style.display = "none";
      document.getElementById("2_8").style.display = "none";
      $("#2_8").attr('required', false);
    }
}

//Муниципальное образование
var form4 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/c3ae0733-c6d4-4201-ac5f-60f1c4a23afe");
var elements4 = JSON.parse(form4);
var n4 = elements4.documents.length;
mySelect4.options.length = n4;
for (var k = 0; k < n4; k++) {
  mySelect4.options[k].text = elements4.documents[k].label;
  mySelect4.options[k].value = elements4.documents[k].value;
}
//Улица
var form5 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/02a54468-1cb9-4131-9e2c-152edddf84e8");
var elements5 = JSON.parse(form5);
var n5 = elements5.documents.length;
mySelect5.options.length = n5;
for (var k = 0; k < n5; k++) {
  mySelect5.options[k].text = elements5.documents[k].label;
  mySelect5.options[k].value = elements5.documents[k].value;
}
//Дом
var form6 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/d1355775-4e3c-4576-8bdf-6f234623c4da");
var elements6 = JSON.parse(form6);
var n6 = elements6.documents.length;
mySelect6.options.length = n6;
for (var k = 0; k < n6; k++) {
  mySelect6.options[k].text = elements6.documents[k].label;
  mySelect6.options[k].value = elements6.documents[k].value;
}
//Номер квартиры
var form7 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/46b5d7da-4322-424a-9909-a0e68a02e259");
var elements7 = JSON.parse(form7);
var n7 = elements7.documents.length;
mySelect7.options.length = n7;
for (var k = 0; k < n7; k++) {
  mySelect7.options[k].text = elements7.documents[k].label;
  mySelect7.options[k].value = elements7.documents[k].value;
}


//_______________________________________для сведений об заявителе

// проверяем чтобы Дата выдачи документа не превышала текущую дату
function change3() {
  var dateToday = new Date();
  //$('#3_1_6').change(function () {
    var DateB = new Date($('#3_1_6').val());
    if (DateB.getFullYear() >= dateToday.getFullYear()) {
      if (DateB.getFullYear() > dateToday.getFullYear()) {
        alert('Дата выдачи документа превышает текущую дату!');
        $('#3_1_6').val(dateToday);
      } else {
        if (DateB.getMonth() >= dateToday.getMonth()) {
          if (DateB.getMonth() > dateToday.getMonth()) {
            alert('Дата выдачи документа превышает текущую дату!');
            $('#3_1_6').val(dateToday);
          } else {
            if (DateB.getDate() >= dateToday.getDate()) {
              if (DateB.getDate() > dateToday.getDate()) {
                alert('Дата выдачи документа превышает текущую дату!');
                $('#3_1_6').val(dateToday);
              }
            }
          }
        }
      }
    }
//  });
}

//Вид документа, удостоверяющего личность
var form8 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/4326b926-6384-434e-b38b-b42f908076cc");
var elements8 = JSON.parse(form8);
var n8 = elements8.documents.length;
mySelect8.options.length = n8;
for (var k = 0; k < n8; k++) {
  mySelect8.options[k].text = elements8.documents[k].label;
  mySelect8.options[k].value = elements8.documents[k].value;
}
//Регион
var form9 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/fac2d3d4-e7c2-40c4-b7e1-ebabd9d34895");
var elements9 = JSON.parse(form9);
var n9 = elements9.documents.length;
mySelect9.options.length = n9;
for (var k = 0; k < n9; k++) {
  mySelect9.options[k].text = elements9.documents[k].label;
  mySelect9.options[k].value = elements9.documents[k].value;
}
function change4() {
    var select = document.getElementById("mySelect9"); // Выбираем  select по id
    var value = select.options[select.selectedIndex].value; // Значение value для выбранного option
    var text = select.options[select.selectedIndex].text; // Текстовое значение для выбранного option
    //alert("Value: " + value + "\nТекст: " + text); // Вывод алерта для проверки значений
    if ((value == "98") || (value == "99")) {
      document.getElementById("p3_2_s1").style.display = "block";
      document.getElementById("3_2_s1").style.display = "block";
      //$("#3_2_s1").attr('required', true);
      document.getElementById("p3_2_s2").style.display = "block";
      document.getElementById("3_2_s2").style.display = "block";
      //$("#3_2_s2").attr('required', true);
    } else {
      document.getElementById("p3_2_s1").style.display = "none";
      document.getElementById("3_2_s1").style.display = "none";
      //$("#3_2_s1").attr('required', false);
      document.getElementById("p3_2_s2").style.display = "none";
      document.getElementById("3_2_s2").style.display = "none";
      //$("#3_2_s2").attr('required', false);
    }
}
//Муниципальное образование
var form10 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/c3ae0733-c6d4-4201-ac5f-60f1c4a23afe");
var elements10 = JSON.parse(form10);
var n10 = elements10.documents.length;
mySelect10.options.length = n10;
for (var k = 0; k < n10; k++) {
  mySelect10.options[k].text = elements10.documents[k].label;
  mySelect10.options[k].value = elements10.documents[k].value;
}
//Улица
var form11 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/02a54468-1cb9-4131-9e2c-152edddf84e8");
var elements11 = JSON.parse(form11);
var n11 = elements11.documents.length;
mySelect11.options.length = n11;
for (var k = 0; k < n11; k++) {
  mySelect11.options[k].text = elements11.documents[k].label;
  mySelect11.options[k].value = elements11.documents[k].value;
}
//Дом
var form12 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/0bbe47ab-da9b-4359-bfa3-c46e6cc11065");
var elements12 = JSON.parse(form12);
var n12 = elements12.documents.length;
mySelect12.options.length = n12;
for (var k = 0; k < n12; k++) {
  mySelect12.options[k].text = elements12.documents[k].label;
  mySelect12.options[k].value = elements12.documents[k].value;
}
//Корпус
var form13 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/2344911c-4edb-41e3-8113-7769bac4fa78");
var elements13 = JSON.parse(form13);
var n13 = elements13.documents.length;
mySelect13.options.length = n13;
for (var k = 0; k < n13; k++) {
  mySelect13.options[k].text = elements13.documents[k].label;
  mySelect13.options[k].value = elements13.documents[k].value;
}
//Строение
var form14 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/fcc80080-77c5-494c-85a8-ed0dd1074cab");
var elements14 = JSON.parse(form14);
var n14 = elements14.documents.length;
mySelect14.options.length = n14;
for (var k = 0; k < n14; k++) {
  mySelect14.options[k].text = elements14.documents[k].label;
  mySelect14.options[k].value = elements14.documents[k].value;
}
//Квартира
var form15 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/46b5d7da-4322-424a-9909-a0e68a02e259");
var elements15 = JSON.parse(form15);
var n15 = elements15.documents.length;
mySelect15.options.length = n15;
for (var k = 0; k < n15; k++) {
  mySelect15.options[k].text = elements15.documents[k].label;
  mySelect15.options[k].value = elements15.documents[k].value;
}
//Тип представителя заявителя
var form16 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/ef87a4ed-64a0-424a-8c23-ab773f47873d");
var elements16 = JSON.parse(form16);
var n16 = elements16.documents.length;
mySelect16.options.length = n16;
for (var k = 0; k < n16; k++) {
  mySelect16.options[k].text = elements16.documents[k].label;
  mySelect16.options[k].value = elements16.documents[k].value;
}



//_______________________________________для сведений об объекте запроса



//Регион
var form17 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/fac2d3d4-e7c2-40c4-b7e1-ebabd9d34895");
var elements17 = JSON.parse(form17);
var n17 = elements17.documents.length;
mySelect17.options.length = n17;
for (var k = 0; k < n17; k++) {
  mySelect17.options[k].text = elements17.documents[k].label;
  mySelect17.options[k].value = elements17.documents[k].value;
}
function change5() {
    var select = document.getElementById("mySelect17"); // Выбираем  select по id
    var value = select.options[select.selectedIndex].value; // Значение value для выбранного option
    var text = select.options[select.selectedIndex].text; // Текстовое значение для выбранного option
    //alert("Value: " + value + "\nТекст: " + text); // Вывод алерта для проверки значений
    if ((value == "98") || (value == "99")) {
      document.getElementById("p4_1").style.display = "block";
      document.getElementById("4_1").style.display = "block";
      $("#4_1").attr('required', true);
      document.getElementById("p4_2").style.display = "block";
      document.getElementById("4_2").style.display = "block";
      $("#4_2").attr('required', true);
    } else {
      document.getElementById("p4_1").style.display = "none";
      document.getElementById("4_1").style.display = "none";
      $("#4_1").attr('required', false);
      document.getElementById("p4_2").style.display = "none";
      document.getElementById("4_2").style.display = "none";
      $("#4_2").attr('required', false);
    }
}
//Муниципальное образование
var form18 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/c3ae0733-c6d4-4201-ac5f-60f1c4a23afe");
var elements18 = JSON.parse(form18);
var n18 = elements18.documents.length;
mySelect18.options.length = n18;
for (var k = 0; k < n18; k++) {
  mySelect18.options[k].text = elements18.documents[k].label;
  mySelect18.options[k].value = elements18.documents[k].value;
}
//Улица
var form19 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/02a54468-1cb9-4131-9e2c-152edddf84e8");
var elements19 = JSON.parse(form19);
var n19 = elements19.documents.length;
mySelect19.options.length = n19;
for (var k = 0; k < n19; k++) {
  mySelect19.options[k].text = elements19.documents[k].label;
  mySelect19.options[k].value = elements19.documents[k].value;
}
//Дом
var form20 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/d1355775-4e3c-4576-8bdf-6f234623c4da");
var elements20 = JSON.parse(form20);
var n20 = elements20.documents.length;
mySelect20.options.length = n20;
for (var k = 0; k < n20; k++) {
  mySelect20.options[k].text = elements20.documents[k].label;
  mySelect20.options[k].value = elements20.documents[k].value;
}
//Номер квартиры
var form21 = getForm("http://109.202.0.226/adapter-web/rest/dictionary/46b5d7da-4322-424a-9909-a0e68a02e259");
var elements21 = JSON.parse(form21);
var n21 = elements21.documents.length;
mySelect21.options.length = n21;
for (var k = 0; k < n21; k++) {
  mySelect21.options[k].text = elements21.documents[k].label;
  mySelect21.options[k].value = elements21.documents[k].value;
}



function checkForm(){     //  функция проверки заполнености полей
  /*var i;
  for (i = 1; i <=6; i++) {
    if (document.getElementById('2_'+i).value=="")
      return false;
  }
  for (i = 1; i <=7; i++) {
    if (i != 3) { // Кроме 3(го), потому что это Отчество
      if (document.getElementById('3_1_'+i).value=="")
        return false;
    }
  }
  for (i = 1; i <=7; i++) {
    if (document.getElementById('3_2_'+i).value=="")
      return false;
  }
  for (i = 1; i <=3; i++) {
    if (document.getElementById('3_3_'+i).value=="")
      return false;
  }
  for (i = 3; i <=6; i++) {
    if (document.getElementById('4_'+i).value=="")
      return false;
  }
  for (i = 1; i <=2; i++) {
    if (document.getElementById('5_'+i).value=="")
      return false;
  }
*/
  return true;
};

document.getElementById("tab3").onclick = function() {
  document.getElementById('div3').innerHTML = '';

  var g2 = 0;
  var zagl = document.createElement("h1");
  zagl.innerHTML = "История запросов";
  zagl.className = 'Zag';
  div3.insertBefore(zagl, div3.children[g2]);
  g2++;

  var tbdy = document.createElement('tbody');
  var tbl = document.createElement('table');

//__________Заголовки таблицы
  var tr = document.createElement('tr');
  tr.className="tableZag";
    var td = document.createElement('td');
      td.appendChild(document.createTextNode("Фамилия"));
      tr.appendChild(td);
    var td = document.createElement('td');
      td.appendChild(document.createTextNode("Имя"));
      tr.appendChild(td);
    var td = document.createElement('td');
      td.appendChild(document.createTextNode("Отчество"));
      tr.appendChild(td);
    var td = document.createElement('td');
        td.appendChild(document.createTextNode("Номер запроса"));
        tr.appendChild(td);
    var td = document.createElement('td');
        td.appendChild(document.createTextNode("Дата создания"));
        tr.appendChild(td);
    var td = document.createElement('td');
        td.appendChild(document.createTextNode("Запрос статуса"));
        tr.appendChild(td);
  tbdy.appendChild(tr);
//__________
    var form = getForm("http://localhost:8081/test/hist");
    var elements = JSON.parse(form);
  var flag = 0, i = 0;

  while (flag != 1) {
      if (elements[i] == undefined) {
        flag = 1;
      } else {
        var tr = document.createElement('tr');
        tr.className="tableStr";
        var td = document.createElement('td');
          td.appendChild(document.createTextNode(elements[i].lastname));
          td.id = "l_" + i;
          tr.appendChild(td);
        var td = document.createElement('td');
          td.appendChild(document.createTextNode(elements[i].firstname));
          td.id = "f_" + i;
          tr.appendChild(td);
        var td = document.createElement('td');
          td.appendChild(document.createTextNode(elements[i].patronymic));
          tr.appendChild(td);
        var td = document.createElement('td');
          td.appendChild(document.createTextNode(elements[i].idhist));
          td.id = "id_" + i;
          tr.appendChild(td);
        var td = document.createElement('td');
          td.appendChild(document.createTextNode(elements[i].data_create));
          tr.appendChild(td);
        var td = document.createElement('td');
          var btn = document.createElement (('v' == '\v') ? '<input name="myName">' : 'input'); btn.name = 'myName';
          btn.type = 'button';
          btn.id = "button_"+i;
          btn.className = 'buttonH';
          btn.setAttribute("onclick", "pars(this.id)");
          td.appendChild(btn);
          tr.appendChild(td);
      }
      i++;
      tbdy.appendChild(tr);
    }
    tbl.appendChild(tbdy);
    div3.appendChild(tbl);
};
function pars(b) {
  document.getElementById('div2').innerHTML = '';
  $('#tab3').prop('checked', false);
  $('#tab2').prop('checked', true);
  //________вычисляем индекс
  var ind = 7, str = ""; // b[7] - т.к. берем 7ой символ(т.е. индекс button_"x")
  while (b[ind] != undefined) {
    str = str + b[ind];
    ind++;
  }
  //________
  var number = document.getElementById("id_"+str);
  var lastname = document.getElementById("l_"+str);
  var firstname = document.getElementById("f_"+str);

  var GetStatus_xml = getForm("http://localhost:8081/test/GetStatus?idhist=" + number);
  //console.log("-2-->" + GetStatus_xml); // xml с запросом статуса
  //var GetStatus_otv = postForm("http://smev-mvf.test.gosuslugi.ru:7777/gateway/services/SID0003350", GetStatus_xml);
  var GetStatus_otv = getForm("GetStatus_otv.xml");
  var result_status = NodeXml(GetStatus_otv, "statusMessage");
  var save = $(GetStatus_otv).find("BinaryData").text(); // ссылка в формате b64
  //var save_addr = getForm("http://localhost:8081/test/b64?str=" + save); // ссылка на скачивание файлов
  //alert(save);

//_______Отрисовка ответа(результата)
  var g = 0;
  var zagl = document.createElement("h1");
  zagl.innerHTML = "Данные о запросе";
  zagl.className = 'Zag';
  div2.insertBefore(zagl, div2.children[g]);
  g++;

  var p = document.createElement("h2");
  p.className = 'ZagMin2';
  p.innerHTML = "Заявитель:   " + lastname.innerHTML + " " + firstname.innerHTML;
  div2.insertBefore(p, div2.children[g]);
  g++;

  var p = document.createElement("h2");
  p.className = 'ZagMin2';
  p.innerHTML = "Номер заявки:   " + number.innerHTML;
  div2.insertBefore(p, div2.children[g]);
  g++;

  var p = document.createElement("h2");
  p.className = 'ZagMin2';
  p.innerHTML = "Статус поданной заявки:   " + result_status;
  div2.insertBefore(p, div2.children[g]);
  g++;

  if (result_status == "Завершена") {
    var p = document.createElement("p");
    var btn = document.createElement('a');
    btn.innerHTML = "Получить выписку об объекте недвижимости";
    btn.download = "vipiska.zip";
    btn.setAttribute('href', "data:application/zip;base64," + save);
    div2.insertBefore(p, div2.children[g]);
    g++;
    div2.insertBefore(btn, div2.children[g]);
    g++;
  }
};


document.getElementById("Send").onclick = function() {
      if (checkForm() == true) {
        //alert("Данные успешно отправлены!");
        document.getElementById('div2').innerHTML = ''; // очищаем область вкладки (ответ)
        $('#tab1').prop('checked', false);  // делаем неактивным вкладку (запрос)
        $('#tab2').prop('checked', true);   // делаем активным вкладку (ответ)

        //парсим путь к файлу
        var str = document.getElementById("5_2").value;
        var str_n = str.length;
        var str1 = "";  //name_file
        var str2 = "";  //path_file
        var f = 0, f2 = 0;
        if (str_n > 0) {
          while (f != 1) {
            for (var i = str_n - 1; i >= 0; i--) {
              if ((str[i] != "\\") && (f2 == 0)) {
                str1 = str[i] + str1;
              } else {
                f2 = 1;
                if (str[i] == "\\") {
                  str2 = "/" + str2;
                } else {
                  str2 = str[i] + str2;
                }
              }
              f = 1;
            }
          }
        }
        console.log("str1--" + str1);
        console.log("str2--" + str2);
        var xml = getForm("http://localhost:8081/test/smart?mySelect1=" + document.getElementById("mySelect1").value
            //сведения об органе власти
            + "&2_1=" + document.getElementById("2_1").value
            + "&mySelect2=" + document.getElementById("mySelect2").value
            + "&2_2=" + document.getElementById("2_2").value
            + "&mySelect3=" + document.getElementById("mySelect3").value
            + "&mySelect4=" + document.getElementById("mySelect4").value
            + "&2_3=" + document.getElementById("2_3").value
            + "&mySelect5=" + document.getElementById("mySelect5").value
            + "&2_4=" + document.getElementById("2_4").value
            + "&mySelect6=" + document.getElementById("mySelect6").value
            + "&2_5=" + document.getElementById("2_5").value
            + "&mySelect7=" + document.getElementById("mySelect7").value
            + "&2_6=" + document.getElementById("2_6").value
            //информация о заявителе
            + "&3_1_1=" + document.getElementById("3_1_1").value
            + "&3_1_2=" + document.getElementById("3_1_2").value
            + "&3_1_3=" + document.getElementById("3_1_3").value
            + "&mySelect8=" + document.getElementById("mySelect8").value
            + "&3_1_4=" + document.getElementById("3_1_4").value
            + "&3_1_5=" + document.getElementById("3_1_5").value
            + "&3_1_6=" + document.getElementById("3_1_6").value
            + "&3_1_7=" + document.getElementById("3_1_7").value
            //__________
            + "&3_2_1=" + document.getElementById("3_2_1").value
            + "&mySelect9=" + document.getElementById("mySelect9").value
            + "&mySelect10=" + document.getElementById("mySelect10").value
            + "&3_2_2=" + document.getElementById("3_2_2").value
            + "&mySelect11=" + document.getElementById("mySelect11").value
            + "&3_2_3=" + document.getElementById("3_2_3").value
            + "&mySelect12=" + document.getElementById("mySelect12").value
            + "&3_2_4=" + document.getElementById("3_2_4").value
            + "&mySelect13=" + document.getElementById("mySelect13").value
            + "&3_2_5=" + document.getElementById("3_2_5").value
            + "&mySelect14=" + document.getElementById("mySelect14").value
            + "&3_2_6=" + document.getElementById("3_2_6").value
            + "&mySelect15=" + document.getElementById("mySelect15").value
            + "&3_2_7=" + document.getElementById("3_2_7").value
            //________
            + "&3_3_1=" + document.getElementById("3_3_1").value
            + "&3_3_2=" + document.getElementById("3_3_2").value
            + "&3_3_3=" + document.getElementById("3_3_3").value
            + "&mySelect16=" + document.getElementById("mySelect16").value
            //Блок сведений об объекте запроса
            + "&mySelect17=" + document.getElementById("mySelect17").value
            + "&mySelect18=" + document.getElementById("mySelect18").value
            + "&4_3=" + document.getElementById("4_3").value
            + "&mySelect19=" + document.getElementById("mySelect19").value
            + "&4_4=" + document.getElementById("4_4").value
            + "&mySelect20=" + document.getElementById("mySelect20").value
            + "&4_5=" + document.getElementById("4_5").value
            + "&mySelect21=" + document.getElementById("mySelect21").value
            + "&4_6=" + document.getElementById("4_6").value
            //Сведения о приложенных документах
            + "&5_1=" + document.getElementById("5_1").value
            + "&5_2_name=" + str1
            + "&5_2_path=" + str2

      );

        //console.log("xml \t" + xml); // xml с данными с формы запроса в формате b64
        var CreateRequest_xml = getForm("http://localhost:8081/test/CreateRequest?in_xml=" + xml);
        console.log("CreateRequest \t" + CreateRequest_xml); // xml с запросом на предоставлене сведений
        //var CreateRequest_otv = postForm("http://smev-mvf.test.gosuslugi.ru:7777/gateway/services/SID0003350", CreateRequest_xml);
        var CreateRequest_otv = getForm("CreateRequest_otv.xml");
        //console.log("CreateRequest_otv \t" + CreateRequest_otv); // xml полученный ответ(с кодом)

        var number = NodeXml(CreateRequest_otv, "requestNumber"); // возвращает номер запроса(из полученного ответа xml)
        alert(number);
        var status = getForm("http://localhost:8081/test/IDhist?lastname=" + document.getElementById("3_1_1").value
                                + "&firstname=" + document.getElementById("3_1_2").value
                                + "&patronymic=" + document.getElementById("3_1_3").value
                                + "&idhist=" + number); // добавляем в историю
        var GetStatus_xml = getForm("http://localhost:8081/test/GetStatus?idhist=" + number);
        console.log("-2-->" + GetStatus_xml); // xml с запросом статуса
        //var GetStatus_otv = postForm("http://smev-mvf.test.gosuslugi.ru:7777/gateway/services/SID0003350", GetStatus_xml);
        var GetStatus_otv = getForm("GetStatus_otv.xml");
        var result_status = NodeXml(GetStatus_otv, "statusMessage");
        //var save = NodeXml(GetStatus_otv, "BinaryData"); // ссылка в формате b64
        var save = $(GetStatus_otv).find("BinaryData").text(); // ссылка в формате b64
        //var save_addr = getForm("http://localhost:8081/test/b64?str=" + save); // ссылка на скачивание файлов
        //alert(save_addr.nodeValue);

        //_______Отрисовка ответа(результата)
        var g = 0;
        var zagl = document.createElement("h1");
        zagl.innerHTML = "Данные о запросе";
        zagl.className = 'Zag';
        div2.insertBefore(zagl, div2.children[g]);
        g++;

        var p = document.createElement("h2");
        p.className = 'ZagMin2';
        p.innerHTML = "Заявитель:    " + document.getElementById("3_1_1").value + " " + document.getElementById("3_1_2").value;
        div2.insertBefore(p, div2.children[g]);
        g++;

        var p = document.createElement("h2");
        p.className = 'ZagMin2';
        p.innerHTML = "Номер заявки:    " + number;
        div2.insertBefore(p, div2.children[g]);
        g++;

        var p = document.createElement("h2");
        p.className = 'ZagMin2';
        p.innerHTML = "Статус поданной заявки:   " + result_status;
        div2.insertBefore(p, div2.children[g]);
        g++;

        if (result_status == "Завершена") {
          var p = document.createElement("p");
          var btn = document.createElement('a');
          btn.innerHTML = "Получить выписку об объекте недвижимости";
          btn.download = "vipiska.zip";
          btn.setAttribute('href', "data:application/zip;base64," + save);
          div2.insertBefore(p, div2.children[g]);
          g++;
          div2.insertBefore(btn, div2.children[g]);
          g++;
        }



      }else{
        //alert("Заполните обязательные поля!");
      }
};
