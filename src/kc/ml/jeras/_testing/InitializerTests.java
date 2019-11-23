package kc.ml.jeras._testing;

import kc.ml.jeras.architecture.Dense;
import kc.ml.jeras.architecture.Input;
import kc.ml.jeras.architecture.Sequential;

import static kc.ml.jeras.initializers.Initializers.*;

public class InitializerTests {

    public static void main(String[] args) {

        final long init = System.currentTimeMillis();

        Sequential s = new Sequential();
        s.add(new Input(5));
        s.add(new Dense(3).withWeightInitializer(LECUN_NORMAL));
        s.add(new Dense(3).withWeightInitializer(LECUN_NORMAL));
        s.add(new Dense(3).withWeightInitializer(RANDOM_NORMAL.withSeed(0)));
        s.add(new Dense(3).withWeightInitializer(RANDOM_NORMAL.withMean(2).withStdDev(10)));
        s.add(new Dense(3).withWeightInitializer(RANDOM_NORMAL.withStdDev(1)));
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
