package xml_GetStatus;

import org.dom4j.Element;

public class Message {
    public Element createMessage(Element getStatusRequest) {
        Element Message = getStatusRequest.addElement("Message");

        Element Sender = Message.addElement("Sender");
        Element Code = Sender.addElement("Code");
        Code.addText("FMS001001");
        Element Name = Sender.addElement("Name");
        Name.addText("ФМС");
        Element Recipient = Message.addElement("Recipient");
        Element Code2 = Recipient.addElement("Code");
        Code2.addText("RRTR01001");
        Element Name2 = Recipient.addElement("Name");
        Name2.addText("Росреестр");
        Element Originator = Message.addElement("Originator");
        Element Code3 = Originator.addElement("Code");
        Code3.addText("FMS001001");
        Element Name3 = Originator.addElement("Name");
        Name3.addText("ФМС");
        Element TypeCode = Message.addElement("TypeCode");
        TypeCode.addText("GSRV");
        Element Status = Message.addElement("Status");
        Status.addText("REQUEST");
        Element Date = Message.addElement("Date");
        Date.addText("2018-04-19T17:15:36.730+07:00");
        Element ExchangeType = Message.addElement("ExchangeType");
        ExchangeType.addText("2");
        Element ServiceCode = Message.addElement("ServiceCode");
        ServiceCode.addText("10000013628");
        Element CaseNumber = Message.addElement("CaseNumber");
        CaseNumber.addText("1/2");
        Element TestMsg = Message.addElement("TestMsg");

        return getStatusRequest;
    }
}
