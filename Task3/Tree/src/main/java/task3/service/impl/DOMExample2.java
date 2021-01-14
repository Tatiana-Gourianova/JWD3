package task3.service.impl;

import java.io.*;


import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DOMExample2 {
    private static String Path = "E:\\new_doc\\Java\\Task3\\Tree\\src\\main\\java\\resource\\";
    private final static String FileName = "XMLinOneLine";

    private static ArrayList<String> List2 = new ArrayList<>();

    // String[] List2 = null;
    public ArrayList<String> getList2() {
        return this.List2;
    }

    public DOMExample2() {
        //new DOMExample2(new File(path,FileName));
        //переписать с
    }

    ;

    public DOMExample2(String path) throws ParserConfigurationException, SAXException, IOException {


        path = Path + path;
// Ридер для считывания имени тега из консоли
        File file=new File(String.valueOf(path));
        Scanner scanner=new Scanner(file);
        String s = scanner.nextLine();
        int info=0;
        if (s.contains("<?")){
           info=1;

        }
        // Считывание имени тега для поиска его в файле
        //  String element =reader.readLine();
        String[] st2=s.split("> ");
        int attr=0;
        if (st2[info].contains(">")) attr=1;
        String string=st2[info].substring(1,st2[info].length()-attr);

        //     string=string.replace("<","\"");
        //  string=string.replace(">","\"");

        String element =string;//reader.readLine();
        //string;
        //"breakfast-menu";

        //reader.readLine();
        //st2[0].substring(1,st2[0].length()-1);//"breakfast-menu";
//System.out.println(element);


        //Pattern field_name_pattern = Pattern.compile(" ");



        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


// Получение фабрики, чтобы после получить билдер документов.

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


// Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.

        DocumentBuilder builder = factory.newDocumentBuilder();


// Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.


        //
        Document document = builder.parse(file);



// Получение списка элементов, однако для удобства будем рассматривать только первое совпадение в документе.


// Так же заметьте, что мы ищем элемент внутри документа, а не рут элемента. Это сделано для того, чтобы рут элемент тоже искался.

        NodeList matchedElementsList = document.getElementsByTagName(element);


// Даже если элемента нет, всегда будет возвращаться список, просто он будет пустым.


// Потому, чтобы утверждать, что элемента нет в файле, достаточно проверить размер списка.

        if (matchedElementsList.getLength() == 0) {
            System.out.println("Тег " + element + " не был найден в файле.");
        } else {

// Получение первого элемента.

            Node foundedElement = matchedElementsList.item(0);
            System.out.println("");
            //System.out.println("Элемент был найден!");


// Если есть данные внутри, вызов метода для вывода всей информации

            if (foundedElement.hasChildNodes())
                printInfoAboutAllChildNodes(foundedElement.getChildNodes());
        }
    }


    /**
     * Рекурсивный метод, который будет выводить информацию про все узлы внутри всех узлов, которые пришли параметром, пока не будут перебраны все узлы.
     *
     * @param list Список узлов.
     */

    private static void printInfoAboutAllChildNodes(NodeList list) {
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);


// У элементов есть два вида узлов - другие элементы или текстовая информация. Потому нужно разбираться две ситуации отдельно.

            if (node.getNodeType() == Node.TEXT_NODE) {

// Фильтрация информации, так как пробелы и переносы строчек нам не нужны. Это не информация.

                String textInformation = node.getNodeValue().replace("\n", "").trim();

                if (!textInformation.isEmpty())
                    List2.add(node.getNodeValue());
                // System.out.println("Внутри элемента найден текст: " + node.getNodeValue());

            }

// Если это не текст, а элемент, то обрабатываем его как элемент.

            else {
                //  System.out.println("Найден элемент: " + node.getNodeName() + ", его атрибуты:");


// Получение атрибутов

                NamedNodeMap attributes = node.getAttributes();


// Вывод информации про все атрибуты

                for (int k = 0; k < attributes.getLength(); k++)
                    //System.out.println("Имя атрибута: " + attributes.item(k).getNodeName() + ", его значение: " + attributes.item(k).getNodeValue());
                    List2.add(attributes.item(k).getNodeValue() + "/..");
            }


// Если у данного элемента еще остались узлы, то вывести всю информацию про все его узлы.

            if (node.hasChildNodes())
                printInfoAboutAllChildNodes(node.getChildNodes());
        }

    }

    public  void print() throws IOException, SAXException, ParserConfigurationException {
   //     DOMExample2 v = new DOMExample2("XMLinOneLine");
    /*String st2=List2.toString();
    st2=st2.replace("[","");
    st2=st2.replace("]","");*/
        ArrayList<String> list =  getList2();
        for (String st : list) {
            st = st.replace(",", "");
            char[] st2 = st.toCharArray();
      /*  for (int i=2;i<st.length()-3;i++) {
            if (st2[i] != '/') {
                i--;i--;System.out.printf(String.format("\n%s", st2[i]));

                i+=3;
            }
            System.out.print(String.format("%s",st2[i]));}*/
            if (st2[1] == '/') {
                System.out.print("\n" + st2[0]+". ");
                continue;
            }
            System.out.print(st+" ");
        }
        System.out.println();
    }

}


