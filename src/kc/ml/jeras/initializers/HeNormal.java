package kc.ml.jeras.initializers;

public final class HeNormal extends AbstractRandomNormal<HeNormal> {

    HeNormal() {
        super(HeNormal.class);
    }

    @Override
    protected double updatedStdDev(int fanIn, int fanOut) {
        return Math.sqrt(2.0 / fanIn);
    }

}
