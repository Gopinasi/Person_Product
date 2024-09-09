import java.util.Calendar;
import java.util.Date;

public class Person
{
    private String IDnum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    static private int IDSeed = 1;

    public Person(String field, String field1, String field2, String field3, String field4) {
        this.IDnum = field;
        this.firstName = field1;
        this.lastName = field2;
        this.title = field3;
        this.YOB = Integer.parseInt(field4);
    }

    public static int getIDSeed() {
        return IDSeed;
    }

    public static void setIDSeed(int IDSeed) {
        Person.IDSeed = IDSeed;
    }

    public Person(String IDnum, String firstName, String lastName, String title, int YOB) {
        this.IDnum = IDnum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public Person(String firstName, String lastName, String title, int YOB) {
        this.IDnum = this.genIDnum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }


    public String getIDnum() {
        return IDnum;
    }

    private String genIDnum(){
        String newID = "" + IDSeed;
        while(newID.length() < 8) {
            newID = "0" + newID;
        }
        IDSeed++;
        return newID;
    }

    public void setIDnum(String IDnum) {
        this.IDnum = IDnum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String formalName(){
        return title + " " + fullName();
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    Calendar calendar = Calendar.getInstance();
    int currentYear = calendar.get(Calendar.YEAR);

    public String getAge(){
        return String.valueOf((currentYear - YOB));
    }

    public String getAge(int year){
        return String.valueOf(year - YOB);
    }

    public String toCSV(){
        return IDnum + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    public String toJSON(){
      char DQ = '\u0022';
      return "{" + DQ + "IDNum" + DQ + ":" + this.IDnum + DQ + ", " + DQ + "firstName" + DQ + ":" + this.firstName + DQ + ", " + DQ + "lastName" + DQ + ":" + this.lastName + DQ + ", " +DQ + "title" + DQ + ":" + this.title + DQ + ", " + DQ + "YOB" + DQ + ":" + this.YOB + "}";
    }

    public String toXML(){
        return "<Person>" + "<IDNum>" + IDnum +  "</IDNum>" + "<firstName>" + firstName + "</firstName>" +"<lastName>" + lastName + "</lastName>" +"<title>" + title + "</title>" +"<YOB>" + YOB + "</YOB>" + "</Person>";
    }


    @Override
    public String toString() {
        return "Person{" +
                "IDnum='" + IDnum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }
}
