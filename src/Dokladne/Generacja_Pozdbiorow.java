package Dokladne;

public class Generacja_Pozdbiorow {
    public static void main(String[] args) {
        int k1, k2, k3, k4, k5;

        for (k1 = 0; k1 <= 1; k1++) {
            for (k2 = 0; k2 <= 1; k2++) {
                for (k3 = 0; k3 <= 1; k3++) {
                    for (k4 = 0; k4 <= 1; k4++) {
                        for (k5 = 0; k5 <= 1; k5++) {
                            System.out.print("{ ");
                            if (k1 == 1) System.out.print("1");
                            if (k2 == 1) System.out.print("2");
                            if (k3 == 1) System.out.print("3");
                            if (k4 == 1) System.out.print("4");
                            if (k5 == 1) System.out.print("5");
                            System.out.println(" }");
                        }
                    }
                }
            }
        }
    }
}
