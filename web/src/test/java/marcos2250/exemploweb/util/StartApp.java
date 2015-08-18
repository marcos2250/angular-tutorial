package marcos2250.exemploweb.util;

public class StartApp {

    private static final String[] SEM_PARAMETROS = new String[] {};

    public static void main(String[] args) throws Exception {

        ServidorHsqldbMain.main(SEM_PARAMETROS);

        JettyMain.main(SEM_PARAMETROS);

    }
    
}
