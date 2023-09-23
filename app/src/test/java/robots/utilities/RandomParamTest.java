package robots.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomParamTest {

    @Test
    void coordinatesTest() {
        RandomParam random = new RandomParam();
        CartesianCoordinates c = random.randomRobotCoordinates();
        double x = c.getX();
        double y = c.getY();
        assertTrue(1650 > x && x > 0);
        assertTrue(1080 > y && y > 0);

        CartesianCoordinates c1 = random.randomShapeCoordinates();
        double x1 = c1.getX();
        double y1 = c1.getY();
        assertTrue(1550 > x1 && x1 > 0);
        assertTrue(980 > y1 && y1 > 0);
    }

    @Test
    void valuesTest() {
        RandomParam random = new RandomParam();
        double w = random.randomWeigh();
        double h = random.randomHeight();
        double r = random.randomRadius();
        assertTrue(1550 > w && w > 0);
        assertTrue(980 > h && h > 0);
        assertTrue(490 > r && r > 0);
    }

    @Test
    void stringTest() {
        RandomParam random = new RandomParam();
        String l = random.randomLabel();
        assertTrue(l.matches("^[a-zA-Z0-9]+$"));
    }
}
