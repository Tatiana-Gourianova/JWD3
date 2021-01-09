package task3.entity;
public class BreakfastMenue extends Menue {
  //  private int id;
    private String name,price;
    //private String price; // currency+amount ;

    public BreakfastMenue(String name, String price) {
        super();
        this.name = name;
        this.price = price;
    }

    public Object getName() {
        return name;
    }

    public Object getPrice() {
        return price;
    }

    @Override
    public String toString(){
return getName().toString()+" " + getPrice().toString();
    }
  /*  public int getId(){
        return id;
    }

   */
 
}

