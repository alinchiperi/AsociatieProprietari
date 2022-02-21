package ro.usv;

import ro.usv.dao.Entitate;

import java.time.LocalDate;
import java.util.Calendar;
/**
 * @author Alin CHIPERI
 * @grupa 3131a
 * @nr 1
 */
public abstract class Apartament extends Entitate<Integer> {
    private String tip;
    private int id;
    private float suprafata;
    private int anConstructie;
    private String strada;
    private int nr;
    private char scara;
    private int etaj;
    private int nrApt;

    public Apartament(String tip, int id, float suprafata, int anConstructie, String strada, int nr, char scara, int etaj, int nrApt) {
        this.tip = tip;
        this.id = id;
        if (suprafata > 0)
            this.suprafata = suprafata;
        else throw new IllegalArgumentException("Suprafata negativa");
        if (anConstructie < Calendar.getInstance().get(Calendar.YEAR))
            this.anConstructie = anConstructie;
        else throw new IllegalArgumentException("An de constructie gresit");
        this.strada = strada;
        if (nr > 0)
            this.nr = nr;
        else throw new IllegalArgumentException("nr strada negativ");
        this.scara = scara;
        this.etaj = etaj;
        this.nrApt = nrApt;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", suprafata=" + suprafata +
                ", anConstructie=" + anConstructie +
                ", strada='" + strada + '\'' +
                ", nr=" + nr +
                ", scara=" + scara +
                ", etaj=" + etaj +
                ", nrApt=" + nrApt;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVechime() {
        LocalDate start = LocalDate.of(anConstructie, 1, 1);
        LocalDate stop = LocalDate.now();
        return (int) java.time.temporal.ChronoUnit.YEARS.between(start, stop);
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public float getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(float suprafata) {
        this.suprafata = suprafata;
    }

    public int getAnConstructie() {
        return anConstructie;
    }

    public void setAnConstructie(int anConstructie) {
        this.anConstructie = anConstructie;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public char getScara() {
        return scara;
    }

    public void setScara(char scara) {
        this.scara = scara;
    }

    public int getEtaj() {
        return etaj;
    }

    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }

    public int getNrApt() {
        return nrApt;
    }

    public void setNrApt(int nrApt) {
        this.nrApt = nrApt;
    }
}
