package ge.mziuri.dbhelper.reflection;

import ge.mziuri.dbhelper.footballer.Footballer;
import org.junit.Assert;
import org.junit.Test;

public class TableCreateTest {

    private static final Class testClass = Footballer.class;

    private static final String sql =
            "CREATE TABLE Footballer(" +
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "goals INT," +
                    "rank REAL)";

    @Test
    public void testGetCreateSql() {
        Assert.assertEquals(sql, TableCreator.getCreateSQL(testClass));
    }
}
