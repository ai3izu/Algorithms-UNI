package Aproksymacyjne;

import java.util.Random;

public class PL_MonteCarlo {
    final static int N = 6; // <- liczba przedmiotow w plecaku
    final static int MAX_V = 10; // <- objetosc plecka

    final static int[] OBJETOSCI_P = {6, 2, 3, 2, 3, 1}; // <- objetosci przedmitow
    final static int[] WARTOSCI_P = {6, 4, 5, 7, 10, 2}; // <- wartosci przedmiotow

    public static void main(String[] args) {
        Random random = new Random();
        int sumaWartosci = 0;
        int sumaObjetosci = 0;
        int iloscSpakowanych = 0;
        String przedmiot = "";

        for (int i = 0; i < 10; i++) {
            boolean[] spakowaneP = new boolean[N];

            int obecnaWartosc = 0;
            int obecnaObjetosc = 0;
            int spakowane = 0;
            String obecnyPrzedmiot = " ";

            for (int j = 0; j < N; j++) {
                if (random.nextBoolean()){
                    spakowaneP[j] = true;
                    obecnaObjetosc += OBJETOSCI_P[j];
                    obecnaWartosc += WARTOSCI_P[j];
                    obecnyPrzedmiot += "p" + (j + 1 ) + " ";
                    spakowane++;
                }
            }
            if (obecnaWartosc > sumaWartosci && obecnaObjetosc <= MAX_V) {
                sumaWartosci = obecnaWartosc;
                sumaObjetosci = obecnaObjetosc;
                iloscSpakowanych = spakowane;
                przedmiot = obecnyPrzedmiot;
            }

        }
        System.out.println("\tWartosc zapakowanego plecaka = " + sumaWartosci + "\tLiczba spakowanych przedmiotow " + iloscSpakowanych);
        System.out.println("\t" + sumaObjetosci + "/" + MAX_V + " wykorzystana objetosc " +  " \t  przedmioty {" + przedmiot + "}");
    }

}
