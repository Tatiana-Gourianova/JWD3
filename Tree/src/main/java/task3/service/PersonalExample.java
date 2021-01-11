package task3.service;

//import com.sun.deploy.xml.BadTokenException;
//import com.sun.deploy.xml.XMLParser;
import task3.entity.Node;
import task3.service.impl.XMLParser;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalExample {
    private static String Path = "E:\\new_doc\\Java\\Task3\\Tree\\src\\main\\java\\resource\\";
private List<String> st;
public List<String> getSt(){
    return st;
}
public PersonalExample(){

}
    public  PersonalExample(String xmlInOneLine) throws IOException {
//File filePath=new File(Path,xmlInOneLine);
        List<String> st2;
        if (Files.isReadable(Paths.get(Path, xmlInOneLine))) {

           st2 = Files.readAllLines(Paths.get(Path, xmlInOneLine));
        }

        else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String newPath = Path + xmlInOneLine;
            System.load(newPath);


                    st2 = null;

            try {
                st2.add( reader.readLine());


            } catch (IOException e) {
                System.out.println(e.getMessage());

                reader.close();
            }

        System.out.print(st2);}

//    return st2;
        this.st=st2;
}

    public void print() {
for (String line : getSt() ){
        System.out.println(line);
    }
}

public static void main(String[] args) throws IOException {


    PersonalExample example = new PersonalExample("XMLinOneLine");

    List<String> xmlInfo = example.getSt();
    String XMLInfo=xmlInfo.toString();
    System.out.println("!!!+" + xmlInfo);
    Node Xmlnode = new Node(" "," ");
    String s = null;
   // while (XMLInfo!=" "){

    XMLParser parser = new XMLParser();
    parser.parseOpenTag(xmlInfo.toString());
    parser.parseCloseTag(xmlInfo.toString());
    String OpenTags = parser.getOpenTags();
    String CloseTags = parser.getCloseTags();
    String[] closeTags = CloseTags.split(" "); //v массив открывающихся тэгов
    String[] openTags = OpenTags.split(">"); //v массив закрывающихся тэгов

    String XMLstring=xmlInfo.toString();

    for (int i = 0; i < openTags.length; i++) {
        for (int j = 0; j < openTags.length; j++) {
            //boolean isSingleTag = (openTags[i].lastIndexOf('<') == 0);
            //if (isSingleTag) {
            Pattern xmlPatternStart = Pattern.compile(openTags[i]);

            Matcher xmlMatcher = xmlPatternStart.matcher( XMLstring);

            while (xmlMatcher.find()) {

                int start = xmlMatcher.start();
                int end = xmlMatcher.end();
                String openTag =  XMLstring.substring(start, end);
                System.out.print(openTag);

                if (openTags[i].substring(1).contains(closeTags[j].substring(2, closeTags[j].length() - 2)))
                    System.out.println(s =  XMLstring.substring( XMLstring.indexOf(openTags[i]) + openTags[i].length() + 1, XMLstring.indexOf(closeTags[j])) + "FGBFG");
                System.out.println(s);


                //}
                //  parser = new XMLParser();
                //parser.parseOpenTag(s);
                //parser.parseCloseTag(s);
                XMLInfo=s;
            }

            //   OpenTags = parser.getOpenTags();
            // CloseTags = parser.getCloseTags();
            //closeTags = CloseTags.split(" "); //v массив открывающихся тэгов
            //openTags = OpenTags.split(">");
            // parser.parseOpenTag(xmlInfo.toString().substring(xmlInfo.toString().indexOf(openTags[i])+openTags[i].length()+1,xmlInfo.toString().indexOf(closeTags[j])).toString());
            //parser.parseCloseTag(xmlInfo.toString().substring(xmlInfo.toString().indexOf(openTags[i])+openTags[i].length()+1,xmlInfo.toString().indexOf(closeTags[j])).toString());
            //  System.out.print("\n VV"+xmlInfo.toString().substring(xmlInfo.toString().indexOf(openTags[i])+openTags[i].length()+1,xmlInfo.toString().indexOf(closeTags[j])));
            //String s=(String) xmlInfo.toString().substring(xmlInfo.toString().indexOf(openTags[i])+openTags[i].length()+1,xmlInfo.toString().indexOf(closeTags[j]));
        }

        /*for (int j = 0; j < openTags.length; j++) {
            if (openTags[i].substring(1).contains(closeTags[j].substring(2, closeTags[j].length() - 2))) {
                // if (closeTags[j].substring(2,closeTags[j].length()-2).compareTo(openTags[i].substring(3)) != 0) {
                String st = closeTags[j].replace(closeTags[j].substring(2, closeTags[j].length() - 2), openTags[i].substring(3));
                closeTags[j] = st;
                //System.out.print("!!!" + closeTags[j]);
                //}
            }
*/
        Xmlnode.add(openTags[i],s);

    }


    //}
    System.out.println("!!!!!!!!!!!!!!");
    Xmlnode.print();//tag записывает нормально, то, что после tag нормально только первый раз, потом не обрезает до закрывающегося тэга
}

  //      for (int i = 0; i < closeTags.length; i++) {
    //        System.out.print("!!!" + closeTags[i]);
      //  }

