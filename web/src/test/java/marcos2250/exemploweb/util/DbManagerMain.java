package marcos2250.exemploweb.util;

public class DbManagerMain {

    public static void main(String[] args) {
        System.out.println("Abrindo DBManager...");
        org.hsqldb.util.DatabaseManagerSwing.main(new String[] //
        { "-driver", "org.hsqldb.jdbc.JDBCDriver", "-user", "sa", "-url", "jdbc:hsqldb:hsql://localhost/exemploweb" });
    }
}
