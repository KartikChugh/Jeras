package kc.ml.jeras.architecture;

public final class Input extends Layer<Input> {

    public Input(int units) {
        super(Input.class, units);
    }

    void feedInputs(double[] inputs) {
        // iterate over inputs, not nodes, to avoid feeding bias
        for (int i = 0; i < inputs.length; i++) {
            final double input = inputs[i];
            final Node n = getNode(i);
            n.feed(input);
        }
    }

}
