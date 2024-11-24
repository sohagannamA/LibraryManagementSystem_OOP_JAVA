package Model;

public class User {
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserName() {
        return userId;
    }

    public String getName() {
        return name;
    }

    @Override

    public String toString() {
        return String.format("User[ID=%s, Name=%s]", userId, name);
    }
}
