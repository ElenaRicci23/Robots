package robots.model;

/*
Robot è un oggetto puntiforme che si muove nell'Area
 */

import robots.utilities.CartesianCoordinates;

public class Robot implements RobotsFactory {

    private CartesianCoordinates position; //posizione del robot
    private String label; //label segnalata dal robot
    private int speed; //velocità del robot
    private double angle; //angolo del robot
    private static int counter = -1;
    private final int id; //identificativo del robot [aumenta di 1 ad ogni robot creato]

    public Robot(CartesianCoordinates position) {
        this.position = position;
        this.label = " ";
        this.speed = 0;
        this.angle = 0;
        this.counter++;
        this.id = counter;
    }

    @Override
    public CartesianCoordinates getPosition() { return this.position; } //restituisce la posizione del robot

    //aggiorna la posizione del robot
    @Override
    public void updatePosition(CartesianCoordinates newPosition) {
        this.position = newPosition;
    }
    public int getId() { return this.id; } //resituisce l'identificativo del robot

    /*segnala una particolare condizione, label è un identificativo
    *costituito da una sequenza di caratteri alfanumerici e dal simbolo ‘_’;
     */
    @Override
    public void signal(String label){
        if(label.matches("^[a-zA-Z0-9_]+$")) {
            this.label = label;
        }
    }

    //termina la segnalazione della condizione
    @Override
    public void unsignal(String label){
        if(this.label.equals(label)) {
            this.label=" ";
        }
    }

    @Override
    public String getLabel() { return this.label; } //restituisce la label del robot
    @Override
    public void setLabel(String label) { this.label = label; } //imposta la label del robot

    //individua i robot con stessa label
    public boolean sameLabelOf(Robot robot) {
        if(this.getLabel().equals(robot.getLabel())) return true;
        return false;
    }

    @Override
    public int getSpeed() { return this.speed; } //restituisce la velocità del robot
    @Override
    public void setSpeed(int speed) { this.speed = speed; } //imposta la velocità del robot
    @Override
    public double getAngle() { return this.angle; } //restituisce l'angolo del robot
    @Override
    public void setAngle(double angle) { this.angle = angle; } //imposta l'angolo del robot

}
