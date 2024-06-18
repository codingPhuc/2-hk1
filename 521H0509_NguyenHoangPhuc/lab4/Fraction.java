public class Fraction {
    private int num;
    private int denom;

    public Fraction() {
        this.num = 0;
        this.denom = 1;
    }
    public Fraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    public double getRatio() {
        return (double) this.num / this.denom;
    }

    @Override
    public String toString() {
        return this.num + "/" + this.denom;
    }
}