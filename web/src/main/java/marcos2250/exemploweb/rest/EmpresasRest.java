package marcos2250.exemploweb.rest;

import java.util.List;

import marcos2250.exemploweb.dominio.Empresa;
import marcos2250.exemploweb.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EmpresasRest {

    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private EmpresaService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<Empresa> listarEmpresas() {
        return service.listar();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Empresa buscarEmpresa(@PathVariable("id") Long id) {
        return service.buscar(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void excluirEmpresa(@PathVariable("id") Long id) {
        service.remover(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = APPLICATION_JSON)
    public void incluirEmpresa(@RequestBody Empresa empresa) {
        service.incluir(empresa);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = APPLICATION_JSON)
    public @ResponseBody void atualizarEmpresa(@RequestBody Empresa empresa) {
        service.alterar(empresa);
    }

}
