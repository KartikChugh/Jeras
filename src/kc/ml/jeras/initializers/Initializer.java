package kc.ml.jeras.initializers;

public abstract class Initializer<T extends Initializer<?>> {

    protected final T self;
    private final Class<T> selfClass;

    Initializer(Class<T> selfClass) {
        this.selfClass = selfClass;
        this.self = selfClass.cast(this);
    }

    public abstract double nextWeight();

    public void updateDistributionParameters(int fanIn, int fanOut) {
        // do nothing by default
    }

    public T copy() {
        T copy = null;
        try {
            copy = selfClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            // QUESTION - guarantees NPE?
        }
        return copy;
    }

}
