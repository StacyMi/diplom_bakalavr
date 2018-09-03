
import org.dom4j.Element;

import java.util.List;

public class Body {
    public Element createBody(Element root, List <myTable> base) {
        Element body = root.addElement("soap:Body");
        body.addAttribute("wsu:Id", "SigID-ed0cbe42-9838-1e71-2190");
        body = new ProcessResponse().createProcessResponse(body, base);

        return root;
    }
}
