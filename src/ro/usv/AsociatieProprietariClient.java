package ro.usv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Alin CHIPERI
 * @grupa 3131a
 * @nr 1
 */

public class AsociatieProprietariClient {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(args[0]));
        /* Pentru scrierea in fisier a rezultatelor :
        File file = new File("out1.txt");
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps); // setez iesirea system ca fiind fisierul out.txt
        */
        IAsociatieProprietariServ1 asoc = new AsociatieProprietariServ();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] param = line.split("\\s+(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");  // separarea argumentelor igorand ""
            System.out.println(line);
            switch (param[0]) {
                case "file":
                    if (param.length != 2)
                        System.out.println("Eroare. Numarul parametrilor nu este corect");
                    else {
                        asoc.setStocare(param[1]);
                    }
                    break;
                case "clear":
                    if (param.length != 1)
                        System.out.println("Eroare. Numarul parametrilor nu este corect");
                    else {
                        asoc.deleteApartmente();
                        System.out.println("S-au eliminat toate apartamentele");
                    }
                    break;
                case "delete":
                    if (param.length != 2)
                        System.out.println("Eroare. Numarul parametrilor nu este corect");
                    else {
                        try {
                            asoc.deleteApartment(Integer.parseInt(param[1]));
                            //System.out.println("S-a eliminat apartamentul cu id: " + param[1]);
                        } catch (Exception e) {
                            System.out.println("Eroare. " + e.getMessage());
                        }
                    }
                    break;
                case "add":
                    try {
                        switch (param[1]) {
                            case "L":
                                if (param.length != 11) {
                                    System.out.println("Eroare. Numarul parametrilor nu este corect");
                                } else {
                                    param[5] = param[5].replace("\"", " ").trim();
                                    Locuinta ap = new Locuinta(Integer.parseInt(param[2]), Float.parseFloat(param[3]), Integer.parseInt(param[4]), param[5], Integer.parseInt(param[6]), param[7].charAt(0), Integer.parseInt(param[8]), Integer.parseInt(param[9]), Integer.parseInt(param[10]));
                                    asoc.saveApartament(ap);
                                }
                                break;
                            case "SF":
                                if (param.length != 12) {
                                    System.out.println("Eroare. Numarul parametrilor nu este corect");
                                } else {
                                    param[10] = param[10].replace("\"", " ").trim();
                                    param[5] = param[5].replace("\"", " ").trim();
                                    SediuFirma sf = new SediuFirma(Integer.parseInt(param[2]), Float.parseFloat(param[3]), Integer.parseInt(param[4]), param[5], Integer.parseInt(param[6]), param[7].charAt(0), Integer.parseInt(param[8]), Integer.parseInt(param[9]), param[10], Integer.parseInt(param[11]));
                                    asoc.saveApartament(sf);
                                }
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Eroare. " + e.getMessage());
                    }
                    break;
                case "count":
                    if (param.length == 1) {
                        int apart = asoc.countApartamente("L") + asoc.countApartamente("SF");
                        System.out.println("Nr.apartamente: " + apart);
                    } else if (param.length == 2) {
                        if (param[1].equals("L"))
                            System.out.println("Nr.locuinte: " + asoc.countApartamente("L"));
                        else if (param[1].equals("SF"))
                            System.out.println("Nr.sedii firme: " + asoc.countApartamente("SF"));
                        else
                            System.out.println("Nu sunt apartamente de tipul " + param[1]);
                    } else {
                        System.out.println("Eroare. Numarul parametrilor nu este corect");
                    }
                    break;
                case "newer":
                    if (param.length != 2) {
                        System.out.println("Eroare. Numarul parametrilor nu este corect");
                    } else
                        try {
                            System.out.println("Ap. construite cu cel mult " + param[1] + " ani in urma: " + asoc.findIdsNewerThan(Integer.parseInt(param[1])));
                        } catch (Exception e) {
                            System.out.println("Eroare. " + e.getMessage());
                        }
                    break;
                case "street":
                    if (param.length != 2) {
                        System.out.println("Eroare. Numarul parametrilor nu este corect");
                    } else
                        try {
                            param[1] = param[1].replace("\"", " ").trim();
                            System.out.println("Ap. str. " + param[1] + asoc.findIdsByStreet(param[1]));

                        } catch (Exception e) {
                            System.out.println("Eroare. " + e.getMessage());
                        }
                    break;
                case "list":
                    if (param.length == 1) {
                        System.out.println(asoc.getApartamentente());
                    }
                    else if (param.length == 2) {
                        try {
                            if (asoc.getApartamentById(Integer.parseInt(param[1])) != null) {
                                System.out.println(asoc.getApartamentById(Integer.parseInt(param[1])));
                            } else {
                                System.out.println("Eroare. Nu exista apartament cu id=" + param[1]);
                            }
                        } catch (Exception e) {
                            System.out.println("Eroare. " + e.getMessage());
                        }
                    }
                    break;
                case "rem":
                    for (String s : param)
                        System.out.print(s + " ");
                    System.out.println();
                    break;
                case "countsurf":
                    if (param.length<3)
                        System.out.println("Eroare. Numarul parametrilor nu este corect");
                    else {
                        try {
                            System.out.println(asoc.countSurf(param[1], Integer.parseInt(param[2])));
                        }catch (Exception e ){
                            System.out.println("Eroare. " + e.getMessage());
                        }
                    }
                    break;
                case "select":
                    if (param.length!=3)
                        System.out.println("Eroare. Numarul parametrilor nu este corect");
                    else {
                        try {
                        System.out.println(asoc.selectSminEmax(Integer.parseInt(param[1]),Integer.parseInt(param[2])));
                        }catch (Exception e ){
                            System.out.println("Eroare. " + e.getMessage());
                        }
                    }
                    break;
                case "expenses":
                    if(param.length!=2)
                        System.out.println("Eroare. Numarul parametrilor nu este corect");
                    else {
                        try{
                            System.out.println(asoc.expenses(Integer.parseInt(param[1])));
                        }catch (Exception e)
                        {
                            System.out.println("Eroare. "+ e.getMessage());
                        }
                    }
                    break;
                case "stop":
                    System.out.println("La revedere!");
                    scan.close();
                    //ps.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comanda inexistenta");
                    break;
            }
        }
        scan.close();
        //ps.close();
    }
}
