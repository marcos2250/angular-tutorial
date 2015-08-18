package marcos2250.exemploweb.dominio.enums;

import javax.persistence.AttributeConverter;

public abstract class AbstractEnumPersistenteConverter<E extends EnumPersistente<T>, T> //
        implements AttributeConverter<E, T> {

    public abstract Class<E> getClasseEnum();

    @Override
    public T convertToDatabaseColumn(E attribute) {
        return (T) attribute.getCodigo();
    }

    @Override
    public E convertToEntityAttribute(T dbData) {
        for (E enumConstant : getClasseEnum().getEnumConstants()) {
            if (enumConstant.getCodigo().equals(dbData)) {
                return enumConstant;
            }
        }
        throw new IllegalArgumentException("Enum value not found: " + dbData);
    }

}
