import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.SortedMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       /// ArrayList<Person> folks = new ArrayList<>();
        Person Sally = new Person("Sally", "Billy", "Mrs.", 1234);
        //Person bob = new Person("bob", "Billy", "Mrs.", 1234);
        //System.out.println(Sally.getAge(2023));
        System.out.println(Sally.toCSV());

       // for(Person p: folks){
         //   System.out.println(p);
        }
}
