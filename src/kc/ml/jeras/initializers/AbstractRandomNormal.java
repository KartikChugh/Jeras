package kc.ml.jeras.initializers;

public abstract class AbstractRandomNormal<T extends AbstractRandomNormal<?>> extends AbstractRandom<T> {

    private double mean = 0.0;
    private double stdDev = 0.05;
    private static final double TRUNCATION_BOUND = 2.0;

    AbstractRandomNormal(Class<T> selfClass) {
        super(selfClass);
    }

    public final T withMean(double mean) {
        final T newInit = copy();
        newInit.setMean(mean);
        return newInit;
    }

    public final T withStdDev(double stdDev) {
        final T newInit = copy();
        newInit.setStdDev(stdDev);
        return newInit;
    }

    protected final void setMean(double mean) {
        this.mean = mean;
    }

    protected final void setStdDev(double stdDev) {
        this.stdDev = stdDev;
    }

    @Override
    public final double nextWeight() {
        final double weight = rng.nextGaussian() * stdDev + mean;
        return outOfBounds(weight) ? nextWeight() : weight;
    }

    @Override
    public final void updateDistributionParameters(int fanIn, int fanOut) {
        setStdDev(updatedStdDev(fanIn, fanOut));
    }

    protected double updatedStdDev(int fanIn, int fanOut) {
        return stdDev;
    }

    protected boolean outOfBounds(double weight) {
        final double zScore = (weight - mean) / stdDev;
        final double deviations = Math.abs(zScore);
        return deviations > TRUNCATION_BOUND;
    }

    @Override
    public T copy() {
        final T copy = super.copy();
        copy.setMean(mean);
        copy.setStdDev(stdDev);
        return copy;
    }
}
