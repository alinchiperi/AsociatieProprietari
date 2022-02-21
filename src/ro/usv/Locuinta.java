package ro.usv;
/**
 * @author Alin CHIPERI
 * @grupa 3131a
 * @nr 1
 */
public class Locuinta extends Apartament {
    final static String tip = "L";
    private int nrPersoane = 1;

    public Locuinta(int id, float suprafata, int anConstructie, String strada, int nr, char scara, int etaj, int nrApt, int nrPersoane) {
        super(tip, id, suprafata, anConstructie, strada, nr, scara, etaj, nrApt);
        if (nrPersoane >= 0)
            this.nrPersoane = nrPersoane;
        else throw new IllegalArgumentException("Numar de persoane negativ");
    }

    @Override
    public String toString() {
        return "\n{Tip=" + tip +
                ", " + super.toString() +
                ", nrPersoane=" + nrPersoane +
                '}';
    }

}
