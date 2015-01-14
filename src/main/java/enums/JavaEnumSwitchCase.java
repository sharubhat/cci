package enums;

/**
 * Created by sharath on 9/14/14.
 */
public class JavaEnumSwitchCase {
    enum Margin {
        TOP, RIGHT, BOTTOM, LEFT
    }

    public static void main(String[] args) {
        System.out.println(getMarginValues(Margin.TOP));
    }

    private static String getMarginValues(Margin margin) {
        switch(margin) {
            case TOP:       return "1em";
            case RIGHT:     return "12 px";
            case BOTTOM:    return "1.5em";
            case LEFT:      return "6px";
            default:        return null;
        }
    }


}
