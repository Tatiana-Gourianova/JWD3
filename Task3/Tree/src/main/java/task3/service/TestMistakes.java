package task3.service;

import task3.service.impl.XMLReader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TestMistakes{
    public TestMistakes(){}
public String FixLineBreaks(List<String> allLines) throws IOException
//public static void main(String[] args)
    {
      //  XMLReader reader=new XMLReader();
       // List<String> allLines=reader.takeAll();
        if (allLines==null){
            XMLReader reader=new XMLReader();
            allLines=reader.getAllLines();

        }

        String allLinesInOne=allLines.toString();
        while (allLinesInOne.contains("  ")){

            allLinesInOne=allLinesInOne.replace("  ","");
        }

        allLinesInOne=allLinesInOne.replace(",","");
        allLinesInOne=allLinesInOne.replace("[","");
        allLinesInOne=allLinesInOne.replace("]","");

     //   System.out.println(allLinesInOne);



//v tests or XMLFIXER, в который перенести код, отладив его в XML READER - z list takeAll
return  allLinesInOne;}
}
