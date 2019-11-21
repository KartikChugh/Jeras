package kc.ml.jeras.architecture;

import kc.ml.jeras.initializers.Initializer;

import java.util.ArrayList;
import java.util.List;

import static kc.ml.jeras.initializers.Initializers.ONES;
import static kc.ml.jeras.initializers.Initializers.ZEROS;

abstract class Layer<T extends Layer<?>> {

    protected final T self;

    private Bias bias = new Bias();
    private final List<Node> nodes = new ArrayList<>();

    private Initializer<?> weightInitializer = ONES; // TODO glorot uniform
    private Initializer<?> biasInitializer = ZEROS;

    Layer(Class<T> selfClass, int units) {
        this.self = selfClass.cast(this);
        initialize(units);
    }

    private void initialize(int units) {
        for (int i = 0; i < units; i++) {
            nodes.add(new Node());
        }
        nodes.add(bias);
    }

    /* UTILITY */

    protected final Node getNode(int i) {
        return nodes.get(i);
    }

    final double[] getActivations() {
        return nodes.stream().mapToDouble(Node::getActivation).toArray();
    }

    final int getSize() {
        return (bias == null) ? nodes.size() : nodes.size() - 1;
    }

    /* API */

    public final T withoutBias() {
        if (bias != null) {
            nodes.remove(nodes.size()-1);
            bias = null;
        }
        return this.self;
    }

    // TODO validate/prevent initializer calls on output layer
    public final T withWeightInitializer(Initializer init) {
        this.weightInitializer = init;
        return this.self;
    }

    public final T withBiasInitializer(Initializer init) {
        this.biasInitializer = init;
        return this.self;
    }

    /* IMPLEMENTATION */

    // Fully connects this layer to forward layer
    final void connect(Layer<?> forward) {
        final int forward_fanIn = this.getSize();
        forward.updateInitializers(forward_fanIn);
        for (Node n1 : this.nodes) {
            for (Node n2 : forward.nodes) {
                connectNodes(n1, n2);
            }
        }
    }

    protected void updateInitializers(int fanIn) {
        final int fanOut = getSize();
        weightInitializer.updateDistributionParameters(fanIn, fanOut);
        biasInitializer.updateDistributionParameters(fanIn, fanOut);
    }

    private void connectNodes(Node n1, Node n2) {
        if (!n2.isBias()) {
            final double weight = weightFor(n1);
            n1.connect(n2, weight);
        }
    }

    // Returns weight using the appropriate initializer
    private double weightFor(Node back) {
        final Initializer init = back.isBias() ? biasInitializer : weightInitializer;
        return init.nextWeight();
    }

    // Fires nodes
    final void fire() {
        for (Node n : nodes) {
            n.fire();
        }
    }

    // Clears nodes
    final void clear() {
        for (Node n : nodes) {
            n.clear();
        }
    }

}
