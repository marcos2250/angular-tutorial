package marcos2250.exemploweb.util;

import java.time.LocalDate;
import java.util.Arrays;

import marcos2250.exemploweb.dominio.Empresa;
import marcos2250.exemploweb.dominio.Pessoa;
import marcos2250.exemploweb.dominio.enums.Sexo;
import marcos2250.exemploweb.dominio.enums.TipoEmpresa;
import marcos2250.exemploweb.services.EmpresaService;
import marcos2250.exemploweb.services.PessoasService;

import org.springframework.beans.factory.annotation.Autowired;

public class CargaBasica {

    @Autowired
    private PessoasService pessoasService;
    
    @Autowired
    private EmpresaService empresasService;

    public void fazerCarga() {

        if (!pessoasService.listar().isEmpty()) {
            System.out.println("Carga já efetuada!");
            return;
        }

        System.out.println("Efetuando carga basica de dados...");

        Pessoa fulano = criaPessoaFake("Fulano", Sexo.MASCULINO);
        pessoasService.incluir(fulano);

        Pessoa sicrano = criaPessoaFake("Sicrano", Sexo.MASCULINO);
        pessoasService.incluir(sicrano);

        Pessoa beltrana = criaPessoaFake("Beltrana", Sexo.FEMININO);        
        pessoasService.incluir(beltrana);

        Empresa tabajara = criaEmpresaFake("Organizações Tabajara", TipoEmpresa.MEDIA);
        tabajara.setEmpregados(Arrays.asList(fulano, sicrano));
        empresasService.incluir(tabajara);
        
        Empresa acme = criaEmpresaFake("Acme Corporation", TipoEmpresa.GRANDE);
        acme.setEmpregados(Arrays.asList(fulano, beltrana));
        empresasService.incluir(acme);
        
        System.out.println("Carga basica concluida.");
    }

    private Empresa criaEmpresaFake(String nome, TipoEmpresa tipo) {
        Empresa empresa = new Empresa();
        empresa.setNome(nome);
        empresa.setTipo(tipo);
        empresa.setDataFundacao(LocalDate.now());
        return empresa;
    }

    private Pessoa criaPessoaFake(String nome, Sexo sexo) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setSobrenome(nome);
        int telefone = (int) ((Math.random() * 9000) + 1000);
        pessoa.setTelefone("3234-" + telefone);
        pessoa.setDataNascimento(LocalDate.now());
        pessoa.setSexo(sexo);
        pessoa.setEmail(nome + "@provider.com");
        return pessoa;
    }

}
