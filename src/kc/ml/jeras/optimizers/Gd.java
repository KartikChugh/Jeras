package kc.ml.jeras.optimizers;

public class Gd extends Optimizer<Gd> {

    private double momentum = 0.0;
    private boolean nesterov = false;

    public Gd() {
        super(Gd.class);
        withLearningRate(0.01);
    }

    public Gd withMomentum(double momentum) {
        this.momentum = momentum;
        return this.self;
    }

    public Gd withNesterov() {
        this.nesterov = true;
        return this.self;
    }

}
