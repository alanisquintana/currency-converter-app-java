package app;

import java.text.NumberFormat;
import java.util.Locale;

public class BRL extends Currency {

    public BRL(double valor) {
        super(valor);
    }

    @Override
    public double convertToBRL() {
        return this.valor;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        return nf.format(this.valor);
    }
}
