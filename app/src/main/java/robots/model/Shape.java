package robots.model;

/*
Shape rappresenta l'interfaccia delle aree limitate che si possono creare all'interno dell?'Area
 */

import robots.utilities.CartesianCoordinates;
import robots.utilities.ShapeType;

public interface Shape {

    CartesianCoordinates getPosition(); //restituisce la posizione dell'area

    boolean contains(CartesianCoordinates position); //verifica se un certo robot si trova nell'area

    String getLabel(); //restituisce la label dell'area

    ShapeType getType(); //restituisce il tipo di area
}
