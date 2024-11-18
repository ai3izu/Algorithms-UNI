package Aproksymacyjne;

import java.util.Random;

public class KO_BL {
    static int[][] daneKosmonautow = {
            {1, 0, 0, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 1}
    };
    static final int SPEC = 4;

    public static void main(String[] args) {
        Random rand = new Random();

        int liczbaK = Integer.MAX_VALUE;
        String najlepszeRozwiazanie = " ";

        boolean[] wybraniK = new boolean[daneKosmonautow.length];


        for (int i = 0; i < 5; i++) {
            int[] specK = new int[SPEC];

            int index = 0;
            index = rand.nextInt(daneKosmonautow.length);

            int liczbaWybranych = 0;
            String biezaceRozwiazanie = " ";

            if (rand.nextBoolean()){
                wybraniK[index] = !wybraniK[index];
            }

            for (int j = 0; j < daneKosmonautow.length; j++) {

                if (wybraniK[j]) {
                    for (int k = 0; k < SPEC; k++) {
                        specK[k] += daneKosmonautow[j][k];
                    }
                    liczbaWybranych++;
                    biezaceRozwiazanie += "k" + (j + 1) + " ";
                }

            }

            if(specK[0] > 0 && specK[1] > 0 && specK[2] > 0 && specK[3] > 0 && liczbaWybranych < liczbaK ){
                najlepszeRozwiazanie = biezaceRozwiazanie;
                liczbaK = liczbaWybranych;
            }else {
                wybraniK[index] = !wybraniK[index];
            }

        }
        System.out.println("Liczba zalogi " + liczbaK);
        System.out.println("Kosmonauci " + najlepszeRozwiazanie);
    }
}
