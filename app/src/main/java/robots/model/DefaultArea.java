package robots.model;

/*
DefaultArea è lo spazio in cui si muovono i robot
DefaultArea è occupata da 100 rettangoli e 100 cerchi che rappresentano areecon determinate carateristiche (label)
 */

import robots.utilities.CartesianCoordinates;
import robots.utilities.RandomParam;
import java.util.ArrayList;

public class DefaultArea implements Area{

    private final double weight; //base
    private final double height; //altezza
    private ArrayList<Robot> robots; //lista di robot
    private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>(); //lista di rettangoli
    private ArrayList<Circle> circles = new ArrayList<Circle>(); //lista di cerchi
    private RandomParam random = new RandomParam();

    public DefaultArea() {
        this.weight = 1650;
        this.height = 1080;
        this.robots = generateRobots();
    }

    public void addRobot(Robot robot) {
        this.robots.add(robot);
    } //aggiunge un robot alla lista di robot

    //genera 70 robot con posizioni casuali
    public ArrayList<Robot> generateRobots() {
        ArrayList<Robot> robots1 = new ArrayList<>();
        int i = 0;
        while (i <= 70) {
            assert random != null;
            CartesianCoordinates c = random.randomRobotCoordinates();
            robots1.add(new Robot(c));
            i++;
        }
        return robots1;
    }

    public void addCircle(Circle circle) {
        this.circles.add(circle);
    } //aggiunge una nuova area circolare

    public void addRectangle(Rectangle rectangle) {
        this.rectangles.add(rectangle);
    } //aggiunge una nuova area rettangolare

    //restituisce tutti i robot che condividono una certa label
    public ArrayList<Robot> robotsWithSameLabel(String label) {
        ArrayList<Robot> result = new ArrayList<>();
        for (int i = 0; i < this.robots.size(); i++) {
            Robot r = this.robots.get(i);
            if (r.getLabel().equals(label)) result.add(r);
        }
        return result;
    }

    //restituisce il robot che ha l'id corrispondente [metodo utile per individuare il robot che si vuole comandare]
    @Override
    public Robot getRobot(int id) {
        for (int i = 0; i < this.robots.size(); i++) {
            Robot r = this.robots.get(i);
            if (r.getId() == id) return r;
        }
        return null;
    }

    @Override
    public ArrayList<Robot> getRobots() { return this.robots; } //restituisce la lista di robot nell'area
    @Override
    public ArrayList<Rectangle> getRectangles() { return this.rectangles; } //resituisce la lista di rettangoli nell'area
    @Override
    public ArrayList<Circle> getCircles() { return this.circles; } //resituisce la lista di cerchi nell'area
    @Override
    public double getWeight() { return weight; } //restituisce la base dell'area
    @Override
    public double getHeight() { return height; } //restituisce l'altezza dell'area

    //aggiorna la posizione di un determinato robot
    @Override
    public void updateRobotPosition(int id, CartesianCoordinates newPosition, int speed) {
        this.getRobot(id).updatePosition(newPosition);
        this.getRobot(id).setSpeed(speed);
    }
}
