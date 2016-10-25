package arrayandstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by magiclane on 25/10/2016.
 *
 * 1.1
 */
public class IsCharDifferent {

    /**
     * This is a bad one. Consume more memory if it's a longer string.
     * T: O(n)
     * S: O(n)
     * @param str
     * @return
     */
    static boolean isDifferent(String str) {
        Map<Character, Integer> tmp = new HashMap<>(str.length());
        for (int i = 0; i < str.length(); i ++) {
            if (tmp.put(str.charAt(i), 0) != null) {
                return false;
            }
        }

        return true;
    }

    /**
     * T: O(n^2)
     * S: 1
     * @param str
     * @return
     */
    static boolean isDifferent2(String str) {
        for (int i = 0; i < str.length(); i ++) {
            for (int j = i + 1; j < str.length(); j ++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isDifferentAscii(String str) {
        if (str.length() > 256) {
            return false;
        }

        boolean[] chars = new boolean[256];
        for (int i = 0; i < str.length(); i ++) {
            int charVal = str.charAt(i);
            if (chars[charVal]) {
                return false;
            }
            chars[charVal] = true;
        }

        return true;
    }

    public static void main(String[] args) {
    }
}


