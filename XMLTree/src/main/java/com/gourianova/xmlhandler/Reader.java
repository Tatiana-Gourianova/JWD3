package com.gourianova.xmlhandler;
import java.io.IOException;


public class Reader {

    Parser parser = new Parser();


        public void readFile(String text) throws IOException {
            String[] xmlInform = text.split("\n");

            for (int i=0; i<xmlInform.length;i++){
                xmlInform[i] = xmlInform[i].trim();
                parser.parseOpenTag(xmlInform[i]);
                parser.parseDataTag(xmlInform[i]);
                parser.parseCloseTag(xmlInform[i]);

            }

   }

}
