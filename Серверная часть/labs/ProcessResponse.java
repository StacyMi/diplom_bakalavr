
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

import java.util.List;

public class ProcessResponse {
    public Element createProcessResponse(Element body, List <myTable> base) {
        Element process = body.addElement(new QName("ProcessResponse",new Namespace("","http://service.pfr.socit.ru")));
        process = new Message().createMessage(process);
        process = new MessageData().createMessageData(process, base);
        return body;
    }
}
