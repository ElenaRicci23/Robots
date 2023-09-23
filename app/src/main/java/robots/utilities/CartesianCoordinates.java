package robots.utilities;

/*
CartesianCoordinates rappresenta le coordinate cartesiane di un robot/rettangolo/cerchio nell'area

@param x il valore della coordinata x.
@param y il valore della coordinata y.
 */

public class CartesianCoordinates {

    private double x;
    private double y;

    public CartesianCoordinates(double x, double y) {
        if (x < 0 || y < 0) throw new IllegalArgumentException("le coordinate non possono essere negative");
        this.x = x;
        this.y = y;
    }

    public double getX() { return this.x; } //restituisce la x

    public double getY() { return this.y; } //restituisce la y

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartesianCoordinates that = (CartesianCoordinates) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    @Override
    public String toString() {
        return "(" + x + " , " + y + ")";
    }
}
