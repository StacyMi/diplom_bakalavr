package xml;

import com.fasterxml.jackson.databind.JsonNode;
import org.dom4j.Element;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Governance {
    public Element createGovernance(Element root, JsonNode rootNode) {


        Element Governance = root.addElement("Governance");

        Element Name = Governance.addElement("Name");
            Name.addText(new String(rootNode.get("2_1").textValue().getBytes(ISO_8859_1), UTF_8));
        Element Governance_Code = Governance.addElement("Governance_Code");
            Governance_Code.addText(rootNode.get("mySelect2").textValue());
        Element email = Governance.addElement("E-mail");
            email.addText(rootNode.get("2_2").textValue());
        Element Location = Governance.addElement("Location");
            Element Region = Location.addElement("Region");
                Region.addText(rootNode.get("mySelect3").textValue());
            Element City = Location.addElement("City");
                City.addAttribute("Name", new String(rootNode.get("2_3").textValue().getBytes(ISO_8859_1), UTF_8));
                City.addAttribute("Type", new String(rootNode.get("mySelect4").textValue().getBytes(ISO_8859_1), UTF_8));
            Element Street = Location.addElement("Street");
                Street.addAttribute("Name", new String(rootNode.get("2_4").textValue().getBytes(ISO_8859_1), UTF_8));
                Street.addAttribute("Type",new String(rootNode.get("mySelect5").textValue().getBytes(ISO_8859_1), UTF_8));
            Element Level1 = Location.addElement("Level1");
                Level1.addAttribute("Type", new String(rootNode.get("mySelect6").textValue().getBytes(ISO_8859_1), UTF_8));
                Level1.addAttribute("Value",new String(rootNode.get("2_5").textValue().getBytes(ISO_8859_1), UTF_8));
            Element Apartment = Location.addElement("Apartment");
                Apartment.addAttribute("Type", new String(rootNode.get("mySelect7").textValue().getBytes(ISO_8859_1), UTF_8));
                Apartment.addAttribute("Value",new String(rootNode.get("2_6").textValue().getBytes(ISO_8859_1), UTF_8));
        //Информация о заявителе
        Element Agent = Governance.addElement("Agent");
            Element FIO = Agent.addElement("FIO");
                Element Surname = FIO.addElement("Surname");
                    Surname.addText(new String(rootNode.get("3_1_1").textValue().getBytes(ISO_8859_1), UTF_8));
                Element First = FIO.addElement("First");
                    First.addText(new String(rootNode.get("3_1_2").textValue().getBytes(ISO_8859_1), UTF_8));
                Element Patronymic = FIO.addElement("Patronymic");
                    Patronymic.addText(new String(rootNode.get("3_1_3").textValue().getBytes(ISO_8859_1), UTF_8));
            Element Document = Agent.addElement("Document");
                Element Code_Document = Document.addElement("Code_Document");
                    Code_Document.addText(rootNode.get("mySelect8").textValue());
                Element Series = Document.addElement("Series");
                    Series.addText(rootNode.get("3_1_4").textValue());
                Element Number = Document.addElement("Number");
                    Number.addText(rootNode.get("3_1_5").textValue());
                Element Date = Document.addElement("Date");
                    Date.addText(rootNode.get("3_1_6").textValue());
                Element IssueOrgan = Document.addElement("IssueOrgan");
                    IssueOrgan.addText(new String(rootNode.get("3_1_7").textValue().getBytes(ISO_8859_1), UTF_8));
            //_________
            Element Location2 = Agent.addElement("Location");
                Element Postal_Code = Location2.addElement("Postal_Code");
                    Postal_Code.addText(rootNode.get("3_2_1").textValue());
                Element Region2 = Location2.addElement("Region");
                    Region2.addText(rootNode.get("mySelect9").textValue());
                Element City2 = Location2.addElement("City");
                    City2.addAttribute("Name", new String(rootNode.get("3_2_2").textValue().getBytes(ISO_8859_1), UTF_8));
                    City2.addAttribute("Type", new String(rootNode.get("mySelect10").textValue().getBytes(ISO_8859_1), UTF_8));
                Element Street2 = Location2.addElement("Street");
                    Street2.addAttribute("Name", new String(rootNode.get("3_2_3").textValue().getBytes(ISO_8859_1), UTF_8));
                    Street2.addAttribute("Type",new String(rootNode.get("mySelect11").textValue().getBytes(ISO_8859_1), UTF_8));
                Element Level1_2 = Location2.addElement("Level1");
                    Level1_2.addAttribute("Type", new String(rootNode.get("mySelect12").textValue().getBytes(ISO_8859_1), UTF_8));
                    Level1_2.addAttribute("Value",new String(rootNode.get("3_2_4").textValue().getBytes(ISO_8859_1), UTF_8));
                Element Level2_2 = Location2.addElement("Level2");
                    Level2_2.addAttribute("Type", new String(rootNode.get("mySelect13").textValue().getBytes(ISO_8859_1), UTF_8));
                    Level2_2.addAttribute("Value",new String(rootNode.get("3_2_5").textValue().getBytes(ISO_8859_1), UTF_8));
                Element Level3_2 = Location2.addElement("Level3");
                    Level3_2.addAttribute("Type", new String(rootNode.get("mySelect14").textValue().getBytes(ISO_8859_1), UTF_8));
                    Level3_2.addAttribute("Value",new String(rootNode.get("3_2_6").textValue().getBytes(ISO_8859_1), UTF_8));
                Element Apartment2 = Location2.addElement("Apartment");
                    Apartment2.addAttribute("Type", new String(rootNode.get("mySelect15").textValue().getBytes(ISO_8859_1), UTF_8));
                    Apartment2.addAttribute("Value",new String(rootNode.get("3_2_7").textValue().getBytes(ISO_8859_1), UTF_8));

                Element Other = Location2.addElement("Other");
                    Other.addText("Иное");
                Element Note = Location2.addElement("Note");
                    Note.addText("Неформализованное описание");
                    //__________
            Element email2 = Agent.addElement("E-mail");
                email2.addText(new String(rootNode.get("3_3_1").textValue().getBytes(ISO_8859_1), UTF_8));
            Element Phone = Agent.addElement("Phone");
                Phone.addText(new String(rootNode.get("3_3_2").textValue().getBytes(ISO_8859_1), UTF_8));
            Element SNILS = Agent.addElement("SNILS");
                SNILS.addText(new String(rootNode.get("3_3_3").textValue().getBytes(ISO_8859_1), UTF_8));
            Element agent_kind = Agent.addElement("agent_kind");
                agent_kind.addText(rootNode.get("mySelect16").textValue());

        return root;
    }
}
