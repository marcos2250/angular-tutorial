package marcos2250.exemploweb.util;

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
        
        pessoasService.incluir("Fulano");
        pessoasService.incluir("Sicrano");
        pessoasService.incluir("Beltrano");
        
        System.out.println("Carga basica concluida.");
    }

}
