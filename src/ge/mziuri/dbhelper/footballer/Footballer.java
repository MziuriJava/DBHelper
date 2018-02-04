package ge.mziuri.dbhelper.footballer;

import ge.mziuri.dbhelper.annotations.Table;
import ge.mziuri.dbhelper.annotations.TableField;

@Table
public class Footballer {

    @TableField(id = true)
    private int id;

    @TableField(length = 100, notNull = true)
    private String name;

    @TableField
    private Integer goals;

    @TableField
    private Double rank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }
}
