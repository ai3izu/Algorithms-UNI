package Aproksymacyjne;

import java.util.Random;

public class PL_BL {
    final static int N = 6; // <- liczba przedmiotow w plecaku
    final static int MAX_V = 10; // <- objetosc plecka

    final static int[] OBJETOSCI_P = {6, 2, 3, 2, 3, 1}; // <- objetosci przedmitow
    final static int[] WARTOSCI_P = {6, 4, 5, 7, 10, 2}; // <- wartosci przedmiotow

    public static void main(String[] args) {
        Random rand = new Random();

        int sumaWartosci = 0;
        int sumaObjetosci = 0;
        int iloscSpakowanych = 0;

        boolean[] spakowaneP = new boolean[N];


        for (int i = 0; i < 5; i++) {
            int indexPrzedmiotu = rand.nextInt(N);

            int obecnaWartosc = 0;
            int obecnaObjetosc = 0;
            int spakowane = 0;

            if (rand.nextBoolean()){
                spakowaneP[indexPrzedmiotu] = !spakowaneP[indexPrzedmiotu];
            }

            for (int j = 0; j < N; j++) {
                if (spakowaneP[j]) {
                    obecnaWartosc += WARTOSCI_P[j];
                    obecnaObjetosc += OBJETOSCI_P[j];
                    spakowane++;
                }
            }
            if (obecnaWartosc > sumaWartosci && obecnaObjetosc <= MAX_V) {
                sumaWartosci = obecnaWartosc;
                sumaObjetosci = obecnaObjetosc;
                iloscSpakowanych = spakowane;
            }else {
                spakowaneP[indexPrzedmiotu] = !spakowaneP[indexPrzedmiotu];
            }
        }

        System.out.println("Wartosc zapakowanego plecaka = " + sumaWartosci + " liczba spakowanych przedmiotow " + iloscSpakowanych);
        System.out.println(sumaObjetosci + "/" + MAX_V + " wykorzystana objetosc");
    }
}
