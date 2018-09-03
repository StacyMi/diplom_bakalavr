
import org.dom4j.Element;

public class Header {
    public Element createHeader(Element root) {
        Element header = root.addElement("soap:Header");
        return root;
    }
}
