package robots.model;

import org.junit.jupiter.api.Test;
import robots.utilities.CartesianCoordinates;
import robots.utilities.ShapeType;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest{

    @Test
    void circleTest() {
        CartesianCoordinates c = new CartesianCoordinates(0,0);
        Circle circle = new Circle("c", c, 1);
        assertEquals(1, circle.getRadius());
        assertEquals("c", circle.getLabel());
        assertEquals(c, circle.getPosition());
        assertEquals(ShapeType.CIRCLE, circle.getType());
        assertThrows(IllegalArgumentException.class,
                () -> {Circle circle1 = new Circle("A", c, -1);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {Circle circle2 = new Circle("A", c, 0);
                });
    }

    @Test
    void containsTest(){
        CartesianCoordinates c2 = new CartesianCoordinates(0,1);
        CartesianCoordinates c3 = new CartesianCoordinates(0.5,0.5);
        CartesianCoordinates c4 = new CartesianCoordinates(3,2);
        CartesianCoordinates position = new CartesianCoordinates(0,0);
        Circle circle = new Circle("A", position, 1);
        assertTrue(circle.contains(c2));
        assertTrue(circle.contains(c3));
        assertFalse(circle.contains(c4));
    }

}
