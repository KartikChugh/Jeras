package kc.ml.jeras.initializers;

public final class RandomNormal extends AbstractRandomNormal<RandomNormal> {

    public RandomNormal() {
        super(RandomNormal.class);
    }

    @Override
    protected boolean outOfBounds(double weight) {
        return false;
    }
}
