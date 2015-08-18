package marcos2250.exemploweb.dominio.enums;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class EnumSexoConverter extends AbstractEnumPersistenteConverter<Sexo, String> {

    @Override
    public Class<Sexo> getClasseEnum() {
        return Sexo.class;
    }

}
