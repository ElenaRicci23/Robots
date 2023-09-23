package robots.model;

/*
Rectangle è un'area rettangolare presente nell'Area
Rectangle indica delle particolare condizioni, tutti i robot che entrano nel Rectangle devono sottostare a tali condizioni
 */

import robots.utilities.CartesianCoordinates;
import robots.utilities.ShapeType;

public class Rectangle implements Shape {

    private final double weight; //base del rettangolo
    private final double height; //altezza del rettangolo
    private final String name; //nome del rettangolo
    private final CartesianCoordinates position; //posizione del rettangolo

    public Rectangle(String label, CartesianCoordinates position, double weight, double height) {
        if (weight <= 0 || height <= 0) throw new IllegalArgumentException("base e altezza non possono essere negativi o 0");
        this.weight = weight;
        this.height = height;
        this.name = label;
        this.position = position;
    }

    public double getWeight() { return weight; } //restituisce la base del rettangolo

    public double getHeight() { return height; } //restituisce l'altezza del rettangolo

    @Override
    public CartesianCoordinates getPosition() { return this.position; } //restituisce la posizione del rettangolo

    //verifica se un punto è all'interno del rettangolo
    @Override
    public boolean contains(CartesianCoordinates position) {
        return Math.abs(position.getX()) <= this.weight/2 && Math.abs(position.getY()) <= this.height/2;
    }

    @Override
    public String getLabel() { return this.name; } //restituisce la label del rettangolo

    @Override
    public ShapeType getType() { return ShapeType.RECTANGLE; } //segnala che si tratta di un rettangolo
}
