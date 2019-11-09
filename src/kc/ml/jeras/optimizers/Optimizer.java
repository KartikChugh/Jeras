package kc.ml.jeras.optimizers;

public abstract class Optimizer<O extends Optimizer<?>> {

    final O self;
    private double learningRate = 0.0;

    Optimizer(Class<O> selfClass) {
        this.self = selfClass.cast(this);
    }

    public final O withLearningRate(double learningRate) {
        this.learningRate = learningRate;
        return this.self;
    }

}
