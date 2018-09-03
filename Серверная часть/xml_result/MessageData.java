package xml_result;

import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

public class MessageData {
    public Element createMessageData(Element createRequestRequest, String xml_in) {
        //Element MessageData = createRequestRequest.addElement(new QName("MessageData",new Namespace("smev","http://smev.gosuslugi.ru/rev111111")));
        Element MessageData = createRequestRequest.addElement("MessageData");

        Element AppData = MessageData.addElement("AppData");
            //AppData.addNamespace("ns2","http://portal.fccland.ru/types/");
            //AppData.addAttribute("Id","AppData");
            Element createRequestBean = AppData.addElement("ns2:createRequestBean");
                Element okato = createRequestBean.addElement("ns2:okato");
                    okato.addText("29202808001");
                Element requestType = createRequestBean.addElement("ns2:requestType");
                    requestType.addText("558101010000");
        Element AppDocument = MessageData.addElement("AppDocument");
            Element RequestCode = AppDocument.addElement("RequestCode");
                RequestCode.addText("req_c3ea4f8e-da9d-4d87-b644-4ad7b6a1");
            Element BinaryData = AppDocument.addElement("BinaryData");
                BinaryData.addText(xml_in);

        return createRequestRequest;
    }
}
