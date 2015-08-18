package string.any;

/**
 * Created by sharath on 7/26/15.
 */
public class ChangeXY {
    public String changeXY(String str) {
        if(str == null || str.isEmpty()) return str;
        return changeXYRec("", str);
    }
    private String changeXYRec(String prefix, String suffix) {
        if(suffix == null || suffix.equals(""))
            return prefix;
        else {
            if(suffix.charAt(0) == 'x')
                return changeXYRec((prefix + 'y'), suffix.substring(1, suffix.length()));
            else
                return changeXYRec((prefix + suffix.charAt(0)), suffix.substring(1, suffix.length()));
        }
    }

    public static void main(String[] args) {
        System.out.println(new ChangeXY().changeXY("codex"));
    }
}
