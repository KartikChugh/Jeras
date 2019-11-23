package kc.ml.jeras.initializers;

public final class LeCunUniform extends AbstractRandomUniform<LeCunUniform> {

    LeCunUniform() {
        super(LeCunUniform.class);
    }

    @Override
    protected double updatedLimit(int fanIn, int fanOut) {
        return Math.sqrt(3.0 / fanIn);
    }

}
