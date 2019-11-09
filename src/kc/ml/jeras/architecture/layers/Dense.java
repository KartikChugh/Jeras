package kc.ml.jeras.architecture.layers;

import kc.ml.jeras.activationfunctions.ActivationFunction;

public class Dense extends Layer {

    public Dense(int units) {
        super(units);
    }

    public Dense withActivationFunction() {
        // TODO
        return this;
    }

    public Dense withWeightInitializer() {
        // TODO
        return this;
    }

    public Dense withBiasInitializer() {
        // TODO
        return this;
    }

}
