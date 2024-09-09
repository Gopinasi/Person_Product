public class Product {
    String ID;
    String name;
    String desc;
    double cost;

    static private int IDSeed = 1;

    public static int getIDSeed() {
        return IDSeed;
    }

    public static void setIDSeed(int IDSeed) {
        Product.IDSeed = IDSeed;
    }
    public Product(String field, String field1, String field2, String field3) {
        this.ID = field;
        this.name = field1;
        this.desc = field2;
        this.cost = Double.parseDouble(field3);
    }
    public Product(String ID, String name, String desc, double cost) {
        this.ID = ID;
        this.name = name;
        this.desc = desc;
        this.cost = cost;
    }

    public Product(String name, String desc, double cost) {
        this.ID = this.genID();
        this.name = name;
        this.desc = desc;
        this.cost = cost;
    }

    public String getID() {
        return ID;
    }
    private String genID(){
        String newID = "" + IDSeed;
        while(newID.length() < 8) {
            newID = "0" + newID;
        }
        IDSeed++;
        return newID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public String toCSV(){
        return ID + ", " + name + ", " + desc + ", " + cost;
    }

    public String toJSON(){
        char DQ = '\u0022';
        return "{" + DQ + "ID" + DQ + ":" + this.ID + DQ + ", " + DQ + "name" + DQ + ":" + this.name + DQ + ", " + DQ + "desc" + DQ + ":" + this.desc + DQ + ", " +DQ + "cost" + DQ + ":" + this.cost + "}";
    }

    public String toXML(){
        return "<Product>" + "<ID>" + ID +  "</ID>" + "<name>" + name + "</name>" +"<desc>" + desc + "</desc>" +"<cost>" + cost + "</cost>" + "</Product>";
    }


    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
