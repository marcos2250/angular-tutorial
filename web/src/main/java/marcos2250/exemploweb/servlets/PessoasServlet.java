package marcos2250.exemploweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import marcos2250.exemploweb.dominio.Pessoa;
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

        List<Pessoa> pessoas = pessoasService.listar();

        PrintWriter writer = response.getWriter();

        writer.append("{\"pessoas\" : [\n");
        
        for (Iterator<Pessoa> iterator = pessoas.iterator(); iterator.hasNext();) {
            Pessoa pessoa = (Pessoa) iterator.next();

            writer.append("{");
            writer.append("\"id\":" + "\"" + pessoa.getId() + "\", ");
            writer.append("\"nome\":" + "\"" + pessoa.getNome() + "\", ");
            writer.append("\"sobrenome\":" + "\"" + pessoa.getSobrenome() + "\", ");
            writer.append("\"telefone\":" + "\"" + pessoa.getTelefone() + "\"");
            writer.append("}");

            if (iterator.hasNext()) {
                writer.append(",\n");
            }
        }

        writer.append("\n]\n}");
    }

}
