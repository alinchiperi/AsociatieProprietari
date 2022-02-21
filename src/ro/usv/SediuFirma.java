package ro.usv;
/**
 * @author Alin CHIPERI
 * @grupa 3131a
 * @nr 1
 */

public class SediuFirma extends Apartament {
    final static String tip = "SF";
    private String denumire;
    private int CUI;

    public SediuFirma(int id, float suprafata, int anConstructie, String strada, int nr, char scara, int etaj, int nrApt, String denumire, int CUI) {
        super(tip, id, suprafata, anConstructie, strada, nr, scara, etaj, nrApt);
        this.denumire = denumire;
        this.CUI = CUI;
    }

    @Override
    public String toString() {
        return "\n{Tip=" + tip +
                ", " + super.toString() +
                ", denumire='" + denumire + '\'' +
                ", CUI=" + CUI +
                '}';
    }
}
