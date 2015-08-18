package marcos2250.exemploweb.repository;

import marcos2250.exemploweb.dominio.Empresa;

import org.springframework.stereotype.Repository;

@Repository
public class EmpresaRepository extends AbstractDAO<Empresa> {

    @Override
    protected Class<Empresa> getClasse() {
        return Empresa.class;
    }

}
