package stringandarray;

/**
 * Created by magiclane on 27/10/2016.
 *
 * 1.4
 */
public class ReplaceSpace {
    private String replaceSpace(String str) {
        if ("".equals(str)) return str;

        int count = 0;
        final char space = ' ';
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == space) {
                count ++;
            }
        }

        char[] after = new char[count*2 + length];
        int index = 0;
        for (int i = 0; i < length; i ++) {
            char tmp = str.charAt(i);
            if (tmp == ' ') {
                after[index ++] = '%';
                after[index ++] = '2';
                after[index ++] = '0';
            } else {
                after[index ++] = tmp;
            }
        }
        return new String(after);
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("fasd adfadfaewf af afaf afa A A    ADFA      "));
        System.out.println(replaceSpace.replaceSpace(" "));
    }
}
