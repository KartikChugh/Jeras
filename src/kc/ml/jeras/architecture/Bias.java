package kc.ml.jeras.architecture;

class Bias extends Node {

    Bias() {
        super(1);
    }

    @Override
    protected final void feed(double delta) {
        throw new UnsupportedOperationException("Attempted to feed bias unit");
    }

    @Override
    protected final void clear() {
        // do nothing
    }

    @Override
    protected final boolean isBias() {
        return true;
    }
}
