
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppData {
    public Element createAppData(Element messD, List <myTable> base) {


        for (myTable bas : base){

            DataBase BaseHistory = new DataBase();

        Element appData = messD.addElement("AppData");

        Element type = appData.addElement(new QName("Type", new Namespace("", "http://data.service.pfr.socit.ru")));
            type.addText("RESPONSE");

        Element Properties = appData.addElement(new QName("Properties", new Namespace("", "http://data.service.pfr.socit.ru")));
            Element Property = Properties.addElement("Property");

                Element PropertyName = Property.addElement("PropertyName");
                    PropertyName.addText("TYPE_RESPONSE");
                Element PropertyValue = Property.addElement("PropertyValue");
                    PropertyValue.addText("ОТВЕТ_СНИЛС");

        Element FilePFR = appData.addElement(new QName("FilePFR", new Namespace("", "http://data.service.pfr.socit.ru")));
            Element OTVET_SNILS = FilePFR.addElement("OTVET_SNILS");

                Element SNILS = OTVET_SNILS.addElement("SNILS");
                    SNILS.addText(bas.getSnils());
                Element FIO = OTVET_SNILS.addElement("FIO");

                    Element LASTNAME = FIO.addElement("LASTNAME");
                        LASTNAME.addText(bas.getLastname());
                    Element FIRSTNAME = FIO.addElement("FIRSTNAME");
                        FIRSTNAME.addText(bas.getFirstname());
                    Element MIDDLENAME = FIO.addElement("MIDDLENAME");
                        MIDDLENAME.addText(bas.getPatronymic());

                Element SEX = OTVET_SNILS.addElement("SEX");
                    SEX.addText(bas.getSex());
                Element DATA_BIRTH = OTVET_SNILS.addElement("DATA_BIRTH");
                    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    DATA_BIRTH.addText(dateFormat.format(bas.getData_b()));
                Element DATE_CREATE = OTVET_SNILS.addElement("DATE_CREATE");

                    Date date = new Date();
                    DATE_CREATE.addText(dateFormat.format(date));

            BaseHistory.insertHistory(bas.getLastname(), bas.getFirstname(), bas.getPatronymic(),
                    bas.getData_b(), bas.getSex(), bas.getSnils(), date, true);

/*
            System.out.println(bas.getLastname());
            System.out.println(bas.getFirstname());
            System.out.println(bas.getPatronymic());
            System.out.println(bas.getData_b());
            System.out.println(bas.getSex());
            System.out.println(bas.getSnils());
            System.out.println(date);*/
        }

        return messD;
    }
}
