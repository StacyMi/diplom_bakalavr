package xml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.dom4j.Element;

public class Declarant {
    public Element createDeclarant(Element root, JsonNode rootNode) {

        Element Declarant = root.addElement("Declarant");
        Declarant.addAttribute("declarant_kind",rootNode.get("mySelect1").textValue());
        Declarant = new Governance().createGovernance(Declarant, rootNode);

        return root;
    }
}
