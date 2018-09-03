
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

public class Soap {
    public String generateSoap(List <myTable> base) {
        Document xml = DocumentHelper.createDocument();
        Element root = xml.addElement("soap:Envelope");
        root.addNamespace("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        root.addNamespace("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        //System.out.println(root.asXML());
        root = new Header().createHeader(root);
        root = new Body().createBody(root, base);



        return root.asXML();
    }

}
