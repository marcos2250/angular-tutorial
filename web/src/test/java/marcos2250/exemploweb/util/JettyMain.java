package marcos2250.exemploweb.util;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyMain {

    private static final int UMA_HORA_EM_MS = 1000 * 60 * 60;
    private static final int PORTA = 8080;
    private static final int TEMPO_ESPERA_CONSOLE_MS = 5000;
    private static final int CODIGO_ERRO_SAIDA = 100;

    public static void main(String[] args) {
        Server server = configureServer();
        try {
            System.out.println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP");
            server.start();

            while (System.in.available() == 0) {
                Thread.sleep(TEMPO_ESPERA_CONSOLE_MS);
            }
            server.stop();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(CODIGO_ERRO_SAIDA);
        }
    }

    private static Server configureServer() {
        Server server = new Server();

        SocketConnector connector = new SocketConnector();
        // Set some timeout options to make debugging easier.
        connector.setMaxIdleTime(UMA_HORA_EM_MS);
        connector.setSoLingerTime(-1);
        connector.setPort(PORTA);
        server.setConnectors(new Connector[] { connector });

        WebAppContext context = new WebAppContext();
        context.setServer(server);
        // context.setContextPath(CONTEXT_PATH);
        context.setClassLoader(Thread.currentThread().getContextClassLoader());
        context.setWar("src/main/webapp");

        server.setHandler(context);

        return server;
    }

}
