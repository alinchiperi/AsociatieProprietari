package ro.usv;

import ro.usv.dao.Dao;
import ro.usv.dao.SerializareDao;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Alin CHIPERI
 * @grupa 3131a
 * @nr 1
 */
public class AsociatieProprietariServ implements IAsociatieProprietariServ1 {
    Dao<Apartament, Integer> sDao;

    public AsociatieProprietariServ() {
        this.sDao = new SerializareDao<>();
    }

    public AsociatieProprietariServ(String numeFisierSerializare) {
        this.sDao = new SerializareDao<>(numeFisierSerializare);
    }

    /**
     * Functie pentru setarea mediului de stocare
     * @param nume numele fisierului in care vor fi inserate operatiile
     */
    @Override
    public void setStocare(String nume) {
        this.sDao = new SerializareDao<>(nume);
    }

    @Override
    public Apartament getApartamentById(int id) {
        return sDao.get(id);
    }

    @Override
    public List<Apartament> getApartamentente() {
        return sDao.getAll();
    }

    @Override
    public void saveApartament(Apartament ap) {
        sDao.save(ap);
    }

    @Override
    public void deleteApartment(int id) {
        sDao.delete(id);
    }

    @Override
    public void deleteApartmente() {
        sDao.deleteAll();
    }

    /**
     * Nuara apartamentele de un anumti tip
     * @param tip- tipul apartamentului
     * @return int- numarul apartamentelor de tipul tip
     */
    @Override
    public int countApartamente(String tip) {
        List<Apartament> apartamente = getApartamentente();
        int nr = 0;
        for (Apartament a : apartamente) {
            if (a.getTip().equals(tip))
                nr++;
        }
        return nr;
    }

    /**
     * Functie pentru gasirea apartamentelor mai noi de un anumit an
     * @param nrAni
     * @return o lista de id-uri
     */
    @Override
    public List<Integer> findIdsNewerThan(int nrAni) {
        List<Apartament> apartamente = getApartamentente();
        List<Integer> listaId = new ArrayList<>();
        for (Apartament a : apartamente) {
            if (a.getVechime() <= nrAni) {
                listaId.add(a.getId());
            }
        }
        return listaId;
    }

    /**
     *
     * @param numeStrada numele strazii
     * @return lista de id-uri de pe strada cu numele dat
     */
    @Override
    public List<Integer> findIdsByStreet(String numeStrada) {
        List<Apartament> apartamente = getApartamentente();
        List<Integer> listaId = new ArrayList<>();
        for (Apartament a : apartamente) {
            if (a.getStrada().equalsIgnoreCase(numeStrada)) {
                listaId.add(a.getId());
            }
        }
        return listaId;
    }

    /**
     *
     * @param tip Tipul apartamentului
     * @param smin suprafata minima
     * @return numarul de apartamente de un anumit tip si care au suprafata mai mica decat smin
     */
    @Override
    public int countSurf(String tip, int smin) {
        List<Apartament> apartamente = getApartamentente();
        int nr=0;
        for (Apartament a : apartamente) {
        if(a.getTip().equals(tip) && a.getSuprafata()>=smin )
            nr++;
        }
        return nr;
    }

    /**
     *
     * @param smin
     * @param etajmax
     * @return Lista de id-uri care au suprafata <= smin si etajul>=etajmax
     */
    @Override
    public List<Integer> selectSminEmax(int smin, int etajmax) {
        List<Apartament> apartamente = getApartamentente();
        List<Integer> listaId = new ArrayList<>();
        for (Apartament a : apartamente) {
            if(a.getSuprafata()>=smin && a.getEtaj()<=etajmax)
                listaId.add(a.getId());
        }
        return listaId;
    }
    @Override
    public float expenses(int id) {
        Apartament a = sDao.get(id);
        float cost = 0;
        if (a.getTip().equals("L")) {
            cost += a.getSuprafata() * 10 + 10;
        }
        else if (a.getTip().equals("SF")) {
            cost += a.getSuprafata() * 10 + 50;
        }
        return cost;
    }
}
