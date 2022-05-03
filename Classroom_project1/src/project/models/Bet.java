package project.models;

public class Bet {
    private int valible;
    private double risk;

    public Bet(int valible, double risk) {
        this.valible = valible;
        this.risk = risk;
    }

    public Bet() {

    }

    public void setValible(int valible) {
        this.valible = valible;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    public int getValible() {
        return valible;
    }

    public double getRisk() {
        return risk;
    }
}
