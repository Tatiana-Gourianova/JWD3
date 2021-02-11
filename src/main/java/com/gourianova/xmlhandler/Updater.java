      package com.gourianova.xmlhandler;

        import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

        class Updater {
        ArrayList<String> xmlFile = new ArrayList<String>();

        public void readFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
        readFile(bufferedReader);
        writeFile(path);
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
        }

        private void writeFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
        for (String xmlLine : xmlFile) {
        bufferedWriter.write(xmlLine + '\n');
        }
        bufferedWriter.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
        }

        private void readFile(BufferedReader bufferedReader) {
        String xmlInform = "";
        try {
        while ((xmlInform = bufferedReader.readLine()) != null) {
        xmlInform = updateComments(xmlInform);
        if (checkCompleteLine(xmlInform) & checkDoubleTag(xmlInform)) {
        xmlFile.add(xmlInform);
        }
        }
        } catch (IOException e) {
        e.printStackTrace();
        }

        }

        private String updateComments(String xmlInform) {
        Pattern xmlPatternComment = Pattern.compile("<!--[^>]*-->");
        Matcher xmlMatcher = xmlPatternComment.matcher(xmlInform);
        if (xmlMatcher.find()) {
        xmlInform = xmlInform.replaceAll("<!--[^>]*-->", "");
        }
        return xmlInform;
        }

        private boolean checkCompleteLine(String xmlInform) {
        xmlInform = xmlInform.trim();
        char[] inform = xmlInform.toCharArray();
        if (inform.length != 0 && inform[0] != '<') {
        xmlFile.set(xmlFile.size() - 1, xmlFile.get(xmlFile.size() - 1) + " " + xmlInform);
        return false;
        }
        return true;
        }

        private boolean checkDoubleTag(String xmlInform) throws IOException {

        Pattern xmlPattern = Pattern.compile(">[\s]*<");
        Matcher xmlMatcher = xmlPattern.matcher(xmlInform);
        if (xmlMatcher.find()) {
        String[] tagArray = xmlInform.split(">[\\s]*<");
        updateLine(tagArray);
        return false;
        }
        return true;
        }

        private void updateLine(String[] tagArray) {
        char[] lineArr;
        for (int i = 0; i < tagArray.length; i++) {
        lineArr = tagArray[i].trim().toCharArray();
        if (lineArr[0] != '<') {
        tagArray[i] = "<" + tagArray[i];
        }
        if (lineArr.length != 0 && lineArr[lineArr.length - 1] != '>') {
        tagArray[i] += ">";
        }
        xmlFile.add(tagArray[i]);
        }
        }

        }

