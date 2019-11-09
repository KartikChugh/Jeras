package kc.ml.jeras;

import kc.ml.jeras.architecture.layers.Dense;
import kc.ml.jeras.architecture.layers.Input;
import kc.ml.jeras.architecture.Sequential;
import kc.ml.jeras.trainingparams.optimizers.Gd;

import static kc.ml.jeras.trainingparams.lossfunctions.LossFunction.MSE;


public class Main {

    public static void main(String[] args) {

        // Build model architecture
        Sequential model = new Sequential();
        model.add(new Input(2));
        model.add(new Dense(16));

        // Set training parameters
        model.compile()
                .withOptimizer(new Gd()
                        .withNesterov()
                        .withMomentum(0.2)
                        .withLearningRate(0.1))
                .withLossFunction(MSE);

    }

}
