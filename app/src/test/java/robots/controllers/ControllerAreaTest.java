package robots.controllers;

import org.junit.jupiter.api.Test;
import robots.utilities.CartesianCoordinates;
import robots.model.Robot;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerAreaTest {

    //rendere distance() public per eseguire il test
//    @Test
//    void distTest() {
//        ControllerArea ca = new ControllerArea();
//        CartesianCoordinates c1 = new CartesianCoordinates(3,4);
//        CartesianCoordinates c2 = new CartesianCoordinates(6,7);
//        assertEquals(4, (int) ca.distance(c1,c2));
//    }

    //rendere randomPointBetween() public per eseguire il test
//    @Test
//    void randPointTest() {
//        ControllerArea ca = new ControllerArea();
//        double p = ca.randomPointBetween(5,78);
//        assertTrue(p > 5);
//        assertTrue(p < 78);
//    }

    //rendere averagePosition() public per eseguire il test
//    @Test
//    void avgPositionTest() {
//        ControllerArea ca = new ControllerArea();
//        ArrayList<Robot> robots = new ArrayList<Robot>();
//        CartesianCoordinates c1 = new CartesianCoordinates(6,7);
//        Robot r1 = new Robot(c1);
//        robots.add(r1);
//        CartesianCoordinates c2 = new CartesianCoordinates(34,56);
//        Robot r2 = new Robot(c2);
//        robots.add(r2);
//        CartesianCoordinates result = new CartesianCoordinates(20,31.5);
//        assertEquals(result, ca.averagePosition(robots));
//        assertEquals(2,robots.size());
//    }

    //il test viene eseguito prendendo una versione dei metodi nearbyRobots() e distance() che non usi this.area
    @Test
    void nearbyRobots() {
        ArrayList<Robot> robots = new ArrayList<Robot>();
        CartesianCoordinates c1 = new CartesianCoordinates(6,7);
        Robot r1 = new Robot(c1);
        robots.add(r1);
        CartesianCoordinates c2 = new CartesianCoordinates(4,8);
        Robot r2 = new Robot(c2);
        robots.add(r2);
        assertFalse(robots.isEmpty());
        CartesianCoordinates posizione = new CartesianCoordinates(2,3);
        Robot robot = new Robot(posizione);
        ArrayList<Robot> vicini = nearbyRobots(robot,robots,20);
        assertFalse(vicini.isEmpty());
        assertTrue(distance(robot.getPosition(),r1.getPosition()) < 20);
        assertEquals(r1.getId(),vicini.get(0).getId());
        assertEquals(r2.getId(),vicini.get(1).getId());
    }

    private ArrayList<Robot> nearbyRobots(Robot robot, ArrayList<Robot> robots, double dist) {
        ArrayList<Robot> nearbyRobots = new ArrayList<>();
        for (int i = 0; i < robots.size(); i++) {
            Robot r2 = robots.get(i);
            double distance = distance(robot.getPosition(), r2.getPosition());
            if (distance <= dist) { nearbyRobots.add(r2); }
        }
        for (Robot r2 : robots) {
            double distance = distance(robot.getPosition(), r2.getPosition());
            if (dist <= distance) {
                nearbyRobots.add(r2);
            }
        }
        return nearbyRobots;
    }

    private double distance (CartesianCoordinates c1, CartesianCoordinates c2){
        return Point2D.distance(c1.getX(), c1.getY(), c2.getX(), c2.getY());
    }

    //rendere calculateSides() public per eseguire il test
//    @Test
//    void sidesTest() {
//        ControllerArea ca = new ControllerArea();
//        CartesianCoordinates c1 = new CartesianCoordinates(3,5);
//        CartesianCoordinates c2 = new CartesianCoordinates(7,7);
//        double[] result = ca.calculateSides(c1,c2);
//        assertEquals(4, (int) result[0]);
//        assertEquals(4, (int) result[1]);
//        assertEquals(2, (int) result[2]);
//    }

    //rendere calculateAngle() public per eseguire il test
//    @Test
//    void angleTest() {
//        ControllerArea ca = new ControllerArea();
//        CartesianCoordinates c1 = new CartesianCoordinates(3,5);
//        CartesianCoordinates c2 = new CartesianCoordinates(7,7);
//        double angle = ca.calculateAngle(c1,c2);
//        assertEquals(26, (int) angle);
//    }

}
