package marcos2250.exemploweb.services;

import java.util.List;

import marcos2250.exemploweb.dominio.Pessoa;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoasService {

    @Autowired
    private GenericDAO dao;

    @Transactional
    public void incluir(String nome) {
        Pessoa pes = new Pessoa();

        pes.setNome(nome);
        pes.setSobrenome(nome);
        pes.setTelefone("3222-2222");
        pes.setDataNascimento(LocalDate.now());

        dao.save(pes);
    }

    @Transactional(readOnly = true)
    public List<Pessoa> listar() {
        return dao.list(Pessoa.class);
    }

}
