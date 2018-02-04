package ge.mziuri.dbhelper.footballer;

import ge.mziuri.dbhelper.annotations.Table;
import ge.mziuri.dbhelper.annotations.TableField;

@Table
public class Team {

    @TableField(id = true)
    private int id;

    @TableField(length = 200)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
