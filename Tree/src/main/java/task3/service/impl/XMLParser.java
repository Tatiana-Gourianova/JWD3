package task3.service.impl;


import java.io.IOException;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import task3.entity.Node;
import task3.entity.TypeOfTag;
import task3.service.PersonalExample;

public class XMLParser {

    private String OpenTags;
    private String CloseTags;

public String getCloseTags(){
    return CloseTags;
}

    public String getOpenTags(){
        return OpenTags;
    }


    public void parseOpenTag(String xmlInfo) {
        ArrayList<String> arrayList = new ArrayList<>();
        String st = "";
        Pattern xmlPatternStart = Pattern.compile("<[^/>]+>");
        Matcher xmlMatcher = xmlPatternStart.matcher(xmlInfo);
        while (xmlMatcher.find()) {

            int start = xmlMatcher.start();
            int end = xmlMatcher.end();
            st = xmlInfo.substring(start, end);
            arrayList.add(st);
        }
        OpenTags=arrayList.toString();
        OpenTags = OpenTags.replace("]", "");
        OpenTags = OpenTags.replace("[", "");
    //    System.out.print("\n VVV"+OpenTags);
}



    public void parseCloseTag(String xmlInfo) {
        ArrayList<String> arrayList = new ArrayList<>();
         Pattern xmlPatternEnd = Pattern.compile("</[^>]+>");
        Matcher xmlMatcher = xmlPatternEnd.matcher(xmlInfo);
        String closeTag="";
        int i=0; while (xmlMatcher.find()) {
            i++;
            int start = xmlMatcher.start();
            int end = xmlMatcher.end();
            closeTag = xmlInfo.substring(start, end);
            arrayList.add(closeTag);
        }
        CloseTags=arrayList.toString();
        CloseTags=CloseTags.replace("[","");
        CloseTags=CloseTags.replace("]","");

//System.out.print("\n VVV++"+CloseTags+"\n ++");
    }
}
