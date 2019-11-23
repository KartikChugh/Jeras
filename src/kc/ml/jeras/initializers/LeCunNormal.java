package kc.ml.jeras.initializers;

public final class LeCunNormal extends AbstractRandomNormal<LeCunNormal> {

    LeCunNormal() {
        super(LeCunNormal.class);
    }

    @Override
    protected double updatedStdDev(int fanIn, int fanOut) {
        return Math.sqrt(1.0 / fanIn);
    }

}
