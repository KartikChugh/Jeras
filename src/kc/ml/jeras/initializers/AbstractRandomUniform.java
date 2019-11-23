package kc.ml.jeras.initializers;

public abstract class AbstractRandomUniform<T extends AbstractRandomUniform<?>> extends AbstractRandom<T> {

    private double limit = 0.05;

    AbstractRandomUniform(Class<T> selfClass) {
        super(selfClass);
    }

    public final T withLimit(double limit) {
        final T newInit = copy();
        newInit.setLimit(limit);
        return newInit;
    }

    protected final void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public final double nextWeight() {
        return rng.nextDouble() * (2*limit) - limit;
    }

    @Override
    public final void updateDistributionParameters(int fanIn, int fanOut) {
        setLimit(updatedLimit(fanIn, fanOut));
    }

    protected double updatedLimit(int fanIn, int fanOut) {
        return limit;
    }

    @Override
    public T copy() {
        final T copy = super.copy();
        copy.setLimit(limit);
        return copy;
    }

}
