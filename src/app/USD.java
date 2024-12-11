package app;

import java.text.NumberFormat;
import java.util.Locale;

public class USD extends Currency {

    public USD(double valor) {
        super(valor);
    }

    @Override
    public double convertToBRL() {
        return this.valor * ExchangeRate.Dolar;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        return nf.format(this.valor);
    }
}
