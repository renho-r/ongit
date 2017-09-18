package j2setest.collection.list;

/**
 * @author renho
 * @since: 2017/9/6
 */
public class User {

    private String id;
    private String name;

    public User() {}

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
