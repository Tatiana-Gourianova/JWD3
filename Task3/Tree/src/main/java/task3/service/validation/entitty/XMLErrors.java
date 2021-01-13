package task3.service.validation.entitty;

public class XMLErrors {

    public enum errXML{
        LINE_BREAK ("a line break"),
        MISSING_CLOSING_TAG("missing closing tag"),
        MISSING_OPENING_TAG ("missing opening tag"),
        OVERLAPPNG_TAGS("overlapping tags");
        //ATTRIBUTE_ERR ("error in the description of the attribute");
// Ошибка если документ обрывается на середине можно просто попробовать поставить закрывающиеся теги
        public String code;
        errXML(String code){this.code = code;}
        public  String getCode(){ return code;}
    }
    errXML[] types = errXML.values();

private boolean[] category=new boolean[XMLErrors.errXML.values().length];
public boolean[]getCategory(){
    return this.category;
    }
    //строкa массив - категории файла, по столбцам которого - наличие того или иного типа
    // ошибки: если на  0  месте true - значит в файле есть ошибка категории файла "a line break"-соответсвует числу в enum errXML
public void errXML(){}
    public void print(int answer){

        for (int i=0;i<XMLErrors.errXML.values().length;i++ ) {
            if (category[i]==true)
            System.out.print(" Mistake in XML-file " + errXML.values()[answer].getCode());
        }

    }


}
