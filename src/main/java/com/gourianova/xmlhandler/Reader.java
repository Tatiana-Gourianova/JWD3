package com.gourianova.xmlhandler;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.gourianova.dto.ApplianceReader;
import com.gourianova.entity.Node;

public class Reader {

    Parser parser = new Parser();

   public void readFile(String path) {
     path="E:\\new_doc\\JWDTask3\\XMLTree\\src\\main\\resources\\breakfast.xml";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            Updater xmlUpdater = new Updater();
            xmlUpdater.readFile(path);
            readFile(bufferedReader);
        } catch (FileNotFoundException e) {
            System.out.print("Under construction, try to write the path at 15 line of Reader.java");
        } catch (IOException e) {
            System.out.print("Under construction");
        }
    }

    public void readFile(BufferedReader bufferedReader) {
        String xmlInform = "";
        try {
            while ((xmlInform = bufferedReader.readLine()) != null) {
                xmlInform = xmlInform.trim();
                parser.parseOpenTag(xmlInform);
                parser.parseDataTag(xmlInform);
                parser.parseCloseTag(xmlInform);
            }
        } catch (IOException e) {
            System.out.print("Under construction");
        }

    }



}
