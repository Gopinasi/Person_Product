import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    Product p1, p2, p3;

    @BeforeEach
    void setUP()
    {
        Product.setIDSeed(0);
        p1 = new Product ("Fan", "Description1", 15);
        p2 = new Product("Detergent", "Description2", 25);
        p3 = new Product ("Pillow", "Description3", 30);
    }

    @Test
    void getIDSeed() {
        assertEquals(1, Person.getIDSeed());
    }

    @Test
    void setIDSeed() {
        p1.setIDSeed(1);
        assertEquals(1, p1.getIDSeed());
    }

    @Test
    void getID() {
        assertEquals("00000000", p1.getID());
    }

    @Test
    void setID() {
        p1.setID("00000A");
        assertEquals("00000A", p1.getID());
    }

    @Test
    void getName() {
        assertEquals("Fan", p1.getName());
    }

    @Test
    void setName() {
        p1.setName("Blades");
        assertEquals("Blades", p1.getName());
    }

    @Test
    void getDesc() {
        assertEquals("Description1", p1.getDesc());

    }

    @Test
    void setDesc() {
        p2.setDesc("For Laundry");
        assertEquals("For Laundry", p2.getDesc());
    }

    @Test
    void getCost() {
        assertEquals(25, p2.getCost());
    }

    @Test
    void setCost() {
        p1.setCost(12);
        assertEquals(12, p1.getCost());
    }

    @Test
    void toCSV() {
        String expected = "00000000, Fan, Description1, 15.0";
        assertEquals(expected, p1.toCSV());
    }

    @Test
    void toJSON() {
        String expected = "{\"ID\":00000001\", \"name\":Detergent\", \"desc\":Description2\", \"cost\":25.0}";
        assertEquals(expected, p2.toJSON());
    }

    @Test
    void toXML() {
        String expected = "<Product><ID>00000002</ID><name>Pillow</name><desc>Description3</desc><cost>30.0</cost></Product>";
        assertEquals(expected, p3.toXML());
    }
}