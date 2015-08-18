package marcos2250.exemploweb.services;

import java.util.List;

import marcos2250.exemploweb.dominio.Empresa;
import marcos2250.exemploweb.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Transactional
    public void incluir(Empresa empresa) {
        repository.save(empresa);
    }

    @Transactional
    public void alterar(Empresa empresa) {
        repository.update(empresa);
    }

    @Transactional
    public void remover(Long id) {
        Empresa empresa = repository.get(id);
        repository.delete(empresa);
    }

    @Transactional(readOnly = true)
    public Empresa buscar(Long id) {
        return repository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Empresa> listar() {
        return repository.list();
    }

}
