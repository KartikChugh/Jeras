package kc.ml.jeras.architecture;

import java.util.ArrayList;
import java.util.List;

class Node {

    protected double summation = 0;
    private double activation = 0;
    private List<Connection> connections = new ArrayList<>();

    void feed(double delta) {
        summation += delta;
    }

    void clear() {
        summation = 0;
        activation = 0;
    }

    // Adds connection to forward node of given weight
    void connect(Node forward, double weight) {
        final Connection c = new Connection(forward, weight);
        connections.add(c);
    }

}
