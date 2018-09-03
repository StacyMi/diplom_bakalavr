package xml;

import com.fasterxml.jackson.databind.JsonNode;
import org.dom4j.Element;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Applied_Documents {
    public Element createApplied_Documents(Element root, JsonNode rootNode) {
        Element Applied_Documents = root.addElement("Applied_Documents");

        Element Applied_Document = Applied_Documents.addElement("Applied_Document");
            Element Code_Document = Applied_Document.addElement("Code_Document");
                Code_Document.addText("558101010000");
            Element Name = Applied_Document.addElement("Name");
                Name.addText(new String(rootNode.get("5_1").textValue().getBytes(ISO_8859_1), UTF_8));
            Element Number = Applied_Document.addElement("Number");
                Number.addText("26-0-1-21/4001/2011-162");
            Element Date = Applied_Document.addElement("Date");
                Date.addText("2012-07-23");
            Element Images = Applied_Document.addElement("Images");
                Element Image = Images.addElement("Image");
                    Image.addAttribute("Name", new String(rootNode.get("5_2_name").textValue().getBytes(ISO_8859_1), UTF_8));
                        String str = new String(rootNode.get("5_2_path").textValue().getBytes(ISO_8859_1), UTF_8);
                        //преобразовываем строку в массив
                        char[] chArray = str.toCharArray();
                        str = "";
                        //перебираем все элементы массива
                        for(int i = 0; i<chArray.length; i++){
                            //находим пробел
                            if(chArray[i] == '/'){
                               //заменяем на точку
                                str = str + "\\";
                            } else {
                                str = str + chArray[i];
                            }
                        }
                        //выводим измененную строку
                        //System.out.println(str);
                    Image.addAttribute("URL", str);
            Element Quantity = Applied_Document.addElement("Quantity");
                Element Original = Quantity.addElement("Original");
                    Original.addAttribute("Quantity","1");
                    Original.addAttribute("Quantity_Sheet","1");

        return root;
    }
}
