package ge.mziuri.dbhelper.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TableField {
    int length() default 200;
    boolean notNull() default false;
    boolean unique() default false;
    boolean id() default false;
}
