package marcos2250.exemploweb.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, String> {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    @Override
    public String convertToDatabaseColumn(LocalDate localDate) {
        return null == localDate ? null : localDate.format(FMT);
    }

    @Override
    public LocalDate convertToEntityAttribute(String date) {
        return null == date ? null : LocalDate.parse(date, FMT);
    }
}
