package marcos2250.exemploweb.util;

import java.time.LocalDate;

import marcos2250.exemploweb.dominio.Pessoa;
import marcos2250.exemploweb.services.PessoasService;

import org.springframework.beans.factory.annotation.Autowired;

public class CargaBasica {

    @Autowired
    private PessoasService pessoasService;

    public void fazerCarga() {

        if (!pessoasService.listar().isEmpty()) {
            System.out.println("Carga já efetuada!");
            return;
        }

        System.out.println("Efetuando carga basica de dados...");

        pessoasService.incluir(criaPessoaFake("Fulano"));
        pessoasService.incluir(criaPessoaFake("Sicrano"));
        pessoasService.incluir(criaPessoaFake("Beltrano"));

        System.out.println("Carga basica concluida.");
    }

    private Pessoa criaPessoaFake(String nome) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setSobrenome(nome);
        pessoa.setTelefone("3222-2222");
        pessoa.setDataNascimento(LocalDate.now());
        return pessoa;
    }

}
