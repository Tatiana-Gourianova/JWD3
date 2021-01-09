package task3.service.impl;

import task3.service.TestMistakes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class XMLReader {

    private static File Path;
    private static String path= "E:\\new_doc\\Java\\Task3\\Tree\\src\\main\\java\\resource\\";
    private static String FileName;
    //public String FileName="";//="breakfasts3.xml";
private List<String> AllLines;
public void setAllLines() {
    this.AllLines = takeAll();
}
public List<String> getAllLines(){
    return AllLines;
}
    public static String getFileName(){

        return FileName;
    }
public XMLReader() throws IOException {

    }

    public XMLReader(String file) throws IOException {
    this.FileName=file;//replace(".xml","");
     this.setPath(new File(path,FileName));

    }

public void setPath(File file){
       this.Path=(file);
}

    //private String toString(String s) {
    //}
//public String getpath(){
//return path;
  //  }



    //public void setPath(String path, String file){
     //   this.Path=new File(path,file);
    //}
    //public static File getPath(){
      //  return Path;
    //}


    //  takeAll() возвращает  List<String> строчки xml-файла дописать ремонт "плохого" xml-файла


//в отдельный метод, в отдельный класс


    public List<String> takeAll(){

        List<String> allLines=null;

        try {
           // allLines = Files.readAllLines(Paths.get(String.valueOf(getPath())));
            allLines = Files.readAllLines(Paths.get(path, FileName));//&&&&&&&&&&&&&&&&&&&& path+FileName?????
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return allLines;
    }
   /******* File file=new File(path+FileName);
    List<String> allLines=takeAll();
    TestMistakes testMistakes=new TestMistakes();
    String  allLinesInOne=testMistakes.FixLineBreaks(allLines);
****/
//System.out.println()


//String st= getPath().toString().replace("\u005C","\u005C\u005C");

        //finally {
        //      System.err.print("Ошибка в XML-файле "+getFileName()+", которую неудается  исправить автоматически с помощью XMLFixer");
        //}
/*
 public static void main(String[] args) throws IOException {

     XMLReader reader=new XMLReader("breakfasts2");
     List<String> allLines=reader.takeAll();
System.out.println("!!!"+allLines);
 }
*/
    }








