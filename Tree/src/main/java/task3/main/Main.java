package task3.main;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import task3.entity.Node;
import task3.service.PersonalExample;
import task3.service.ServiceFactory;
import task3.service.XMLFixer;
import task3.service.XMLWriter;
import task3.service.impl.DOMExample2;
import task3.service.impl.DOMPrint;
import task3.service.impl.XMLParser;
import task3.service.impl.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, SAXException, ParserConfigurationException {

        XMLReader reader = new XMLReader("breakfast2.xml");
        List<String> allLines = reader.takeAll();

        XMLFixer fixer = new XMLFixer();
        List<String> allLinesInOne = fixer.LinesBreaksOff(allLines);
        XMLWriter xmlWriter = new XMLWriter(allLinesInOne);

        DOMExample2 v = new DOMExample2("XMLinOneLine");
        v.print();
        int count = 0;


        System.out.println();

        PersonalExample example = new PersonalExample("XMLinOneLine");

        List<String> xmlInfo = example.getSt();
        String XMLInfo = xmlInfo.toString();

        //  System.out.println("!!!+" + xmlInfo);


        Node Xmlnode = new Node("", "", "");
        String s = null;


        XMLParser parser = new XMLParser();
        parser.parseOpenTag(xmlInfo.toString());
        parser.parseCloseTag(xmlInfo.toString());

        ArrayList<String> OpenTags = parser.getOpenTags();
        ArrayList<String> CloseTags = parser.getCloseTags();
        ArrayList<String> Text = new ArrayList<>();

        String XMLstring = xmlInfo.toString();
        String XMLstring2 = xmlInfo.toString();
        Stack<String> stringStack = new Stack<>();
        Stack<String> stringStack2 = new Stack<>();
        ArrayList<String> result = new ArrayList<>();
        for (String i : OpenTags) {
            for (String j : CloseTags) {


                Pattern
                        xmlPatternStart = Pattern.compile(i);

                Matcher
                        xmlMatcher = xmlPatternStart.matcher(XMLstring);


                while (xmlMatcher.find()) {

                    int start = xmlMatcher.start();
                    int end = xmlMatcher.end();
                    String openTag = XMLstring.substring(start, end);


                    if (i.substring(1).contains(j.substring(2, j.length() - 1))) {

                        if ((XMLstring.length() > (XMLstring.indexOf(i.substring(1).length()))) && (i.length() > 1) && (j.length() > 1) && ((XMLstring.indexOf(i.substring(1)) + i.length() - 1) <= (XMLstring.indexOf(j.substring(0, j.length() - 1))))) {

                            s = XMLstring.substring(XMLstring.indexOf(i.substring(1)) + i.length() - 1, XMLstring.indexOf(j.substring(0, j.length() - 1)));//);


                            XMLstring = s;
                            // Xmlnode.add(i, s, j);
                            //  stringStack2= (Stack<String>) stringStack.clone();

                            stringStack.push(s);

                            // System.out.println("VV+" +i+ stringStack.lastElement() + j);//}
                            //     System.out.println("VV+" +i+ stringStack.lastElement() + j);

                            if (s.contains("<") == false) {
                                Text.add(s);
                                Xmlnode.add(i, s, j);


                                XMLstring = XMLstring2.replace(i + stringStack.lastElement() + j, "");
                                XMLstring2 = XMLstring;


                            }
                        }

                    }
                }


            }

        }

       // System.out.println("!++");
        Xmlnode.printText();//осталось проиндексировать открывающие тэги по порядку по OpenTags и выводить из Node те, у которых меньше индексы
     //   System.out.println("!!!!+++");
        LinkedList<Node> linkedList = Xmlnode.getLinkedList();
        //linkedList.peekFirst();
        Node node = new Node();//такой же список, что и в Xmlnode
        node.setLinkedList(linkedList);

        //System.out.println("++");
        //node.printText();
        //System.out.println("++");

        System.out.println();


       //Xmlnode.getLinkedList().offerFirst(Xmlnode.get("<name>"));//.peekFirst();
        String[] array = {}; // конвертируем ArrayList в массив
        array = OpenTags.toArray(new String[OpenTags.size()]);
        for (int i = 0; i < array.length; i++) {
            if (Xmlnode.getWithDelete(array[i])!=null)
            System.out.print( Xmlnode.getWithDelete(array[i])+" ");
        }
        System.out.println();
      //  Xmlnode.printText();

    }
}
            /*HashMap<Integer,String>  hashMapText = new HashMap<>();
        for (int i=0; i<Xmlnode.getLinkedList().size();i++){
            hashMapText.put(i,Xmlnode.getText().toString());
        }
        System.out.println(hashMapText);
        }*/

//    }


//System.out.println( stringStack2);
  //  }
    //}


