package marcos2250.exemploweb.repository;

import java.util.List;

import marcos2250.exemploweb.dominio.Pessoa;

import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepository extends AbstractDAO<Pessoa> {

    @Override
    protected Class<Pessoa> getClasse() {
        return Pessoa.class;
    }

    public void incluir(Pessoa pes) {
        save(pes);
    }

    public void alterar(Pessoa pes) {
        update(pes);
    }

    public Pessoa buscar(Long id) {        
        return get(id);
    }

    public List<Pessoa> listar() {
        return list();
    }

    public void remover(Pessoa pessoa) {
        delete(pessoa);
    }

}
