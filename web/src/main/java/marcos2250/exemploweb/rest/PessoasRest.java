package marcos2250.exemploweb.rest;

import java.util.List;

import marcos2250.exemploweb.dominio.Pessoa;
import marcos2250.exemploweb.services.PessoasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoasRest {

    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private PessoasService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<Pessoa> listarPessoas() {
        return service.listar();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Pessoa buscarPessoa(@PathVariable("id") Long id) {
        return service.buscar(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void excluirPessoa(@PathVariable("id") Long id) {
        service.remover(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = APPLICATION_JSON)
    public void incluirPessoa(@RequestBody Pessoa pessoa) {
        service.incluir(pessoa);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = APPLICATION_JSON)
    public @ResponseBody void atualizarPessoa(@RequestBody Pessoa pessoa) {
        service.alterar(pessoa);
    }

}
