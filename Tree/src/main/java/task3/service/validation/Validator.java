package task3.service.validation;

import task3.service.Criteria;

public class Validator {
    public static boolean criteriaValidator(Criteria criteria) {

        boolean isValid = true;
        if ((criteria.getSearchName() == null) && (criteria.getCritaria() == null))
            isValid = false;

        return isValid;
    }
}
