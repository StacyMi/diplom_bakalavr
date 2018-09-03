package xml;

import com.fasterxml.jackson.databind.JsonNode;
import org.dom4j.Element;

public class Delivery {
    public Element createDelivery(Element root, JsonNode rootNode) {
        Element Delivery = root.addElement("Delivery");

        Element WebService = Delivery.addElement("WebService");
            WebService.addText("True");

        return root;
    }
}
