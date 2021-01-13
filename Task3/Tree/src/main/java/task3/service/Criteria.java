package task3.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Criteria {

    private final String SearchName;
    private final Map<String, Object> criteria = new HashMap<String, Object>();

    public Criteria(String SearchName) {
        this.SearchName = SearchName;
    }

    public String getSearchName() {
        return this.SearchName;
    }

    public Map<String, Object> getCritaria() {
        return this.criteria;

    }


}
