package xml;

import com.fasterxml.jackson.databind.JsonNode;
import org.dom4j.Element;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class RequiredData {
    public Element createRequiredData(Element root, JsonNode rootNode) {
        Element RequiredData = root.addElement("RequiredData");

        Element KV = RequiredData.addElement("KV");
            Element ObjectLot = KV.addElement("ObjectLot");
                ObjectLot.addAttribute("obj_kind", "002001001000");
                Element Location = ObjectLot.addElement("Location");
                    Element Region = Location.addElement("Region");
                        Region.addText(rootNode.get("mySelect17").textValue());
                    Element City = Location.addElement("City");
                        City.addAttribute("Name", new String(rootNode.get("4_3").textValue().getBytes(ISO_8859_1), UTF_8));
                        City.addAttribute("Type", new String(rootNode.get("mySelect18").textValue().getBytes(ISO_8859_1), UTF_8));
                    Element Street = Location.addElement("Street");
                        Street.addAttribute("Name", new String(rootNode.get("4_4").textValue().getBytes(ISO_8859_1), UTF_8));
                        Street.addAttribute("Type",new String(rootNode.get("mySelect19").textValue().getBytes(ISO_8859_1), UTF_8));
                    Element Level1 = Location.addElement("Level1");
                        Level1.addAttribute("Type", new String(rootNode.get("mySelect20").textValue().getBytes(ISO_8859_1), UTF_8));
                        Level1.addAttribute("Value",new String(rootNode.get("4_5").textValue().getBytes(ISO_8859_1), UTF_8));
                    Element Apartment = Location.addElement("Apartment");
                        Apartment.addAttribute("Type", new String(rootNode.get("mySelect21").textValue().getBytes(ISO_8859_1), UTF_8));
                        Apartment.addAttribute("Value",new String(rootNode.get("4_6").textValue().getBytes(ISO_8859_1), UTF_8));
            Element KV1 = KV.addElement("KV1");
                KV1.addText("true");
            Element KV2 = KV.addElement("KV2");
                KV2.addText("true");
            Element KV3 = KV.addElement("KV3");
                KV3.addText("true");
            Element KV4 = KV.addElement("KV4");
                KV4.addText("true");
            Element KV5 = KV.addElement("KV5");
                KV5.addText("true");
            Element KV6 = KV.addElement("KV6");
                KV6.addText("true");

        return root;
    }
}
