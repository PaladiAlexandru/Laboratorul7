package board;

import java.util.Random;

public class Token {
    int pozInitiala;
    int pozFinala;
    int valoare;
    final int valMax =30;

    public Token() {
        Random rand = new Random();
        this.valoare = rand.nextInt(valMax);
        this.pozInitiala = rand.nextInt(valMax);
        this.pozFinala = rand.nextInt(this.valMax - this.pozInitiala) + this.pozInitiala;

    }

    @Override
    public String toString() {
        return "Token{" +
                "pozInitiala=" + pozInitiala +
                ", pozFinala=" + pozFinala +
                ", valoare=" + valoare +
                ", valMax=" + valMax +
                '}';
    }
}
