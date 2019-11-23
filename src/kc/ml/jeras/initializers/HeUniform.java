package kc.ml.jeras.initializers;

public final class HeUniform extends AbstractRandomUniform<HeUniform> {

    HeUniform() {
        super(HeUniform.class);
    }

    @Override
    protected double updatedLimit(int fanIn, int fanOut) {
        return Math.sqrt(6.0 / fanIn);
    }

}
