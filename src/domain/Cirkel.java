package domain;

import java.awt.geom.Point2D;

public class Cirkel {
    private Point2D.Double middelpunt;
    private double straal;

    public Cirkel(Point2D.Double middelpunt, double straal){
        if (middelpunt == null) throw new IllegalArgumentException("mag niet");
        if (straal < 0) throw new IllegalArgumentException("mag niet");
        if (straal > middelpunt.getX() || straal > middelpunt.getY()) throw new IllegalArgumentException("mag niet");

        this.middelpunt = middelpunt;
        this.straal = straal;
    }

    public Point2D.Double getMiddelpunt() {
        return middelpunt;
    }

    public double getStraal() {
        return straal;
    }
    public double berekenOppervlakte(){
        return 3.14*this.straal*this.straal;
    }
    public boolean ligtPuntInCirkel(Point2D.Double punt) {
        return ((punt.getX() - middelpunt.getX()) * (punt.getX() - middelpunt.getX()) +
                (punt.getY() - middelpunt.getY()) * (punt.getY() - middelpunt.getY()) < (straal * straal));
    }
    public void vergrootStraal(double factor){
        double nieuweStraal = straal * factor;
        if (factor < 0) throw new IllegalArgumentException();
        if (nieuweStraal<0 || nieuweStraal >= middelpunt.getX() || nieuweStraal>= middelpunt.getY()) throw new IllegalArgumentException();
        this.straal = nieuweStraal;
    }
}

