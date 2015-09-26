package marcos2250.exemploweb.dominio.enums;

import java.io.Serializable;

import javax.persistence.AttributeConverter;

public abstract class AbstractEnumPersistenteConverter<E extends EnumPersistente<T>, T extends Serializable> //
        implements AttributeConverter<E, T> {

    public abstract Class<E> getClasseEnum();

    @Override
    public final T convertToDatabaseColumn(E valor) {
        if (valor == null) {
            return null;
        }
        return (T) (valor.getCodigo());
    }

    @Override
    public final E convertToEntityAttribute(T value) {
        if (value == null || "".equals(value)) {
            return null;
        }
        for (EnumPersistente<?> enumPersistente : getClasseEnum().getEnumConstants()) {
            if (enumPersistente.getCodigo().equals(value)) {
                return getClasseEnum().cast(enumPersistente);
            }
        }
        throw new IllegalArgumentException("Valor da Enum nao definido: " + value);
    }

}
