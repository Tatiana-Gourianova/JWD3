package task3.dao;
import task3.entity.DinnerMenue;
import task3.entity.Menue;
import task3.entity.BreakfastMenue;
import task3.entity.SupperMenue;

import java.util.ArrayList;


public class MenueFactory
{
    private Menue manue;
/*
    public Appliance getAppliance() {       return appliance;    }
    public void setAppliance(Appliance appliance){
    this.appliance=appliance;
    }
    public void A*/

    public Menue create(String groupName, ArrayList<String> parameters)
    {
        switch (groupName)
        {
            case "Breakfast":
            {
                manue = new BreakfastMenue(parameters.get(0),parameters.get(1));
                break;
            }
            case "Dinner":
            {
                manue= new DinnerMenue(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)), Integer.parseInt(parameters.get(3)), parameters.get(4));
                break;
            }

            case "Supper":
            {
                manue= new SupperMenue(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)), Integer.parseInt(parameters.get(3)), parameters.get(4));
                break;
            }

        }
        //this.appliance=
        return       manue;
    }
}

