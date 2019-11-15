package kc.ml.jeras;

import kc.ml.jeras.architecture.Dense;
import kc.ml.jeras.architecture.Input;
import kc.ml.jeras.architecture.Sequential;
import kc.ml.jeras.initializers.Constant;
import kc.ml.jeras.optimizers.Gd;

import java.util.Arrays;

import static kc.ml.jeras.initializers.Initializers.ONES;
import static kc.ml.jeras.lossfunctions.LossFunction.MSE;


public class Main {

    public static void main(String[] args) {

        // Build model architecture
        Sequential model = new Sequential();
        model.add(new Input(2).withBiasInitializer(ONES));
        model.add(new Dense(4).withBiasInitializer(new Constant(16)));
        model.add(new Dense(1));

        // Set training parameters
        model.compile()
                .withOptimizer(new Gd()
                        .withNesterov()
                        .withMomentum(0.2)
                        .withLearningRate(0.1))
                .withLossFunction(MSE);

        double[] y = model.predict(new double[]{1,2});
        System.out.println(Arrays.toString(y));
    }

}
