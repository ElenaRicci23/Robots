package robots.model;

import org.junit.jupiter.api.Test;
import robots.utilities.CartesianCoordinates;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    @Test
    void idTest() {
        CartesianCoordinates c = new CartesianCoordinates(0,0);
        Robot r = new Robot(c);
        assertEquals(0, r.getId());
    }

    @Test
    void updatePositionTest() {
        CartesianCoordinates c = new CartesianCoordinates(19,56);
        Robot r = new Robot(c);
        assertEquals(c, r.getPosition());
        CartesianCoordinates c2 = new CartesianCoordinates(3,7);
        r.updatePosition(c2);
        assertEquals(c2, r.getPosition());
    }

    @Test
    void labelSignalTest(){
        CartesianCoordinates c = new CartesianCoordinates(0,0);
        Robot r = new Robot(c);
        r.signal("ROBOT_0");
        assertEquals("ROBOT_0",r.getLabel());
        r.signal("robot_1:");
        assertNotEquals("robot_1:",r.getLabel());
        r.signal("Robot_10");
        assertEquals("Robot_10",r.getLabel());
        r.unsignal("Robot_10");
        assertEquals(" ", r.getLabel());

        CartesianCoordinates c1 = new CartesianCoordinates(67,89);
        Robot r1 = new Robot(c1);
        r1.signal(" ");
        assertTrue(r.sameLabelOf(r1));
    }

}
