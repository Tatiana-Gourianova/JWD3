package task3.main;

import org.xml.sax.SAXException;
import task3.entity.Node;
import task3.service.PersonalExample;
import task3.service.XMLFixer;
import task3.service.XMLWriter;
import task3.service.impl.DOMExample2;
import task3.service.impl.XMLParser;
import task3.service.impl.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.System.*;

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


      // System.out.println("!!!+" + xmlInfo);


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

              for (String i : OpenTags){
                  for (String j : CloseTags){


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

                            if (count==0) {
                                out.println("VV+" +i+ stringStack.lastElement() + j);
                            out.println();
                            count++;}//}
                              //System.out.println("VV+" +i+ stringStack.lastElement() + j);

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

        out.println(stringStack.toArray()[0]);
        out.println();
        Xmlnode.printText();//осталось проиндексировать открывающие тэги по порядку по OpenTags и выводить из Node те, у которых меньше индексы
        //теперь отсортировать по tag'ам, таким образом: если два одинаковых , то чередовать с последующими неодинаковыми пока пары не перестанут совпадать?


     /*   LinkedList<Node> linkedList = Xmlnode.getLinkedList();

        Node node = new Node();//такой же список, что и в Xmlnode
        node.setLinkedList(linkedList);

        out.println();

*/
        out.println();
        String[] array = {}; // конвертируем ArrayList в массив
        LinkedList<Node> list=new LinkedList<>();
        list=Xmlnode.getLinkedList();

        array = OpenTags.toArray(new String[OpenTags.size()]);

        //Node node = new Node();
        //list=node.getLinkedList();


        for (Node node:list) {
                 if(Arrays.asList(array).contains(node.getTag())) out.println("!!!"+node.getText());

        }


        out.println("+"+stringStack.contains(Arrays.asList(array.clone())));//.toArray()[0]); дописать

        ArrayList<Node> arrayList=new ArrayList<Node>(list);
        Iterator<Node> iter = arrayList.iterator();
        Xmlnode.print();
       // Node node = null;
        while (iter.hasNext()) {
             Xmlnode = iter.next();
             int i=2;
           // for (int i=0;i<array.length;i++){
               if (Xmlnode.getTag()==array[i]) {
           // if (Xmlnode.equals(array[i])) {
                out.println("!!!+++!"+Xmlnode.getText());
                iter.remove();}

            //}
        }
     Xmlnode.print();

     /*   HashMap<String,String>  hashMapText4 = new HashMap<>();
       // Object[] arrayList= new ArrayList<String>().toArray();
     //   arrayList=Xmlnode.getLinkedList().toString().split(" ");//toArray();

//arrayList=Xmlnode.getLinkedList().listIterator(k);
        //int k=0;
        int j=0;
     //   Node node2;
        while ((list!=null)&&(j<list.size())) {
            for (int i = 0; i < array.length; i++) {

                if(list.isEmpty()){break;}else{
                    if (array[i] == list.peek().getTag().toString()) {

                        hashMapText4.put(list.peek().getWithDelete(array[i], list).toString(), i + array[i]);
                    }
                }
            }
        }
        out.println();
        out.println("PP"+hashMapText4);
       // LinkedList<Node> list2=new LinkedList<>();
       // list=Xmlnode.getLinkedList();

   /*     int k=0;
        // map=hashMapText4;
        List list3 = new ArrayList(hashMapText4.entrySet());
       // if (list!=null){
        //arrayList= (ArrayList<String>) Xmlnode.getLinkedList().listIterator(k);
        //.iterator();
        Iterator<String> criterias;
        criterias = (Iterator<String>) list.stream().iterator();
        //arrayList= (ArrayList<String>) Xmlnode.getLinkedList().listIterator(k);
        while (criterias.hasNext()) {
            for ( k=0;k<array.length;k++){
                String criteria = criterias.next();
                // == Xmlnode.getTag())
                //if (criteria.compareToIgnoreCase(array[k]))
                    out.println("L:L"+Xmlnode.getText()+array[k]);
            }
        }//}
/*


        HashMap<String,String>  hashMapText4 = new HashMap<>();
    //    for (int i = 0; i < array.length; i++) {
      //      hashMapText2.put(i,array[i]);}


int j=0;
        Node node2;
while ((list!=null)&&(j<list.size())) {
    for (int i = 0; i < array.length; i++) {

        if(list.isEmpty()){break;}else{
        if (array[i] == list.peek().getTag().toString()) {

            hashMapText4.put(list.peek().getWithDelete(array[i], list).toString(), i + array[i]);
        }
    }
  }
}
        out.println();
        System.out.println(hashMapText4);



        HashMap<Integer,String>  hashMapText2 = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

        hashMapText2.put(i,array[i]);
        }

        /*
        String st=null;
        for (int i = 0; i < array.length; i++) {
            for (Map.Entry<String, String> entry : hashMapText4.entrySet()) {
                if (entry.getValue().contains(array[i])) {
                    st = String.valueOf(i);
                    entry.setValue(st);
                    out.println("FDF"+entry.getKey()+entry.getValue());
                }
           out.println("!!"+entry); }
        }
        */

            //    out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
                //hashMapText=entry;

        //        boolean found = true;
/*        int count2=0;

                    for (HashMap.Entry<String, String> criteriaEntry : hashMapText4.entrySet()) {
                        for (int i = 0; i < array.length; i++) {
                            if ((array[i].substring(0).contains(criteriaEntry.getValue().substring(1)))&&((criteriaEntry.getValue().substring(1))!="")) //&& hashMapText4.get(criteriaEntry.getKey()).equals(criteriaEntry.getValue())))
                            //found = false;
                            {  //  System.out.println(":|" + criteriaEntry.getKey()+"i"+i);
                               if (count2>=hashMapText4.size()) {break;}
                                criteriaEntry.setValue(i + "");
                                count2++;
                            }
                            //  out.println("L"+array[i]);}
                            //out.println("Key : " + criteriaEntry.getKey() + " Value : " + criteriaEntry.getValue());
                            //}
                        }
                      //  System.out.println("))))((("+criteriaEntry);
                }


       System.out.println("))"+hashMapText4);






    /*
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
*/
      /*  Stream<Map.Entry<String, String>> sorted;// array[2])//comparingByValue().compare(((Comparator<? super HashMap.Entry<Integer, String>>) hashMapText2.entrySet())
        sorted = hashMapText4.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByValue(String::compareTo));
         sorted.forEach(out::println);

        System.out.println(":"+sorted.toString());
      //

     // hashMapText4= (HashMap<String, String>) sorted.forEach();


        for (Map.Entry<Integer,String> entry : hashMapText2.entrySet())
        {
            out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
        out.println();

        hashMapText4.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByValue(Comparator.reverseOrder()))//thenComparing((Comparator<? super HashMap.Entry<Integer, String>>) hashMapText2.entrySet()))
                .forEach(out::println);

        out.println("+");

        out.println("+:"+hashMapText4);
        Map<String, String> map = new HashMap<>();
        map=hashMapText4;
        List list3 = new ArrayList(map.entrySet());

        Collections.sort(list3, new Comparator<Map.Entry<String, String>>() {

            @Override
            public int compare(Map.Entry<String, String> a, Map.Entry<String, String> b) {
                int i=Integer.parseInt(a.getValue().substring(0,a.getValue().indexOf("<")));
                int j;
                if (!b.getValue().contains("<")){ j=Integer.parseInt(b.getValue());} else {
                 j=Integer.parseInt(b.getValue().substring(0,b.getValue().indexOf("<")));}
                return i-j;//Integer.parseInt(a.getValue().substring(0,a.getValue().indexOf("<"))) - Integer.parseInt(b.getValue());
            }

        });
out.println("+++"+hashMapText4);

        //Collections.sort(hashMapText4,  ");

        Iterator<HashMap.Entry<String, String>> criterias=hashMapText4.entrySet().iterator();
        while (criterias.hasNext()){
            HashMap.Entry<String, String> criteria1=criterias.next();
                if (criterias.hasNext()){
                   HashMap.Entry<String, String>  criteria2=criterias.next();}else break;

       // Collections.sort();

        }

        out.println("++");
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




