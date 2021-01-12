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
import java.util.stream.Stream;

import static java.lang.System.*;
import static java.util.stream.Collectors.toList;
import static jdk.nashorn.internal.objects.NativeArray.forEach;

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


        out.println();

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

        out.println();


       //Xmlnode.getLinkedList().offerFirst(Xmlnode.get("<name>"));//.peekFirst();
        String[] array = {}; // конвертируем ArrayList в массив
        LinkedList<Node> list=new LinkedList<>();
        list=Xmlnode.getLinkedList();

        array = OpenTags.toArray(new String[OpenTags.size()]);


  //      HashMap<Integer,String>  hashMapText3 = new HashMap<>();
      //  HashMap<Integer,String>  hashMapText2 = new HashMap<>();
        HashMap<String,String>  hashMapText4 = new HashMap<>();
    //    for (int i = 0; i < array.length; i++) {
      //      hashMapText2.put(i,array[i]);}


    for (Node node2 : list) {
        for (int i = 0; i < array.length; i++) {
            //if (Xmlnode.getWithDelete(array[i])!=null){
            if (array[i] == node2.getTag().toString()) {//count++;
                // set.setValue("node2.getText().toString()");//getKey(i).put(i,array[i]);

//                      hashMapText3.put(array[i].hashCode()+node2.getText().hashCode(),node2.getText().toString());
                // System.out.println(hashMapText3);
                // hashMapText4.put(node2.getWithDelete(array[i]).toString(),i+array[i]);break;
                hashMapText4.put(node2.getWithDelete(array[i]).toString(), i + array[i]);//

                break;
                //j++;
                //continue;
                //
                //                  System.out.println("!!!"+array[i]+" :" +node2.getText() + " ");

            }
        }
    }

        System.out.println(hashMapText4);




    /*    set.setValue("node2.getText().toString()");
        java.util.HashMap.Entry < Integer, String > set2 = new java.util.HashMap.Entry < Integer, String> ()
        {

            @Override
            public Integer getKey ()
            {
                return null ;
            }

            @Override
            public String getValue ()
            {
                return null ;
            }

            @Override
            public String setValue ( String value )
            {
                return null ;
            }
        };
            //set=hashMapText3.entrySet();
        out.println(hashMapText3.entrySet()+" lkl"+hashMapText3.keySet()+" gjgj "+set.getValue()+" jkjl "+ set.getKey());

        for (Map.Entry<Integer,String> entry : hashMapText3.entrySet())
        {
            out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
        out.println();

        Stream<Map.Entry<Integer, String>> sorted;// array[2])//comparingByValue().compare(((Comparator<? super HashMap.Entry<Integer, String>>) hashMapText2.entrySet())
        sorted = hashMapText3.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByValue(String::compareTo));
         //.forEach(out::println);

        System.out.println(":"+sorted.toString());
      //  hashMapText3= (HashMap<Integer, String>) sorted.forEach();
        for (Map.Entry<Integer,String> entry : hashMapText2.entrySet())
        {
            out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
        out.println();

        hashMapText3.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByValue(Comparator.reverseOrder()))//thenComparing((Comparator<? super HashMap.Entry<Integer, String>>) hashMapText2.entrySet()))
                .forEach(out::println);

        out.println();

        /*
                HashMap<String,String>  hashMapText = new HashMap<>();
        Node node1=null;
        for (int i = 0; i < array.length; i++) {
             node1=new Node(array[i],node.get(array[i].trim()),"</"+array[i].substring(1));
            //System.out.println(node1.p);
            node1.print();
            if (node1!=null)

            System.out.println("II"+array[i]+ node.get(array[i])+node.getNext(node1));
        }

        /*LinkedList<Node> list=new LinkedList<>();
                list=Xmlnode.getLinkedList();
                for (Node node2:list) {
                    System.out.println(node2.getTag());
                }*/
        //.printText();
        //Xmlnode.printText();
      //  xmlnode.

/*
        LinkedList<Node> list2=new LinkedList<>();
        list2=Xmlnode.getLinkedList();*/
       /*
        for (Node node2:list2){
            hashMapText.put(3,node2.getText().toString());
        }
        System.out.println(hashMapText2);*/
    }
    }



//    }


//System.out.println( stringStack2);
  //  }
    //}


