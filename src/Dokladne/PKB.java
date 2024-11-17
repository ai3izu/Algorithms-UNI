package Dokladne;

public class PKB {
    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            if (pkbDZ(i) >= 12000f){
//                System.out.println("PKB polski podwoi sie po " + i + " latach");
//                break;
//            }
//        }
//
//        for (int i = 0; i < 20; i++) {
//            if (pkbDZ(i) >= pkbDE(i)){
//                System.out.println("PKB polski dorowna PKB niemiec po  " + i + " latach");
//                break;
//            }
//        }

        float[] tab = pkbPD(20);
        float[] tab2 = pkbPDde(20);
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] >= 12000f) {
                System.out.println("PKB polski podwoi sie po " + i + " latach");
                break;
            }
        }

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] >= tab2[i]) {
                System.out.println("PKB polski dorowna PKB niemiec po  " + i + " latach");
                break;
            }
        }
    }


    public static float pkbDZ(int n) {
        if (n == 0) {
            return 6000f;
        } else {
            return pkbDZ(n - 1) * (1 + 0.06f);
        }

    }

    public static float pkbDE(int n) {
        if (n == 0) {
            return 12000f;
        } else {
            return pkbDE(n - 1) * (1 + 0.012f);
        }
    }

    public static float[] pkbPD(int n) {
        float[] tab = new float[n + 1];
        tab[0] = 6000f;
        for (int i = 1; i < tab.length; i++) {
            tab[i] = tab[i - 1] * (1 + 0.06f);
        }
        return tab;
    }

    public static float[] pkbPDde(int n) {
        float[] tab = new float[n + 1];
        tab[0] = 12000f;
        for (int i = 1; i < tab.length; i++) {
            tab[i] = tab[i - 1] * (1 + 0.012f);
        }
        return tab;
    }
}
