package marcos2250.exemploweb.rest;

import java.util.List;

import marcos2250.exemploweb.dominio.Pessoa;
import marcos2250.exemploweb.services.PessoasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class FachadaServicos {

    private static final String APPLICATION_JSON = "application/json";
    
    @Autowired
    private PessoasService pessoasService;

    @RequestMapping(value = "/pessoas/", method = RequestMethod.GET, produces=APPLICATION_JSON)
    public List<Pessoa> listarPessoas() {
        return pessoasService.listar();
    }

    @RequestMapping(value = "/pessoas/{id}", method = RequestMethod.GET, produces=APPLICATION_JSON)
    public Pessoa buscarPessoa(@PathVariable("id") Long id) {
        return pessoasService.buscar(id);
    }

    @RequestMapping(value = "/pessoas/{id}", method = RequestMethod.DELETE)
    public void excluirPessoa(@PathVariable("id") Long id) {
        pessoasService.remover(id);
    }
    
    @RequestMapping(value = "/pessoas/", method = RequestMethod.POST, consumes=APPLICATION_JSON)
    public void incluirPessoa(Pessoa pessoa) {
        pessoasService.incluir(pessoa);
    }

    @RequestMapping(value = "/pessoas/}", method = RequestMethod.PUT, consumes=APPLICATION_JSON)
    public void atualizarPessoa(Pessoa pessoa) {
        pessoasService.alterar(pessoa);
    }

}
