package Aproksymacyjne;


public class PL_AZ {

    final static int N = 6; // <- liczba przedmiotow w plecaku
    final static int MAX_V = 10; // <- objetosc plecka

    final static int[] OBJETOSCI_P = {6, 2, 3, 2, 3, 1}; // <- objetosci przedmitow
    final static int[] WARTOSCI_P = {6, 4, 5, 7, 10, 2}; // <- wartosci przedmiotow

    public static void main(String[] args) {
        System.out.println("Wybierz cenne");
        wybierzCenne();
        System.out.println("\nWybierz najmniejsze");
        wybierzNajmniejsze();
    }


    private static void wybierzNajmniejsze() {
        boolean[] spakowane = new boolean[N];

        int sumaObjetosci = 0;
        int sumaWartosci = 0;

        String wybrane = " Przedmioty : ";
        while (true) {
            int minObjetosc = Integer.MAX_VALUE;
            int indexPrzedmiotu = -1;

            for (int i = 0; i < N; i++) {
              if (
                      OBJETOSCI_P[i] < minObjetosc &&
                      !spakowane[i] &&
                      sumaWartosci + OBJETOSCI_P[i] <= MAX_V
              ) {
                  minObjetosc = OBJETOSCI_P[i];
                  indexPrzedmiotu = i;
              }
            }
            if (indexPrzedmiotu == -1) {
                break;
            } else {
                spakowane[indexPrzedmiotu] = true;
                sumaWartosci += WARTOSCI_P[indexPrzedmiotu];
                sumaObjetosci += OBJETOSCI_P[indexPrzedmiotu];
                wybrane += " p" + (indexPrzedmiotu + 1) + " ";
            }
        }

        System.out.println("Wartosc zapakowanego plecaka = " + sumaWartosci);
        System.out.println(sumaObjetosci + " <-  objetosc wykorzystana");
        System.out.println(wybrane);
    }

    private static void wybierzCenne() {
        boolean[] spakowane = new boolean[N];

        int sumaObjetosci = 0;
        int sumaWartosci = 0;

        String wybrane = " Przedmioty : ";
        while (true) {
            int maxWartosc = 0;
            int indexPrzedmiotu = -1;

            for (int i = 0; i < N; i++) {
                if (
                        WARTOSCI_P[i] > maxWartosc &&
                        !spakowane[i] &&
                        sumaObjetosci + OBJETOSCI_P[i] <= MAX_V
                ) {
                    maxWartosc = WARTOSCI_P[i];
                    indexPrzedmiotu = i;
                }
            }
            if (indexPrzedmiotu == -1) {
                break;
            } else {
                spakowane[indexPrzedmiotu] = true;
                sumaWartosci += WARTOSCI_P[indexPrzedmiotu];
                sumaObjetosci += OBJETOSCI_P[indexPrzedmiotu];
                wybrane += " p" + (indexPrzedmiotu + 1) + " ";
            }
        }

        System.out.println("Wartosc zapakowanego plecaka = " + sumaWartosci);
        System.out.println(sumaObjetosci + " <-  objetosc wykorzystana");
        System.out.println(wybrane);
    }
}
