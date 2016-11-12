package bitoperation;

/**
 * Created by magiclane on 12/11/2016.
 *
 * 5.1
 */
public class InsertNToM {
    private Integer insert(int m, int n, int i, int j) {
        int high = clearBitsJThrough0(n, j);
        int low = clearBitsMSBThroughI(n, i);
        return (m << i) + high + low;
    }

    private Integer clearBitsJThrough0(int n, int j) {
        int mask = ~((1 << (j+1)) - 1);
        return n & mask;
    }

    private Integer clearBitsMSBThroughI(int n, int i) {
        int mask = (1 << (i+1)) - 1;
        return mask & n;
    }

    public static void main(String[] args) {
        int n = 1 << 10;
        int m = 16 + 2 + 1;
        int i = 2, j = 6;
        InsertNToM insertNToM = new InsertNToM();
        System.out.println(Integer.toBinaryString(insertNToM.insert(m, n, i, j)));

    }
}
