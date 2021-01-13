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



    public List<String> takeAll(){

        List<String> allLines=null;

        try {

            allLines = Files.readAllLines(Paths.get(path, FileName));
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return allLines;
    }

    }








