package marcos2250.exemploweb.util;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DataUtilTest {

    @Test
    public void dataToStringTest() {
        Assert.assertEquals("28/02/2018", DataUtil.toString(LocalDate.of(2018, 2, 28)));
    }

    @Test
    public void stringTodataTest() {
        Assert.assertEquals(LocalDate.of(2018, 2, 28), DataUtil.toLocalDate("28/02/2018"));
    }

}
