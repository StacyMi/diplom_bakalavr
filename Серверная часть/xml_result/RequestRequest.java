package xml_result;

import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

public class RequestRequest {
    public Element createRequestRequest(Element body, String xml_in) {
        Element createRequestRequest = body.addElement(new QName("createRequestRequest",new Namespace("ns4","http://portal.fccland.ru/rt/")));
        createRequestRequest.addNamespace("","http://smev.gosuslugi.ru/rev111111");
        createRequestRequest.addNamespace("ns2","http://portal.fccland.ru/types/");
        createRequestRequest.addNamespace("ns3","http://www.w3.org/2004/08/xop/include");
        createRequestRequest = new Message().createMessage(createRequestRequest);
        createRequestRequest = new MessageData().createMessageData(createRequestRequest, xml_in);

        return body;
    }
}