/*
    }
    if (OpenTags.contains(closeTags[i].substring(2)))// если есть соответсвующий закрывающийся тэг
        CloseTags.indexOf()
    CloseTags.replace(OpenTags.substring(1,OpenTags.indexOf(" "),

   /* ArrayList<String>listOfOpenTags =parser.getArrayList();
    for (String st2:listOfOpenTags) {
        System.out.println("!!!!!+++" + st2);//c st2[1] выводит на экран открывающие тэги = по функции Node.get() вывести содержимое!!!!
        boolean isSingleTag = (st2.lastIndexOf('<') == 0);
    }

    Node xmlNode;
     String xmlInfo =list.toArray()[0].toString();
   //xmlInform.split(" ");
        System.out.println("+++++++++"+xmlInfo);
    for (String st2:listOfOpenTags) {
        System.out.println("!!!!!+++" + st2);//c st2[1] выводит на экран открывающие тэги = по функции Node.get() вывести содержимое!!!!
        boolean isSingleTag = (st2.lastIndexOf('<') == 0);
    if (isSingleTag) {
        Pattern xmlPatternStart = Pattern.compile(st2);
        Matcher xmlMatcher = xmlPatternStart.matcher(xmlInfo);
        int i = 0;
        while (xmlMatcher.find()) {
            i++;
            int start = xmlMatcher.start();
            int end = xmlMatcher.end();
            String openTag = xmlInfo.substring(start, end);
        }
            //String closTags=

// сначала заменить в xmlInfo все таги обычные закрывающиеся закрывающимися с атрибутами.
//xmlInfo.replace(openTag.substring(1,openTag.indexOf(" "),

            ///

           /* String closeTags=parser.getCloseTags();
            System.out.println("V" + start+" " +end+" " +xmlInfo.substring(start, end)+"\n"+closeTags);
            if (closeTags.contains(openTag.substring(2))){
            int closeTagIndex=xmlInfo.lastIndexOf(openTag.substring(2));
           //сли у открывающегося тэга есть закрывающийся
//String text=xmlInfo.substring(end,
  //      closeTagIndex);
              //  System.out.println(openTag+"VV+++VV"+xmlInfo.substring(end,closeTagIndex));
                xmlNode= new Node(openTag,xmlInfo.substring(end,closeTagIndex));

            }
            */


//        }
        //}

        //}

        //}
        //parser.parseDataTag(xmlInform);
        //parser.parseCloseTag(xmlInform);
        //}
//System.out.print("jkkljlk"+parser.getNodeLuist());
        //   System.out.print("2jkkljlk"+parser.getNodeList());


    }

//    parser.parseCloseTag(xmlInfo);}

//}
