package com.gourianova.dto;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.io.FileUtils.readFileToString;

public class ApplianceReader {
    private static final String FILE_PATH = "breakfast.xml";
    private SimpleDto request;
public ApplianceReader(){
 request = deserializationFromFile();}

    private static SimpleDto deserializationFromFile() {
        try {
            ClassLoader classLoader = ApplianceReader.class.getClassLoader();
            String resource = requireNonNull(classLoader.getResource(FILE_PATH)).getFile();
            String text = readFileToString(new File(resource), UTF_8);
            return new SimpleDto(text);
        } catch (IOException ex) {
            System.out.println("Can't read resource for reason: {}" + ex.getMessage());
            throw new RuntimeException("Can't read resource.");
        }
    }
   public  SimpleDto getSimpleDto(){
       return request;
   }
            
    
}
