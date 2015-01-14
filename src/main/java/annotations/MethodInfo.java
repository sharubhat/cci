package annotations;

import java.lang.annotation.*;

/**
 * Created by sharath on 9/14/14.
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "Sharath";
    String date();
    int revision() default 1;
    String comments();
}
