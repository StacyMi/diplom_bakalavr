package xml;

import org.dom4j.Element;

public class eDocument {
    public Element createeDocument(Element root) {
        Element eDocument = root.addElement("eDocument");
        eDocument.addAttribute("Version", "1.03");
        eDocument.addAttribute("GUID", "dcea0456-fb46-4714-9baf-d53ff76679d2");

        return root;
    }
}
