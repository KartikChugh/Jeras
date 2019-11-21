package kc.ml.jeras.initializers;

public final class GlorotUniform extends AbstractRandomUniform<GlorotUniform> {

    public GlorotUniform() {
        super(GlorotUniform.class);
    }

    @Override
    protected double updatedLimit(int fanIn, int fanOut) {
        return Math.sqrt(6.0 / (fanIn + fanOut));
    }

}
