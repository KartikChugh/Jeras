package kc.ml.jeras.architecture;

import kc.ml.jeras.lossfunctions.LossFunction;
import kc.ml.jeras.optimizers.Optimizer;

public final class Sequential {

    private final Compiler compiler = new Compiler();

    public Sequential() {}

    public Sequential(Layer... layers) {
        // TODO
    }

    public void add(Layer layer) {
        // TODO
    }

    public Compiler compile() {
        return compiler;
    }

    public double fit(double[][] x, double[][] y, int batchSize, int epochs) {
        // TODO
        return 0;
    }

    public double evaluate(double[][] x, double[][] y) {
        // TODO
        return 0;
    }

    public double predict(double[][] x) {
        // TODO
        return 0;
    }

    public final class Compiler {

        private Optimizer optimizer;
        private LossFunction lossFunction;

        public Compiler withOptimizer(Optimizer optimizer) {
            this.optimizer = optimizer;
            return this;
        }

        public Compiler withLossFunction(LossFunction lossFunction) {
            this.lossFunction = lossFunction;
            return this;
        }

    }

}
