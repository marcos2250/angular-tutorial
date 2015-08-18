package marcos2250.exemploweb.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //LocalDateTime "dd/MM/yyyy HH:mm"

    public static String toString(LocalDate dataHora) {
        if (dataHora == null) {
            return "";
        }
        return FORMATTER.format(dataHora);
    }

    public static LocalDate toLocalDate(String data) {
        if (data == null || data == "") {
            return null;
        }
        return LocalDate.parse(data, FORMATTER);
    }

}
