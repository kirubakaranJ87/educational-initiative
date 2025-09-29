package singleton;

class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private String connString;

    private DatabaseConnection(String connString) {
        this.connString = connString;
        System.out.println("Database connected with " + connString);
    }

    public static DatabaseConnection getInstance(String connString) {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection(connString);
                }
            }
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("[" + connString + "] Executing query: " + sql);
    }
}

public class DbSingletonDemo {
    public static void main(String[] args) {
        DatabaseConnection a = DatabaseConnection.getInstance("db://primary");
        DatabaseConnection b = DatabaseConnection.getInstance("db://secondary");

        System.out.println("a == b ? " + (a == b));
        b.query("SELECT * FROM users");
    }
}
