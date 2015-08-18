package marcos2250.exemploweb.services;

import java.util.List;

import marcos2250.exemploweb.dominio.Pessoa;
import marcos2250.exemploweb.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoasService {

    @Autowired
    private PessoaRepository repository;

    @Transactional
    public void incluir(Pessoa pes) {
        repository.incluir(pes);
    }

    @Transactional
    public void alterar(Pessoa pes) {
        repository.alterar(pes);
    }

    @Transactional
    public void remover(Long id) {
        Pessoa pessoa = repository.buscar(id);
        repository.remover(pessoa);
    }

    @Transactional(readOnly = true)
    public Pessoa buscar(Long id) {
        return repository.buscar(id);
    }

    @Transactional(readOnly = true)
    public List<Pessoa> listar() {
        return repository.listar();
    }

}
