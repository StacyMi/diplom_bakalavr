package xml_GetStatus;

import org.dom4j.Element;

public class Body {
    public Element createBody(Element root, String idhist) {
        Element body = root.addElement("soap:Body");
        body.addNamespace("wsu","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        body.addAttribute("wsu:Id", "body");

        body = new getStatusRequest().creategetStatusRequest(body, idhist);

        return root;
    }
}
