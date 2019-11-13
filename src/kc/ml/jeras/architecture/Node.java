package kc.ml.jeras.architecture;

import java.util.ArrayList;
import java.util.List;

class Node {

    protected double summation = 0;
    private double activation = 0;
    private final List<Connection> connections = new ArrayList<>();

    final double getActivation() {
        return activation;
    }

    void feed(double delta) {
        summation += delta;
    }

    void clear() {
        summation = 0;
        activation = 0;
    }

    // Adds connection to forward node, of specified weight
    final void connect(Node forward, double weight) {
        final Connection c = new Connection(forward, weight);
        connections.add(c);
    }

    // Feeds activation into connections
    final void fire() {
        activate();
        for (Connection c : connections) {
            c.feed(getActivation());
        }
    }

    private void activate() {
        // TODO
        activation = summation;
    }

}
