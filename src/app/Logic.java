package app;

import java.util.ArrayList;

public class Logic {

    public final ArrayList<Currency> currencies;

    public Logic() {
        this.currencies = new ArrayList<>();
    }

    public void addCurrency(Currency currency) {
        this.currencies.add(currency);
    }

    public boolean removeCurrency(int index) {
        this.currencies.remove(index);
        return true;
    }

    public double calculateTotalInBRL() {
        double total = 0.0;
        for (Currency currency : this.currencies) {
            total += currency.convertToBRL();
        }
        return total;
    }
}
