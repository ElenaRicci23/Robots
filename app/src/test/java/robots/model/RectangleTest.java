package robots.model;

import org.junit.jupiter.api.Test;
import robots.utilities.CartesianCoordinates;
import robots.utilities.ShapeType;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {


    @Test
    void rectangleTest() {
        CartesianCoordinates c = new CartesianCoordinates(3,2);
        Rectangle r = new Rectangle("A",c,100, 150);
        assertEquals(100, r.getWeight());
        assertEquals(150, r.getHeight());
        assertEquals("A", r.getLabel());
        assertEquals(c, r.getPosition());
        assertEquals(ShapeType.RECTANGLE, r.getType());
        assertThrows(IllegalArgumentException.class,
                () -> {Rectangle r1 = new Rectangle("A", c, -1, -7);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {Rectangle r2 = new Rectangle("A", c, 0, 0);
                });
    }

    @Test
    void containsTest(){
        CartesianCoordinates c1 = new CartesianCoordinates(0,0);
        CartesianCoordinates c2 = new CartesianCoordinates(0,1);
        CartesianCoordinates c3 = new CartesianCoordinates(0.5,0.5);
        Rectangle r = new Rectangle("A", c1, 1, 1);
        assertTrue(r.contains(c3));
        assertFalse(r.contains(c2));
        assertTrue(r.contains(c1));
    }

}
