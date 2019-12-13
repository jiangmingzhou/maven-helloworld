package my.zjm.mybatis.entity;

/**
 * A database object maps to table 'demo' in database.
 *
 * @author jiangmingzhou
 */
public class DemoEntity {

    private int id;

    private String comment;

    public DemoEntity() {
    }

    public DemoEntity(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override public String toString() {
        return "DemoEntity{" + "id=" + id + ", comment='" + comment + '\'' + '}';
    }
}
