package kc.ml.jeras.initializers;

public final class GlorotNormal extends AbstractRandomNormal<GlorotNormal> {

    GlorotNormal() {
        super(GlorotNormal.class);
    }

    @Override
    protected double updatedStdDev(int fanIn, int fanOut) {
        return Math.sqrt(2.0 / (fanIn + fanOut));
    }

}
