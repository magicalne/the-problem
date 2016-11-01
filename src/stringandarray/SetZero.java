package stringandarray;

/**
 * Created by magiclane on 01/11/2016.
 * 1.7
 */
public class SetZero {

    void setZero(int[][] arr, int m, int n) {
        int[] xs = new int[m];
        int[] ys = new int[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    xs[count] = i;
                    ys[count] = j;
                    count ++;
                    if (i < m-1) {
                        i ++;
                        j = 0;
                    }
                }
            }
        }

        for (int i = 0; i < count; i++) {
            for (int y = 0; y < n; y++) {
                arr[xs[i]][y] = 0;
            }
            for (int x = 0; x < m; x++) {
                arr[x][ys[i]] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetZero setZero = new SetZero();
        int[][] arr = new int[][] {
                {1,2,3,4,5},
                {2,1,0,12,1},
                {1,2,0,4,1}
        };
        int m = 3, n = 5;
        setZero.setZero(arr, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
