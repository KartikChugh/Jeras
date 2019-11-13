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

    /* UTILITY */

    private Input getInputLayer() {
        return (Input) layers.get(0);
    }

    private void setInputs(double[] inputs) {
        getInputLayer().feedInputs(inputs);
    }

    private Layer<?> getOutputLayer() {
        return layers.get(layers.size()-1);
    }

    private double[] getOutputs() {
        return getOutputLayer().getActivations();
    }

    /* API */

    // Connects top layer to new layer, adds new layer
    // TODO validate input layer is first
    public void add(Layer<?> forward) {
        if (!layers.isEmpty()) {
            final Layer<?> back = getOutputLayer();
            back.connect(forward);
        }
        layers.add(forward);
    }

    public double fit(double[][] x, double[][] y, int batchSize, int epochs) {
        // TODO
        return 0;
    }

    public double evaluate(double[][] x, double[][] y) {
        // TODO
        return 0;
    }

    public double[] predict(double[] x) {
        validateInputSize(x);
        setInputs(x);
        feedforward();
        final double[] y = getOutputs();
        clear();
        return y;
    }

    // QUESTION - does compile have to be called? if validates model..
    public Compiler compile() {
        getOutputLayer().withoutBias();
        return compiler;
    }

    /* IMPLEMENTATION */

    private void validateInputSize(double[] x) {
        if (x.length != getInputLayer().getSize()) {
            throw new IllegalArgumentException("Invalid input size");
        }
    }
    // Fires nodes of each layer
    private void feedforward() {
        for (Layer<?> layer : layers) {
            layer.fire();
        }
    }

    // Clears nodes of each layer
    private void clear() {
        for (Layer<?> layer : layers) {
            layer.clear();
        }
    }

    public final class Compiler {

        private Optimizer<?> optimizer; // TODO sgd
        private LossFunction lossFunction; // TODO mse

        public Compiler withOptimizer(Optimizer<?> optimizer) {
            this.optimizer = optimizer;
            return this;
        }

        public Compiler withLossFunction(LossFunction lossFunction) {
            this.lossFunction = lossFunction;
            return this;
        }

    }

}
