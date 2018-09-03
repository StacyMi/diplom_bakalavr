
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

import java.util.List;

public class MessageData {
    public Element createMessageData(Element process, List <myTable> base) {
        Element messD = process.addElement(new QName("MessageData", new Namespace("", "http://smev.gosuslugi.ru/rev111111")));
        messD = new AppData().createAppData(messD, base);

        return process;
    }
}
