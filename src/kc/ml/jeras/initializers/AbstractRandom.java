package kc.ml.jeras.initializers;

import java.util.Random;

public abstract class AbstractRandom<T extends AbstractRandom<?>> extends Initializer<T> {

    private long seed;
    protected final Random rng;
    private boolean customSeed = false;

    AbstractRandom(Class<T> selfClass) {
        super(selfClass);
        this.seed = System.nanoTime();
        this.rng = new Random(seed);
    }

    public final T withSeed(long seed) {
        final T copy = copy();
        copy.setSeed(seed);
        return copy;
    }

    protected final void setSeed(long seed) {
        this.seed = seed;
        rng.setSeed(seed);
        customSeed = true;
    }

    @Override
    public T copy() {
        final T copy = super.copy();
        if (customSeed) {
            copy.setSeed(seed);
        }
        return copy;
    }

}
