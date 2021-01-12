package task3.service;


import task3.entity.Node;
import task3.service.impl.XMLParser;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalExample {
    private static String Path = "E:\\new_doc\\Java\\Task3\\Tree\\src\\main\\java\\resource\\";
    private List<String> st;

    public List<String> getSt() {
        return st;
    }

    public PersonalExample() {

    }

    public PersonalExample(String xmlInOneLine) throws IOException {

        List<String> st2;
        if (Files.isReadable(Paths.get(Path, xmlInOneLine))) {

            st2 = Files.readAllLines(Paths.get(Path, xmlInOneLine));
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String newPath = Path + xmlInOneLine;
            System.load(newPath);


            st2 = null;

            try {
                st2.add(reader.readLine());


            } catch (IOException e) {
                System.out.println(e.getMessage());

                reader.close();
            }

            System.out.print(st2);
        }


        this.st = st2;
    }

    public void print() {
        for (String line : getSt()) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws IOException {


        PersonalExample example = new PersonalExample("XMLinOneLine");

        List<String> xmlInfo = example.getSt();
        String XMLInfo = xmlInfo.toString();
        System.out.println("!!!+" + xmlInfo);
        Node Xmlnode = new Node("", "", "");
        String s = null;


        XMLParser parser = new XMLParser();
        parser.parseOpenTag(xmlInfo.toString());
        parser.parseCloseTag(xmlInfo.toString());

        ArrayList<String> OpenTags = parser.getOpenTags();
        ArrayList<String> CloseTags = parser.getCloseTags();
        ArrayList<String> Text = new ArrayList<>();

        String XMLstring = xmlInfo.toString();
        String XMLstring2=xmlInfo.toString();
        Stack<String> stringStack = new Stack<>();

        for (String i : OpenTags) {
            for (String j : CloseTags) {


                Pattern
                        xmlPatternStart = Pattern.compile(i);//.substring(1));

                Matcher
                        xmlMatcher = xmlPatternStart.matcher(XMLstring);


                while (xmlMatcher.find()) {

                    int start = xmlMatcher.start();
                    int end = xmlMatcher.end();
                    String openTag = XMLstring.substring(start, end);


                    if (i.substring(1).contains(j.substring(2, j.length() - 1))) {

if( (XMLstring.length()>(XMLstring.indexOf(i.substring(1).length())))&&(i.length()>2)&&(j.length()>2)&&((XMLstring.indexOf(i.substring(1)) + i.length() - 1)<=(XMLstring.indexOf(j.substring(0, j.length() - 1)))))
                        System.out.println(s = XMLstring.substring(XMLstring.indexOf(i.substring(1)) + i.length() - 1, XMLstring.indexOf(j.substring(0, j.length() - 1))));
                        System.out.println("++" + s);


                        XMLstring = s;
                        //Xmlnode.add(i, s, j);
                        stringStack.push(s);
                        if (s.contains("<") == false) {
                            Xmlnode.add(i, s, j);
                            Text.add(s);
                         System.out.println("VV+" +i+ stringStack.lastElement() + j);
                  //          System.out.println("V " + stringStack.peek());

                            XMLstring =XMLstring2.replace(i+ stringStack.lastElement() + j,"");
                            XMLstring2=XMLstring;
                            //if (s==null) {break;}// xmlInfo.toString();
                        }

                    }

                }


            }

        }

    }

}