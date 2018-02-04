package ge.mziuri.dbhelper.reflection;

import ge.mziuri.dbhelper.annotations.TableField;
import ge.mziuri.dbhelper.footballer.Footballer;
import ge.mziuri.dbhelper.footballer.Team;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {

    public static void createTables(String url, String username, String password) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        List<Class> classes = new ArrayList<>();
        classes.add(Footballer.class);
        classes.add(Team.class);

        for (Class clazz : classes) {
            createTable(clazz, connection);
        }
    }


    private static void createTable(Class clazz, Connection connection) throws SQLException {
        Statement stm = connection.createStatement();
        stm.executeUpdate(getCreateSQL(clazz));
    }

    protected static String getCreateSQL(Class clazz) {
        String sql = "CREATE TABLE ";
        sql += clazz.getSimpleName();
        sql += "(";

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof TableField) {
                    String fieldSql = field.getName() + " ";
                    if (((TableField) annotation).id()) {
                        fieldSql += "SERIAL PRIMARY KEY";
                    } else {
                        Class type = field.getType();
                        if (type.isAssignableFrom(Integer.class)) {
                            fieldSql += "INT";
                        } else if (type.isAssignableFrom(Double.class)) {
                            fieldSql += "REAL";
                        } else if (type.isAssignableFrom(String.class)) {
                            fieldSql += "VARCHAR(" + ((TableField) annotation).length() + ") ";
                        }
                    }
                    if (((TableField) annotation).notNull()) {
                        fieldSql += "NOT NULL";
                    }
                    if (((TableField) annotation).unique()) {
                        fieldSql += "UNIQUE";
                    }
                    sql += fieldSql + ",";
                }
            }
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += ")";
        return sql;
    }
}
