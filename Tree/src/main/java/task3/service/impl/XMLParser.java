package task3.service.impl;



import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class XMLParser {

    private ArrayList<String> OpenTags;
    private ArrayList<String> CloseTags;

public ArrayList<String> getCloseTags(){
    return CloseTags;
}

    public ArrayList<String> getOpenTags(){
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
        OpenTags=arrayList;
 //       OpenTags=arrayList.toString();
  //      OpenTags = OpenTags.replace("]", "");
   //     OpenTags = OpenTags.replace("[", "");
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

        CloseTags=arrayList;
        //CloseTags=CloseTags.replace("[","");
        //CloseTags=CloseTags.replace("]","");

//System.out.print("\n VVV++"+CloseTags+"\n ++");
    }
}
