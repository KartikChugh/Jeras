package kc.ml.jeras._testing;

import kc.ml.jeras.architecture.Dense;
import kc.ml.jeras.architecture.Input;
import kc.ml.jeras.architecture.Sequential;
import kc.ml.jeras.initializers.*;

import java.text.DecimalFormat;
import java.util.Random;

import static kc.ml.jeras.initializers.Initializers.*;

public class InitializerTests {

    public static void main(String[] args) {

        Sequential s = new Sequential();
        s.add(new Input(5).withWeightInitializer(RANDOM_UNIFORM.withLimit(100)));
        s.add(new Dense(5).withWeightInitializer(GLOROT_NORMAL));
        s.add(new Dense(5).withWeightInitializer(GLOROT_NORMAL));
        s.add(new Dense(1));
        s.compile();

/*        for (int i = 0; i < 10; i++) {
            double w = ru.nextWeight();
            System.out.println(w);
            if (Math.abs(w) >= Math.sqrt(3.0/2)) {
                throw new AssertionError(w);
            }
        }*/

    }

}
