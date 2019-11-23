package kc.ml.jeras._testing;

import kc.ml.jeras.architecture.Dense;
import kc.ml.jeras.architecture.Input;
import kc.ml.jeras.architecture.Sequential;

import static kc.ml.jeras.initializers.Initializers.*;

public class InitializerTests {

    public static void main(String[] args) {

        final long init = System.currentTimeMillis();

        Sequential s = new Sequential();
        s.add(new Input(2).withWeightInitializer(RANDOM_NORMAL).withBiasInitializer(ZEROS));
        s.add(new Dense(16).withWeightInitializer(GLOROT_UNIFORM));
        s.add(new Dense(16).withWeightInitializer(GLOROT_UNIFORM));
        s.add(new Dense(8).withWeightInitializer(RANDOM_NORMAL.withStdDev(0.001)));
        s.add(new Dense(2).withWeightInitializer(CONSTANT.withValue(0.5)));
        s.add(new Dense(1));
        s.compile();

        System.out.println(System.currentTimeMillis() - init);

/*        for (int i = 0; i < 10; i++) {
            double w = ru.nextWeight();
            System.out.println(w);
            if (Math.abs(w) >= Math.sqrt(3.0/2)) {
                throw new AssertionError(w);
            }
        }*/

    }

}
