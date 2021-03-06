package xml_result;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class soap {
    public String generateSoap(String xml_in) {
        Document xml = DocumentHelper.createDocument();
        Element root = xml.addElement("soap:Envelope");
        root.addNamespace("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        root = new Header().createHeader(root);
        root = new Body().createBody(root, xml_in);
        return root.asXML();
    }
}
