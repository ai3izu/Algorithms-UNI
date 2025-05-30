package Dokladne;

public class KO_BF {
    static int[][] daneKosmonautow = {
            {1, 0, 0, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 1}
    };

    public static void main(String[] args) {
        int liczbaK = Integer.MAX_VALUE;
        String najlepszeRozwiazanie = " ";

        for (int k1 = 0; k1 <= 1 ; k1++) {
            for (int k2 = 0; k2 <= 1 ; k2++) {
                for (int k3 = 0; k3 <= 1; k3++) {
                    for (int k4 = 0; k4 <= 1 ; k4++) {
                        for (int k5 = 0; k5 <= 1 ; k5++) {
                            int[] kombinacja = {k1, k2, k3, k4, k5};
                            int[] pokryte = {0,0,0,0};

                            for (int i = 0; i < kombinacja.length; i++) {
                                if (kombinacja[i] == 1){
                                    int[] kw = daneKosmonautow[i];
                                    for (int j = 0; j < kw.length; j++) {
                                        pokryte[j] += kw[j];
                                    }
                                }
                            }
                            if (pokryte[0] > 0 && pokryte[1] > 0 && pokryte[2] > 0 && pokryte[3] > 0 ) {
                                int licznik = k1 + k2 + k3 + k4 + k5;
                                if (licznik < liczbaK) {
                                    liczbaK = licznik;
                                    if (k1 == 1) najlepszeRozwiazanie += "k1 ";
                                    if (k2 == 1) najlepszeRozwiazanie += "k2 ";
                                    if (k3 == 1) najlepszeRozwiazanie += "k3 ";
                                    if (k4 == 1) najlepszeRozwiazanie += "k4 ";
                                    if (k5 == 1) najlepszeRozwiazanie += "k5 ";
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(najlepszeRozwiazanie);
        System.out.println("Liczba kosmonautow : " + liczbaK);
    }
}
