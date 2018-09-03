package xml;

import com.fasterxml.jackson.databind.JsonNode;
import org.dom4j.Element;

public class Request {
    public Element createRequest(Element root, JsonNode rootNode) {
        Element Request = root.addElement("Request");
        Request = new Declarant().createDeclarant(Request, rootNode);
        Request = new RequiredData().createRequiredData(Request, rootNode);
        Request = new Delivery().createDelivery(Request, rootNode);
        Request = new Applied_Documents().createApplied_Documents(Request, rootNode);
        Request = new MunicipalService().createMunicipalService(Request, rootNode);

        return root;
    }
}
