package marcos2250.exemploweb.dominio.enums;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class TipoEmpresaConverter extends AbstractEnumPersistenteConverter<TipoEmpresa, Integer> {

    @Override
    public Class<TipoEmpresa> getClasseEnum() {
        return TipoEmpresa.class;
    }

}
