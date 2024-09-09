import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    Person p1, p2, p3, p4, p5;

    @BeforeEach
    void setUP()
    {
        Person.setIDSeed(0);
        p1 = new Person ("Bob", "Tester1", "Mr.", 1960);
        p2 = new Person("Sally", "Tester2", "Mrs.", 1867);
        p3 = new Person ("Jack", "Tester3", "Mr.", 1980);
        p4 = new Person ("Billy", "Tester4", "Mr.", 1990);
        p5 = new Person ("00000A","Sarah", "Tester5", "Mrs.", 2000);
    }

    @Test
    void getIDSeed() {
        assertEquals(4, Person.getIDSeed());
    }

    @Test
    void getIDnum() {
        assertEquals("00000A", p5.getIDnum());
    }

    @Test
    void getFirstName() {
        assertEquals("Bob", p1.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Tester1", p1.getLastName());
    }

    @Test
    void getTitle() {
        assertEquals("Mr.", p1.getTitle());
    }

    @Test
    void getYOB() {
        assertEquals(1960, p1.getYOB());
    }


    @Test
    void getAge() {
        String expected = String.valueOf(java.time.Year.now().getValue() - 1960);
        assertEquals(expected, p1.getAge());
    }

    @Test
    void setIDSeed() {
        p1.setIDSeed(1);
        assertEquals(1, p1.getIDSeed());
    }

    @Test
    void setIDnum() {
        p5.setIDnum("00000B");
        assertEquals("00000B", p5.getIDnum());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("John");
        assertEquals("John", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Tester11");
        assertEquals("Tester11", p1.getLastName());
    }

    @Test
    void fullName() {
        assertEquals("Bob Tester1", p1.fullName());
    }

    @Test
    void setTitle() {
        p1.setTitle("Mrs.");
        assertEquals("Mrs.", p1.getTitle());
    }

    @Test
    void formalName() {
        assertEquals("Mr. Bob Tester1", p1.formalName());
    }

    @Test
    void setYOB() {
        p1.setYOB(1954);
        assertEquals(1954, p1.getYOB());
    }

    @Test
    void testToCSV() {
        String expected = "00000000, Bob, Tester1, Mr., 1960";
        assertEquals(expected, p1.toCSV());
    }


    @Test
    void toJSON() {
        String expected = "{\"IDNum\":00000000\", \"firstName\":Bob\", \"lastName\":Tester1\", \"title\":Mr.\", \"YOB\":1960}";
        assertEquals(expected, p1.toJSON());
    }

    @Test
    void toXML() {
        String expected = "<Person><IDNum>00000000</IDNum><firstName>Bob</firstName><lastName>Tester1</lastName><title>Mr.</title><YOB>1960</YOB></Person>";
        assertEquals(expected, p1.toXML());
    }
}
