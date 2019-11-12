package kc.ml.jeras.architecture;

import kc.ml.jeras.lossfunctions.LossFunction;
import kc.ml.jeras.optimizers.Optimizer;

import java.util.ArrayList;
import java.util.List;

public final class Sequential {

    private final Compiler compiler = new Compiler();
    private final List<Layer<?>> layers = new ArrayList<>();

    public Sequential() {}

    public Sequential(Layer<?>... layers) {
        for (Layer<?> layer : layers) {
            add(layer);
        }
    }

    // Connects top layer to new layer, adds new layer
    public void add(Layer<?> forward) {
        if (!layers.isEmpty()) {
            final Layer<?> back = layers.get(layers.size()-1);
            back.connect(forward);
        }
        layers.add(forward);
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
