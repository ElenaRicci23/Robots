package robots.model;

import org.junit.jupiter.api.Test;
import robots.utilities.CartesianCoordinates;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class DefaultAreaTest {

    @Test
    void print() {
        DefaultArea defaultArea = new DefaultArea();
        for (Robot r: defaultArea.getRobots()) {
            System.out.println(r.getId());
        }
    }

    @Test
    void robotTest() {
        DefaultArea defaultArea = new DefaultArea();
        for (Robot r: defaultArea.getRobots()) {
            System.out.println(r.getId());
        }
        Robot r1 = defaultArea.getRobot(0);
        assertEquals(0, r1.getId());
        assertEquals(r1, defaultArea.getRobot(0));

        Robot r2 = defaultArea.getRobot(69);
        assertEquals(69, r2.getId());

        CartesianCoordinates c = new CartesianCoordinates(70,45);
        int speed = 5;
        Robot r3 = defaultArea.getRobot(56);
        defaultArea.updateRobotPosition(56, c, speed);
        assertEquals(c, r3.getPosition());
        assertEquals(5, r3.getSpeed());

        CartesianCoordinates c1 = new CartesianCoordinates(45, 67);
        Robot r4 = new Robot(c1);
        defaultArea.addRobot(r4);
        assertEquals(71, r4.getId());

        String l1 = r4.getLabel();
        r3.setLabel(l1);
        assertEquals(r4.getLabel(), r3.getLabel());
        ArrayList<Robot> robotsWithSameLabel = defaultArea.robotsWithSameLabel(l1);
        for (Robot robot : robotsWithSameLabel) {
            String label = robot.getLabel();
            assertEquals(r3.getLabel(), label);
            assertEquals(r4.getLabel(), label);
        }
    }

    @Test
    void sizeTest() {
        DefaultArea defaultArea = new DefaultArea();
        assertEquals(1650, defaultArea.getWeight());
        assertEquals(1080, defaultArea.getHeight());
    }


    @Test
    void shapes() {
        DefaultArea defaultArea = new DefaultArea();
        assertFalse(defaultArea.getRobots().isEmpty());
        assertTrue(defaultArea.getRectangles().isEmpty());
        assertTrue(defaultArea.getCircles().isEmpty());
    }

}
