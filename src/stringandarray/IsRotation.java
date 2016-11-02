package stringandarray;

/**
 * Created by magiclane on 01/11/2016.
 *
 * 1.8
 */
public class IsRotation {

    boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s2 + s2).contains(s1);
    }
    public static void main(String[] args) {
        IsRotation isRotation = new IsRotation();
        System.out.println(isRotation.isRotation("waterbottle", "terbottlewa"));
    }
}
