package task3.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLWriter {
private String fileOneLine;


    public XMLWriter(List<String> stringList) throws IOException {

        FileWriter writer = new FileWriter("E:\\new_doc\\Java\\Task3\\Tree\\src\\main\\java\\resource\\XMLinOneLine", false);

        String st2=stringList.toString().replace(",","");
            if (st2.contains("<?")){
               // st2.replace(st2.substring(st2.indexOf("<?"),st2.indexOf("?>")+2)," ");
                st2=st2.substring(st2.indexOf(">"));
                st2=st2.substring(st2.indexOf("<"));
            }
        st2=st2.replace("[",""); st2=st2.replace("]","");

       while (st2.contains("  ")){st2=st2.replace("  "," ");}
        st2=st2.replace("/ ","/");
        st2=st2.replace(" >",">");
        writer.write(st2);
        writer.flush();

      }

    }


