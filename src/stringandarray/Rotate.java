package stringandarray;

/**
 * Created by magiclane on 30/10/2016.
 *
 * 1.5
 */
public class Rotate {

    void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n-layer-1;
            for (int i = layer; i < last; i++) {
                int top = matrix[layer][i]; //store top
                //top = right
                matrix[layer][i] = matrix[n-i-1][layer];
                //right = bottom
                matrix[n-1-i][layer] = matrix[n-1-layer][n-i-1];
                //bottom = left
                matrix[n-1-layer][n-1-i] = matrix[i][n-layer-1];
                //left = top
                matrix[i][n-layer-1] = top;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        int count = 0;
        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
                matrix[i][j] = ++count;
            }

            for (int j = 0; j < 4; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("========================");
        Rotate rotate = new Rotate();
        rotate.rotate(matrix, 4);

        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
