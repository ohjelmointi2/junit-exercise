package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import price.formatter.PriceFormatter;

public class PriceFormatterTest {

    private PriceFormatter pf = new PriceFormatter();

    @Test
    void formatterLimitsDecimalPlacesToTwo() {
        String formatted = pf.formatPrice(Math.PI);

        assertEquals("3,14 €", formatted);
    }

    @Test
    void formatterUsesSpaceAsThousandSeparator() {
        String formatted = pf.formatPrice(123456.78);

        assertEquals("123 456,78 €", formatted);
    }

    @Test
    void formatterOmitsDecimalPartIfZero() {
        String formatted = pf.formatPrice(123456);

        assertEquals("123 456 €", formatted);
    }

    @Test
    void formatterExtendsDecimalPartIfNecessary() {
        String formatted = pf.formatPrice(6.7);

        assertEquals("6,70 €", formatted);
    }

    @Test
    void formatterRoundsDecimalPartCorrectly() {
        String formatted = pf.formatPrice(4.567);

        assertEquals("4,57 €", formatted);
    }
}
