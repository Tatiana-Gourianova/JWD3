package task3.service.impl;

import task3.dao.impl.MenueDAOImpl;
import task3.entity.Menue;
import task3.service.Criteria;
import task3.service.validation.Validator;

public class MenueServiceImpl implements MenueServiceImpl2 {


    public Menue fix(Criteria criteria) throws ClassNotFoundException {

        Menue menue = null;
        if (!Validator.criteriaValidator(criteria)) {
            return null;

        } else {
            MenueDAOImpl menueDAO = new MenueDAOImpl();
            menue = menueDAO.fix(criteria);
        }


    return menue;}
}
