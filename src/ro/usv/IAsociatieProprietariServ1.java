package ro.usv;

import java.util.List;
/**
 * @author Alin CHIPERI
 * @grupa 3131a
 * @nr 1
 */
public interface IAsociatieProprietariServ1 {
    void setStocare(String nume);

     Apartament getApartamentById(int id);

     List<Apartament> getApartamentente();

     void saveApartament(Apartament ap);

     void deleteApartment(int id);

     void deleteApartmente();

     int countApartamente(String tip);

     List<Integer> findIdsNewerThan(int nrAni);

     List<Integer> findIdsByStreet(String numeStrada);

     int countSurf(String tip, int smin);

     List<Integer> selectSminEmax(int smin, int etajmax);

     float expenses (int id);
}
