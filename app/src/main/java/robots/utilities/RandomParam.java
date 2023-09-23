package robots.utilities;

import java.util.Random;

/*
Random contiene metodi utili alla generazione di parametri randomici necessari nella creazione di robot, rectangle e circle
 */
public class RandomParam {
    private Random r = new Random();

    //genera una stringa alfanumerica randomica di capacità 10
    public String randomLabel() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

    //genera coordinate randomiche per il robot tra 1 e 1650/1080
    public CartesianCoordinates randomRobotCoordinates() {
        double x = 1649 * this.r.nextDouble() + 1;
        double y = 1079 * this.r.nextDouble() + 1;
        return new CartesianCoordinates(x,y);
    }

    //genera coordinate randomiche per le figure
    public CartesianCoordinates randomShapeCoordinates(){
        double x = randomWeigh();
        double y = randomHeight();
        return new CartesianCoordinates(x,y);
    }

    //genera una base di misura randomica tra 10 e 1550
    public double randomWeigh() { return (1540 * this.r.nextDouble() + 10); }

    //genera un'altezza di misura randomica tra 10 e 980
    public double randomHeight() { return (970 * this.r.nextDouble() + 10); }

    //genera un raggio di misura randomica tra 10 e 490
    public double randomRadius() { return (480 * this.r.nextDouble() + 10); }

}
