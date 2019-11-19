package kc.ml.jeras.initializers;

import java.util.Random;

public abstract class AbstractRandom<T extends AbstractRandom<?>> extends Initializer<T> {

    protected final Random rng = new Random();

    AbstractRandom(Class<T> selfClass) {
        super(selfClass);
    }

    public final T withSeed(long seed) {
        rng.setSeed(seed);
        return this.self;
    }

}
