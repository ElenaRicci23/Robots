package robots.model;

/*
Circle è un'area circolare presente nell'Area
Circle indica delle particolare condizioni, tutti i robot che entrano nel Circle devono sottostare a tali condizioni
 */

import robots.utilities.CartesianCoordinates;
import robots.utilities.ShapeType;

public class Circle implements Shape {

    private final double radius; //raggio del cerchio
    private final String name; //nome del cerchio
    private final CartesianCoordinates position; //posizione del cerchio

    public Circle(String label, CartesianCoordinates position, double radius) {
        if (radius <= 0) throw new IllegalArgumentException("il raggio non può essere negativo o 0");
        this.radius = radius;
        this.name = label;
        this.position = position;
    }

    public double getRadius() { return this.radius; } //restituisce il raggio del cerchio

    @Override
    public CartesianCoordinates getPosition() { return this.position; } //restituisce la posizione del cerchio

    //si serve del teorema di pitagora per verificare se un punto è all'interno del cerchio
    @Override
    public boolean contains(CartesianCoordinates position) {
        double distance = Math.sqrt( Math.pow(position.getX(), 2) + Math.pow(position.getY(), 2 ));
        return distance <= radius ;
    }

    @Override
    public String getLabel() { return this.name; } //restituisce la label del cerchio

    @Override
    public ShapeType getType() { return ShapeType.CIRCLE; } //segnala che si tratta di un cerchio
}
