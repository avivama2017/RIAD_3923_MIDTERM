package parser;

import databases.ConnectToMongoDB;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProcessStudentInfo {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //Path of XML data to be read.
        String pathSelenium = System.getProperty("user.dir") + "/src/parser/selenium.xml";
        String pathQtp = System.getProperty("user.dir") + "/src/parser/qtp.xml";
        String tag = "id";
        //Create ConnectToSqlDB Object
        ConnectToMongoDB connectToMongoDB = new ConnectToMongoDB();
        //Declare a Map with List<String> into it.
        Map<String, List<Student>> list = new LinkedHashMap<String, List<Student>>();
        List<Student> seleniumStudents = new ArrayList<>();
        List<Student> qtpStudents = new ArrayList<Student>();
        //Create XMLReader object.
        XmlReader xmlReader = new XmlReader();
        //Parse Data using parseData method and then store data into Selenium ArrayList.
        seleniumStudents = xmlReader.parseData(tag, pathSelenium);
        qtpStudents = xmlReader.parseData(tag, pathQtp);
        list.put("qtp", qtpStudents);
        list.put("selenium", seleniumStudents);
        for (Map.Entry<String, List<Student>> print : list.entrySet()) {
            List<Student> studentList = (List<Student>) list.get(print.getKey());
            System.out.println("\nPortfolio of Student of " + print.getKey() + "classes :\n");
            for (Student studentprofile : studentList) {
                String id = studentprofile.getId();
                String firstname = studentprofile.getFirstName();
                String lastname = studentprofile.getLastName();
                String grade = studentprofile.getScore();
                System.out.println("Students (id=" + id + ")" + firstname + " " + lastname + " grade=" + grade);
                System.out.println("Students (id= " + id + ") " + firstname + " " + lastname + " grade= " + grade);
            }
        }


        //Store Qtp data into Qtp table in Database
        connectToMongoDB.insertIntoMongoDB(seleniumStudents, "qtp");
        //connectToSqlDB.insertDataFromArrayListToMySql(seleniumStudents, "qtp","studentList");

        //Store Selenium data into Selenium table in Database
        connectToMongoDB.insertIntoMongoDB(qtpStudents, "selenium");

        //Retrieve Selenium students from Database
        List<Student> stList1 = connectToMongoDB.readStudentListFromMongoDB("selenium");
        for (Student st : stList1) {
            System.out.println(st.getId() + "   " + st.getFirstName() + " " + st.getLastName() + "   " + st.getScore() + " ");
        }
        //Retrieve Qtp students from Database
        List<Student> stList = connectToMongoDB.readStudentListFromMongoDB("qtp");
        for (Student st : stList) {
            System.out.println(st.getId() + "   " + st.getFirstName() + " " + st.getLastName() + "  " + st.getScore() + " ");
        }

        //Retrieve Selenium students from Database


    }

}

