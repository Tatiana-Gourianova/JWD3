package com.gourianova.main;

import com.gourianova.entity.Node;
import com.gourianova.xmlhandler.Reader;
import com.gourianova.xmlhandler.Parser;

public class Main {
    public static void main(String[] args) {
        Reader read = new Reader();
        read.readFile("breakfast.xml");
        System.out.println("\n");
        for (Node nodes : Parser.getNodeList()) {
            if (nodes.getContent()!=null) {
                System.out.println(nodes.getContent() + "\n");
            }
        }
    }
}
