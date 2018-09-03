package xml;

import com.fasterxml.jackson.databind.JsonNode;
import org.dom4j.Element;

public class MunicipalService {
    public Element createMunicipalService(Element root, JsonNode rootNode) {
        Element MunicipalService = root.addElement("MunicipalService");

        return root;
    }
}
