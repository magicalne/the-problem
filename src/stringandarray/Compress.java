package stringandarray;

/**
 * Created by magiclane on 30/10/2016.
 *
 * 1.5
 */
public class Compress {

    private String compress(String src) {
        assert src != null;
        int length = src.length();
        if (length == 0) return src;

        int count = 1;
        char c = src.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < length; i++) {
            if (src.charAt(i) == c) {
                count ++;
            } else {
                stringBuilder.append(c);
                stringBuilder.append(count);

                count = 1;
                c = src.charAt(i);
            }
        }

        stringBuilder.append(c);
        stringBuilder.append(count);


        return stringBuilder.length() < length ? stringBuilder.toString() : src;
    }

    int compressLength(String str) {
        int length = str.length();
        if (length == 0) return 0;

        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < length; i++) {
            char now = str.charAt(i);
            if (last != now) {
                count ++;
                last = now;
            }
        }

        return count << 1;
    }

    String compressWithArray(String str) {
        assert str != null;
        int length = str.length();
        int compressLength = compressLength(str);
        if (length <= compressLength) return str;

        char[] result = new char[compressLength];
        int count = 1;
        int index = 0;
        char last = str.charAt(0);
        for (int i = 1; i < length; i++) {
            char now = str.charAt(i);
            if (last == now) {
                count ++;
            } else {
                result[index ++] = last;
                result[index ++] = Character.forDigit(count, 10);
                last = now;
                count = 1;
            }
        }

        result[index ++] = last;
        result[index] = Character.forDigit(count, 10);
        return new String(result);

    }

    public static void main(String[] args) {
        Compress compress = new Compress();
        System.out.println(compress.compressWithArray("aaabbc"));
    }
}
