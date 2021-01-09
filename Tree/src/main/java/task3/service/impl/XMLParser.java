package task3.service.impl;


import java.io.IOException;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import task3.entity.Node;
import task3.entity.TypeOfTag;
import task3.service.PersonalExample;

public class XMLParser {

    private Stack<String> tagStack = new Stack<String>();
   private LinkedList<Node> nodeList = new LinkedList<Node>();
private ArrayList<String> arrayList=new ArrayList<>();
private     Node node;
public Node getNode(){
    return node;
}

//public ArrayList<Node> getNodeLuist(){
  //  return nodeList;
//}
    public void parseOpenTag(String xmlInfo) {
String st="";
        Pattern xmlPatternStart = Pattern.compile("<[^/>]+>");
        Matcher xmlMatcher = xmlPatternStart.matcher(xmlInfo);
        String openTag;
int i=0;
        while (xmlMatcher.find()) {i++;
            int start = xmlMatcher.start();
            int end = xmlMatcher.end();
            openTag = xmlInfo.substring(start, end);
            tagStack.push(openTag);
            st =tagStack.toString().replace("["," ");
            st=st.replace("]","");
            st=st.replace("<","</");
            //if (xmlInform.contains("/"+tagStack)){
           System.out.println(st+i);

            int end2 =xmlInfo.indexOf(st);
         //   Node node = new Node(tagStack,xmlInform.substring(start+end,end2-1));// = new Node(tagStack,xmlInform.substring(start+end,end2));
           // nodeList.add(node);
            arrayList.add(xmlInfo.substring(start,end2+end+1));
//        }

} System.out.println("!!"+st);//выводит на экран закрывающие тэги !!!! переписать? чтобы по закрывающему тегу находило содержимое
       for (String st2:arrayList){
        System.out.println(st2);//c st2[1] выводит на экран открывающие тэги = по функции Node.get() вывести содержимое!!!!
    }}

    public static void main(String[] args) throws IOException {
        PersonalExample example=new PersonalExample( "XMLinOneLine");

        List<String> list= example.getSt();

        System.out.println(list);
        XMLParser parser=new XMLParser();
        parser.parseOpenTag(list.toString());
       // if(parser.getNode().getLinkedList()!=null)
       /* for (Object st:parser.getNode().getLinkedList())
        {if (st.toString()!=null) {
            System.out.println(parser.getNode().get(st));


            System.out.print("!!!"+st);//
        }*/
        //}
    }
}
