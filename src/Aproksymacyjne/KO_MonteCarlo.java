package Aproksymacyjne;

import java.util.Random;

public class KO_MonteCarlo {
    static int[][] daneKosmonautow = {
            {1, 0, 0, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 1}
    };
    static final int KOSMONAUCI = 5;
    static final int SPEC = 4;

    public static void main(String[] args) {
        Random rand = new Random();

        int liczbaK = Integer.MAX_VALUE;
        String najlepszeRozwiazanie = " ";

        for (int i = 0; i < 100; i++) {
            boolean[] wybraniK = new boolean[KOSMONAUCI];
            int[] specK = new int[SPEC];

            int liczbaWybranych = 0;
            String biezaceRozwiazanie = " ";

            for (int j = 0; j < KOSMONAUCI; j++) {
                if (rand.nextBoolean()) {
                    wybraniK[j] = true;
                    for (int k = 0; k < SPEC; k++) {
                        specK[k] += daneKosmonautow[j][k];
                    }
                    biezaceRozwiazanie += "k" + (j + 1) + " ";
                    liczbaWybranych ++;
                }
            }
            if(specK[0] > 0 && specK[1] > 0 && specK[2] > 0 && specK[3] > 0 && liczbaWybranych < liczbaK ){
                najlepszeRozwiazanie = biezaceRozwiazanie;
                liczbaK = liczbaWybranych;
            }

        }
        System.out.println("Liczba zalogi " + liczbaK);
        System.out.println("Kosmonauci " + najlepszeRozwiazanie);
    }
}
