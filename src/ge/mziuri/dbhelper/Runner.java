package ge.mziuri.dbhelper;

import ge.mziuri.dbhelper.reflection.TableCreator;

public class Runner {

    public static void main(String[] args) {
        try {
            TableCreator.createTables("jdbc:postgresql://localhost:5432/League",
                    "postgres", "rame");
        } catch (Exception ex) {
            System.out.println("Can't create tables");
            ex.printStackTrace();
        }
    }
}
