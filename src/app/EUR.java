package app;

import java.text.NumberFormat;
import java.util.Locale;

public class EUR extends Currency {

    public EUR(double valor) {
        super(valor);
    }

    @Override
    public double convertToBRL() {
        return this.valor * ExchangeRate.Euro;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        return nf.format(this.valor);
    }
}
