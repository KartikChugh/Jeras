package kc.ml.jeras.architecture;

import kc.ml.jeras.initializers.Initializer;

import java.util.ArrayList;
import java.util.List;

public abstract class Layer<T extends Layer<?>> {

    final T self;
    private Bias bias = new Bias();
    private final List<Node> nodes = new ArrayList<>();
    private Initializer weightInitializer; // = glorot_uniform
    private Initializer biasInitializer; // = zeroes

    public Layer(Class<T> selfClass, int units) {
        this.self = selfClass.cast(this);
        for (int i = 0; i < units; i++) {
            nodes.add(new Node());
        }
        nodes.add(bias);
    }

    public final T withoutBias() {
        nodes.remove(bias);
        bias = null;
        return this.self;
    }

    public final T withWeightInitializer(Initializer init) {
        this.weightInitializer = init;
        return this.self;
    }

    public final T withBiasInitializer(Initializer init) {
        this.biasInitializer = init;
        return this.self;
    }

    // Fully connects this layer to forward layer
    void connect(Layer<?> forward) {
        for (Node n1 : this.nodes) {
            for (Node n2 : forward.nodes) {
                // Don't connect to bias
                if (! (n2 instanceof Bias)) {
                    final double weight = weightBetween(n1, n2);
                    n1.connect(n2, weight);
                }
            }
        }
    }

    // Returns weight using the appropriate initializer
    private double weightBetween(Node back, Node forward) {
        final Initializer init = (back instanceof Bias) ? biasInitializer : weightInitializer;
        return init.nextWeight();
    }

}
