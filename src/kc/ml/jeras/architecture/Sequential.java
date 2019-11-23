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
    
    public void add(Layer<?> forward) {
        if (forward.isInput() && !layers.isEmpty()) {
            throw new IllegalStateException("Must have exactly one input layer added first");
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

    public Compiler compile() {
        validateModel();
        configureModel();
        return compiler;
    }

    /* IMPLEMENTATION */

    private void validateModel() {
        if (layers.size() < 2) {
            throw new IllegalStateException("Insufficient layer count");
        }
    }

    private void configureModel() {
        getOutputLayer().withoutBias();
        getInputLayer().updateInitializers(0);
        connectLayers();
    }

    private void connectLayers() {
        for (int i = 0; i < layers.size()-1; i++) {
            final Layer<?> back = layers.get(i);
            final Layer<?> forward = layers.get(i+1);
            forward.updateInitializers(back.getSize());
            back.connect(forward);
        }
    }

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

        private Optimizer<?> optimizer;
        private LossFunction lossFunction;

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
