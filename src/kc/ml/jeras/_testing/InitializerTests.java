package kc.ml.jeras._testing;

import kc.ml.jeras.architecture.Dense;
import kc.ml.jeras.architecture.Input;
import kc.ml.jeras.architecture.Sequential;
import kc.ml.jeras.initializers.Constant;
import kc.ml.jeras.initializers.Initializer;
import kc.ml.jeras.initializers.LeCunUniform;
import kc.ml.jeras.initializers.RandomUniform;

import java.text.DecimalFormat;
import java.util.Random;

import static kc.ml.jeras.initializers.Initializers.*;

public class InitializerTests {

    public static void main(String[] args) {

        Sequential s = new Sequential();
        s.add(new Input(2).withWeightInitializer(RANDOM_UNIFORM));
        s.add(new Dense(5).withWeightInitializer(LECUN_UNIFORM));
        s.add(new Dense(1));

        s.compile();
        //long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            double w = LECUN_UNIFORM.nextWeight();
            //System.out.println(w);
            if (Math.abs(w) >= Math.sqrt(3.0/2)) {
                throw new AssertionError(w);
            }
        }
        //System.out.println(System.currentTimeMillis() - time);

    }

}
