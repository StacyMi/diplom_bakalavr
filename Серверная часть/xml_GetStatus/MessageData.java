package xml_GetStatus;

import org.dom4j.Element;

public class MessageData {
    public Element createMessageData(Element getStatusRequest, String idhist) {

        Element MessageData = getStatusRequest.addElement("MessageData");

        Element AppData = MessageData.addElement("AppData");
        Element requestNumber = AppData.addElement("ns2:requestNumber");
        requestNumber.addText(idhist);

        return getStatusRequest;
    }
}
