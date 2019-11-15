package kc.ml.jeras.architecture;

class Bias extends Node {

    Bias() {
        super(1);
    }

    @Override
    void feed(double delta) {
        throw new UnsupportedOperationException("Attempted to feed bias unit");
    }

    @Override
    void clear() {
        // do nothing
    }

}
