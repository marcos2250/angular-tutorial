package marcos2250.exemploweb.util;

public class ServidorHsqldbMain {

    public static void main(String[] args) {
        System.out.println("Iniciando banco de dados HSQLDB...");
        org.hsqldb.Server.main(new String[] //
        { "-database.0", "file:target/hsqldb", "-dbname.0", "exemploweb" }); // banco no hd
        // { "-database.0", "mem:test" }); // banco em memoria
    }
}
