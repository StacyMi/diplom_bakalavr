package xml;

import com.fasterxml.jackson.databind.JsonNode;
import org.dom4j.*;

public class RequestGKN {
    public String generateRequestGKN(JsonNode rootNode) {
        Document xml = DocumentHelper.createDocument();
        Element root = xml.addElement("RequestGKN");
        root.addNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        root = new eDocument().createeDocument(root);
        root = new Request().createRequest(root,rootNode);

        return root.asXML();
    }
}

