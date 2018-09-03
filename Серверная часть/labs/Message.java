
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

public class Message {
    public Element createMessage(Element process) {
        Element mess = process.addElement(new QName("Message", new Namespace("", "http://smev.gosuslugi.ru/rev111111")));

        Element sender = mess.addElement("Sender");

            Element SenderCode = sender.addElement("Code");
                SenderCode.addText("PFRF01001");
            Element SenderName = sender.addElement("Name");
                SenderName.addText("Пенсионный фонд РФ");

        Element recipient = mess.addElement("Recipient");

            Element RecipientCode = recipient.addElement("Code");
                RecipientCode.addText("103001141");
            Element RecipientName = recipient.addElement("Name");
                RecipientName.addText("Типовой комплекс межведомственного взаимодействия регионального уровня (ТКМВ-РУ)");

        Element originator = mess.addElement("Originator");

            Element OriginatorCode = originator.addElement("Code");
                OriginatorCode.addText("103001141");
            Element OriginatorName = originator.addElement("Name");
                OriginatorName.addText("Типовой комплекс межведомственного взаимодействия регионального уровня (ТКМВ-РУ)");

        Element TypeCode = mess.addElement("TypeCode");
            TypeCode.addText("GSRV");
        Element Status = mess.addElement("Status");
            Status.addText("RESULT");
        Element Date = mess.addElement("Date");
            Date.addText("2017-09-13T03:56:30.972Z");
        Element ExchangeType = mess.addElement("ExchangeType");
            ExchangeType.addText("2");
        Element RequestIdRef = mess.addElement("RequestIdRef");
            RequestIdRef.addText("aa7c1199-44d4-472b-966e-d10ca3088522");
        Element OriginRequestIdRef = mess.addElement("OriginRequestIdRef");
            OriginRequestIdRef.addText("aa7c1199-44d4-472b-966e-d10ca3088522");

        return process;
    }
}
