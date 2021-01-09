package task3.service;

//import com.sun.deploy.xml.BadTokenException;
//import com.sun.deploy.xml.XMLParser;
import task3.entity.Node;
import task3.service.impl.XMLParser;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

           // String
                    st2 = null;

            try {
                st2.add( reader.readLine());
// в блок  catch заключаем код по обработке исключения IOException

            } catch (IOException e) {
                System.out.println(e.getMessage());
// в блоке finally закрываем поток чтения
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
/*
public static void main(String[] args) throws IOException {


PersonalExample example=new PersonalExample( "XMLinOneLine");

List<String> list= example.getSt();

System.out.println(list);
    XMLParser parser=new XMLParser();
    parser.parseOpenTag(list.toString());

    Node xmlNode;
    //for (String xmlInform : list) {
      //  System.out.println(xmlInform);


    //}
    //parser.parseDataTag(xmlInform);
    //parser.parseCloseTag(xmlInform);
    //}
System.out.print("jkkljlk"+parser.getNodeLuist());
    System.out.print("2jkkljlk"+parser.getNodeList());

}*/
}
