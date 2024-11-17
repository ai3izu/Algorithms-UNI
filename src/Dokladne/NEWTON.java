package Dokladne;


public class NEWTON {
    static int N = 10;
    static int K = 3;
    public static void main(String[] args) {

        //System.out.println( newtonDZ(10,3));

        int[][] tab = newtonPD(N,K);

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                    System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }


    // WERSJA DZIEL I ZWYCIEZAJ
    public static int newtonDZ(int n, int k){
      if (k == 0 || k == n) return  1;
      if (0 < k && k < n) {
          return newtonDZ(n-1,k-1) + newtonDZ(n-1, k);
      }
      return -1;
    }

    // WERSJA DYNAMICZNA
    public static int[][] newtonPD(int n, int k){
        int[][] tab = new int[n+1][k+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0 || j == i){
                    tab[i][j] = 1;
                    continue;
                }
                if (0 < j && j < i){
                    tab[i][j] = tab[i-1][j-1] + tab[i-1][j];
                    continue;
                }
            }
        }
        return tab;
    }
}
