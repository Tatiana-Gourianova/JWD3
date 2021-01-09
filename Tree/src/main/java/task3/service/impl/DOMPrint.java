package task3.service.impl;


public class DOMPrint {

    public void print() {
        DOMExample2 example2 = new DOMExample2();
System.out.println( example2.getList2());

        //example2.getList2();
       for (String lines : example2.getList2()) {
            System.out.println(lines);

        }

// Список breakfast-menue из нового XML файла

     /*   private static ArrayList<BreakfastMenue> breakfasts = new ArrayList<>();

        public static void print() throws ParserConfigurationException, SAXException, IOException {

// Получение фабрики, чтобы после получить билдер документов.

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


// Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.

            DocumentBuilder builder = factory.newDocumentBuilder();


// Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.

            Document document = builder.parse(new File("E:\\new_doc\\Java\\Task3\\Tree\\src\\main\\java\\resource\\breakfasts"));
            NodeList breakfastElements = document.getDocumentElement().getElementsByTagName("breakfast");


// Перебор всех элементов employee

            for (int i = 0; i < breakfastElements.getLength(); i++) {
                Node breakfast = breakfastElements.item(i);


// Получение атрибутов каждого элемента

                NamedNodeMap attributes = breakfast.getAttributes();


// Добавление завтрака. Атрибут - тоже Node, потому нам нужно получить значение атрибута с помощью метода getNodeValue()



                breakfasts.add(new BreakfastMenue(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("price").getNodeValue()));
            }


// Вывод информации о каждом сотруднике

            for (BreakfastMenue breakfast : breakfasts)
                //System.out.println(String.format("Завтрак-меню:  название - %s, цена - %s.",  breakfast.getName(), breakfast.getPrice()));
                System.out.println("\n"+ breakfast.toString());
        }
//System.out.println("\n");

*/
    }
}


