package ohjelmointi2.unittests;

import java.text.NumberFormat;
import java.util.Locale;

public class PriceFormatter {

    /**
     * Format the price to a string with the following format: 123 456,78 €.
     *
     * A space is used as thousand separator and a comma as decimal separator.
     * The decimal part must be rounded to two digits, unless the decimal part is 0,
     * in which case it is omitted. The currency symbol € is added at the end of the
     * string.
     *
     * @param price the price to format, as a double
     * @return the formatted price as a string
     */
    public String formatPrice(double price) {
        String bug = System.getenv().getOrDefault("BUG", "");

        switch (bug) {
            case "tooManyDecimalPlaces":
                return tooManyDecimalPlaces(price);
            case "dotUsedAsThousandSeparator":
                return dotUsedAsThousandSeparator(price);
            case "zeroNotOmittedInDecimals":
                return zeroNotOmittedInDecimals(price);
            case "decimalPartTooShort":
                return decimalPartTooShort(price);
            case "decimalPartRoundedIncorrectly":
                return decimalPartRoundedIncorrectly(price);
        }

        return correct(price);
    }

    private String correct(double price) {
        // https://stackoverflow.com/a/5054217
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.GERMAN);

        // The decimal part must be rounded to two digits, unless the decimal part is 0,
        // in which case it is omitted.
        var digits = (price % 1 != 0) ? 2 : 0;
        formatter.setMinimumFractionDigits(digits);
        formatter.setMaximumFractionDigits(digits);

        return formatter.format(price).replace(".", " ") + " €";
    }

    private String tooManyDecimalPlaces(double price) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.GERMAN);
        return formatter.format(price).replace(".", " ") + " €";
    }

    private String dotUsedAsThousandSeparator(double price) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.GERMAN);

        var digits = (price % 1 != 0) ? 2 : 0;
        formatter.setMinimumFractionDigits(digits);
        formatter.setMaximumFractionDigits(digits);

        return formatter.format(price) + " €";

    }

    private String zeroNotOmittedInDecimals(double price) {
        // https://stackoverflow.com/a/5054217
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.GERMAN);

        // The decimal part must be rounded to two digits, unless the decimal part is 0,
        // in which case it is omitted.
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        return formatter.format(price).replace(".", " ") + " €";
    }

    private String decimalPartTooShort(double price) {
        // https://stackoverflow.com/a/5054217
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.GERMAN);

        // The decimal part must be rounded to two digits, unless the decimal part is 0,
        // in which case it is omitted.
        var digits = (price % 1 != 0) ? 2 : 0;
        formatter.setMaximumFractionDigits(digits);

        return formatter.format(price).replace(".", " ") + " €";
    }

    private String decimalPartRoundedIncorrectly(double price) {
        // https://stackoverflow.com/a/5054217
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.GERMAN);

        var digits = (price % 1 != 0) ? 2 : 0;
        formatter.setMinimumFractionDigits(digits);
        formatter.setMaximumFractionDigits(digits);

        // unwanted rounding
        formatter.setRoundingMode(java.math.RoundingMode.DOWN);

        return formatter.format(price).replace(".", " ") + " €";
    }
}
