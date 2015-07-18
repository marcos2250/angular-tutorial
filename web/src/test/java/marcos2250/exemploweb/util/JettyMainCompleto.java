package marcos2250.exemploweb.util;

import marcos2250.exemploweb.util.ServidorHsqldbMain;

public class JettyMainCompleto {

    private static final String[] SEM_PARAMETROS = new String[] {};

    public static void main(String[] args) throws Exception {

        ServidorHsqldbMain.main(SEM_PARAMETROS);

        JettyMain.main(SEM_PARAMETROS);

    }
    
}
