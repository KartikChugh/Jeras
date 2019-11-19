package kc.ml.jeras._testing;

import kc.ml.jeras.architecture.Dense;
import kc.ml.jeras.architecture.Input;
import kc.ml.jeras.architecture.Sequential;

public class ValidModelTests {

    public static void main(String[] args) {

        Sequential model = new Sequential();
        model.add(new Input(2));
        model.add(new Dense(2));
        model.compile();


    }

}
