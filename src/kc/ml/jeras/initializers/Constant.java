package kc.ml.jeras.initializers;

public final class Constant extends Initializer<Constant> {

    private double value = 0.0;

    Constant() {
        super(Constant.class);
    }

    public Constant withValue(double value) {
        final Constant newInit = copy();
        newInit.setValue(value);
        return newInit;
    }

    private void setValue(double value) {
        this.value = value;
    }

    @Override
    public double nextWeight() {
        return value;
    }

    @Override
    public Constant copy() {
        final Constant copy = super.copy();
        copy.setValue(value);
        return copy;
    }

}
