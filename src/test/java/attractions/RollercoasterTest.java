package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(25, 2.5, 20.00);
        visitor2 = new Visitor(14, 1.5, 10.00);
        visitor3 = new Visitor(10, 1.5, 10.00);

    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void hasDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void hasPriceForTallPeople(){
        assertEquals(16.80, rollerCoaster.priceFor(visitor1),0.01);
    }

    @Test
    public void doesNotOverchargeShortPeople(){
        assertEquals(8.40, rollerCoaster.priceFor(visitor2), 0.01);
    }

    @Test
    public void isAllowedToRideRollercoaster(){
        assertEquals(true, rollerCoaster.isAllowed(visitor2));
    }

    @Test
    public void doesNotLetUnacceptableVisitorRide(){
        assertEquals(false, rollerCoaster.isAllowed(visitor3) );
    }
}
