public class Fraction {
    private int numer = 0;
    private int denom = 1;

    public Fraction() {
        this.numer = 0;
        this.denom = 1;
    }

    public Fraction(int x, int y) {
        this.numer = x;
        this.denom = y;

    }

    public Fraction(Fraction f) {
        this.numer = f.numer;
        this.denom = f.denom;
    }

    public String toString() {
        return this.numer + "/" + this.denom;
    }

    public boolean equals(Object f) {
        if (f instanceof Fraction) {
            Fraction f1 = (Fraction) f;
            float a = (float) f1.numer / (float) f1.denom;
            float b = (float) this.numer / (float) this.denom;
            if (a == b)
                return true;
            else
                return false;
        }
        return false;
    }

    public int getNumer() {
        return numer;
    }

    public int getDenom() {
        return denom;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }
}