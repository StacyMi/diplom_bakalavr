package xml_GetStatus;

import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;


public class getStatusRequest {
    public Element creategetStatusRequest(Element body, String idhist) {
        Element createRequestRequest = body.addElement(new QName("getStatusRequest",
                new Namespace("ns4","http://portal.fccland.ru/rt/")));
        createRequestRequest.addNamespace("","http://smev.gosuslugi.ru/rev111111");
        createRequestRequest.addNamespace("ns2","http://portal.fccland.ru/types/");
        createRequestRequest.addNamespace("ns3","http://www.w3.org/2004/08/xop/include");
        createRequestRequest = new Message().createMessage(createRequestRequest);
        createRequestRequest = new MessageData().createMessageData(createRequestRequest, idhist);

        return body;
    }
}
