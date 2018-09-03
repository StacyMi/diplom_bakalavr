package xml_result;

import org.dom4j.Element;

import java.util.List;

public class Body {
    public Element createBody(Element root, String xml_in) {
        Element body = root.addElement("soap:Body");
        //body.addNamespace("ns3","http://portal.fccland.ru/rt/");
        body.addNamespace("wsu","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        body.addAttribute("wsu:Id", "body");
        //body = new
        body = new RequestRequest().createRequestRequest(body, xml_in);

        return root;
    }
}
