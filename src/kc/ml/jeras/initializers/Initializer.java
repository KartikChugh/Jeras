package kc.ml.jeras.initializers;

public abstract class Initializer<T extends Initializer<?>> {

    protected final T self;

    Initializer(Class<T> selfClass) {
        this.self = selfClass.cast(this);
    }

    public abstract double nextWeight();

    public void updateDistributionParameters(int fanIn, int fanOut) {
        // do nothing by default
    }

}
