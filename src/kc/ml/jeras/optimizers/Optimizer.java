package kc.ml.jeras.optimizers;

public abstract class Optimizer<T extends Optimizer<?>> {

    private final T self;
    private double learningRate = 0.0;

    Optimizer(Class<T> selfClass) {
        this.self = selfClass.cast(this);
    }

    public final T withLearningRate(double learningRate) {
        this.learningRate = learningRate;
        return this.self;
    }

    protected final T getSelf() {
        return this.self;
    }

}
