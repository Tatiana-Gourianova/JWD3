package task3.main;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import task3.service.PersonalExample;
import task3.service.ServiceFactory;
import task3.service.XMLFixer;
import task3.service.XMLWriter;
import task3.service.impl.DOMExample2;
import task3.service.impl.DOMPrint;
import task3.service.impl.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, SAXException, ParserConfigurationException {

        XMLReader reader=new XMLReader("breakfast2.xml");
         List<String> allLines=reader.takeAll();

     XMLFixer fixer=new XMLFixer();
     List<String> allLinesInOne= fixer.LinesBreaksOff(allLines);
 XMLWriter xmlWriter=new XMLWriter(allLinesInOne);

   DOMExample2 v=new DOMExample2("XMLinOneLine");
   v.print();

   PersonalExample vv=new PersonalExample("XMLinOneLine");
   vv.print();

    }

}
