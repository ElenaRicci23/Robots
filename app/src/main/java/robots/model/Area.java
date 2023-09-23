package robots.model;

/*
Area rappresenta l'interfaccia della default area in cui si muovono i robot e in cui possono essere create delle
aree minori a forma di rettangoli e cerchi
Un'area ha base, altezza e il colore bianco come colore di sfondo predefinito
 */

import robots.utilities.CartesianCoordinates;

import java.util.ArrayList;

public interface Area {

    ArrayList<Robot> getRobots(); //restituisce la lista di robot nell'area
    ArrayList<Rectangle> getRectangles(); //resituisce la lista di rettangoli nell'area
    ArrayList<Circle> getCircles(); //resituisce la lista di cerchi nell'area

    double getWeight(); //restituisce la base dell'area

    double getHeight(); //restituisce l'atezza dell'area

    Robot getRobot(int id); //restituisce il robot

    void updateRobotPosition(int id, CartesianCoordinates newPosition, int speed); //aggiorna la posizione del robot

    default CartesianCoordinates getCenter() {return new CartesianCoordinates(getWeight()/2, getHeight()/2);}
}
