package robots.model;

import robots.utilities.CartesianCoordinates;

/*
RobotsFactory è l'interfaccia di un robot
Ogni robot ha posizione, direzione e velocità
 */
public interface RobotsFactory {

    CartesianCoordinates getPosition(); //restituisce la posizione del robot

    void updatePosition(CartesianCoordinates newPosition); //aggiorna la posizione del robot

    /*segnala una particolare condizione, label è un identificativo
     *costituito da una sequenza di caratteri alfanumerici e dal simbolo ‘_’;
     */
    void signal(String label);

    void unsignal(String label); //termina la segnalazione della condizione

    String getLabel(); //restituisce la label del robot
    void setLabel(String label); //imposta la label del robot
    int getSpeed(); //restituisce la velocità del robot
    void setSpeed(int speed); //imposta la velocità del robot
    double getAngle(); //restituisce l'angolo del robot
    void setAngle(double angle); //imposta l'angolo del robot

}
