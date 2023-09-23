package robots.utilities;

import org.junit.jupiter.api.Test;
import robots.utilities.CartesianCoordinates;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CartesianCoordinatesTest {

    CartesianCoordinates c0 = new CartesianCoordinates(0, 0);

    @Test
    void x() {
        assertEquals(0, c0.getX());
    }

    @Test
    void y() {
        assertEquals(0, c0.getY());
    }

    @Test
    void equals() {
        CartesianCoordinates c1 = new CartesianCoordinates(0, 0);
        assertEquals(c0, c1);
        CartesianCoordinates c2 = new CartesianCoordinates(0, 1);
        assertNotEquals(c0, c2);
        CartesianCoordinates c3 = new CartesianCoordinates(1, 0);
        assertNotEquals(c0, c3);
    }
}
