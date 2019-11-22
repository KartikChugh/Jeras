package kc.ml.jeras.initializers;

public abstract class AbstractRandomUniform<T extends AbstractRandomUniform<?>> extends AbstractRandom<T> {

    private double limit = 0.05;

    AbstractRandomUniform(Class<T> selfClass) {
        super(selfClass);
    }

    public final T withLimit(double limit) {
        this.limit = limit;
        return this.self;
    }

    @Override
    public final double nextWeight() {
        return rng.nextDouble() * (2*limit) - limit;
    }

    @Override
    public final void updateDistributionParameters(int fanIn, int fanOut) {
        withLimit(updatedLimit(fanIn, fanOut));
    }

    protected double updatedLimit(int fanIn, int fanOut) {
        return limit;
    }

    @Override
    public T copy() {
        final T copy = super.copy();
        copy.withLimit(limit);
        return copy;
    }

}
