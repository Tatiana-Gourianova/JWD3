package com.gourianova.main;

import com.gourianova.dto.ApplianceReader;
import com.gourianova.dto.SimpleDto;
import com.gourianova.entity.Node;
import com.gourianova.xmlhandler.Parser;
import com.gourianova.xmlhandler.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader read = new Reader();

        ApplianceReader applianceReader = new ApplianceReader();
        SimpleDto dto = applianceReader.getSimpleDto();
        String text = dto.getText();
        read.readFile(text);
        System.out.println("\n");
        for (Node nodes : Parser.getNodeList()) {
            if (nodes.getContent() != null) {
                System.out.println(nodes.getContent() + "\n");
            }
        }
    }
}
