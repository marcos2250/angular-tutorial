package marcos2250.exemploweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import marcos2250.exemploweb.services.PessoasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component
public class PessoasServlet implements HttpRequestHandler {

    @Autowired
    private PessoasService pessoasService;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        PrintWriter writer = response.getWriter();
        writer.append("Esta e uma servlet para teste! ");
        writer.append("Total de cadastros: " + pessoasService.listar().size());

    }

}
