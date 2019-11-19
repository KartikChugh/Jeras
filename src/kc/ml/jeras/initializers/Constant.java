package kc.ml.jeras.initializers;

public final class Constant extends Initializer<Constant> {

    private final double value;

    public Constant(double value) {
        super(Constant.class);
        this.value = value;
    }

    @Override
    public double nextWeight() {
        return value;
    }

}
