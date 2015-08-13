package marcos2250.exemploweb.services;

import java.util.List;

import marcos2250.exemploweb.dominio.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoasService {

    @Autowired
    private GenericDAO dao;

    @Transactional
    public void incluir(Pessoa pes) {
        dao.save(pes);    
    }
    
    @Transactional
    public void alterar(Pessoa pes) {
        dao.update(pes);
    }
    
    @Transactional
    public void remover(Long id) {
        Pessoa pessoa = dao.get(Pessoa.class, id);
        dao.delete(pessoa);
    }

    @Transactional(readOnly = true)
    public Pessoa buscar(Long id) {
        return dao.get(Pessoa.class, id);
    }

    @Transactional(readOnly = true)
    public List<Pessoa> listar() {
        return dao.list(Pessoa.class);
    }

}
