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


PersonalExample example=new PersonalExample( "XMLinOneLine");

List<String> list= example.getSt();

System.out.println("!!!+"+list);
    XMLParser parser=new XMLParser();
    parser.parseOpenTag(list.toString());
    ArrayList<String>listOfOpenTags =parser.getArrayList();
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
        int i=0; while (xmlMatcher.find()) {i++;
            int start = xmlMatcher.start();
            int end = xmlMatcher.end();
String openTag=xmlInfo.substring(start, end);
            String closeTags=parser.getCloseTags();
            System.out.println("V" + start+" " +end+" " +xmlInfo.substring(start, end)+"\n"+closeTags);
            if (closeTags.contains(openTag.substring(2))){
            int closeTagIndex=xmlInfo.lastIndexOf(openTag.substring(2));
           //сли у открывающегося тэга есть закрывающийся
//String text=xmlInfo.substring(end,
  //      closeTagIndex);
              //  System.out.println(openTag+"VV+++VV"+xmlInfo.substring(end,closeTagIndex));
                xmlNode= new Node(openTag,xmlInfo.substring(end,closeTagIndex));
            }

        }
    }
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
}}
