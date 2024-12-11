package app;

public abstract class Currency {
    protected double valor;

    public Currency(double valor) {
        this.valor = valor;
    }

    public abstract double convertToBRL();

    @Override
    public abstract String toString();
}
