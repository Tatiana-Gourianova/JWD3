package task3.service;

import org.xml.sax.SAXException;
import task3.service.impl.DOMExample2;
import task3.service.impl.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLFixer {

    //Line breaks исправляются прямо в XML Reader


    public void LinesBreaksOff() {



    }

    public List<String> LinesBreaksOff(List<String> allLines) throws IOException {


            TestMistakes testMistakes = new TestMistakes();
            String allLinesInOne = testMistakes.FixLineBreaks(allLines);
    return  allLines;}



}