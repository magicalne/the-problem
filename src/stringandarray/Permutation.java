package stringandarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by magiclane on 27/10/2016.
 *
 * 1.3
 */
public class Permutation {

    private String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    private boolean permutation1(String origin, String target) {
        if (origin.length() != target.length()) return false;

        return sort(origin).equals(sort(target));
    }

    private boolean permutation2(String origin, String target) {
        if (origin.length() != target.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < origin.length(); i++) {
            char key = origin.charAt(i);
            Integer val = map.get(key);
            if (val != null) {
                map.put(key, val + 1);
            } else {
                map.put(key, 0);
            }
        }

        for (int i = 0; i < target.length(); i++) {
            char key = target.charAt(i);
            Integer val = map.get(key);
            if (val != null) {
                if (map.put(key, val - 1) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
//        System.out.println(permutation.permutation1("abc", "cba"));
        System.out.println(permutation.permutation2("ab-c", "cb-a"));
    }

}
