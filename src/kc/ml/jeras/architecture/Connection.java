package kc.ml.jeras.architecture;

class Connection {

    private final Node forward;
    private double weight;

    Connection(Node forward, double weight) {
        this.forward = forward;
        this.weight = weight;
    }

    // Feeds weighted activation into forward node
    void feed(double activation) {
        final double delta = activation * weight;
        forward.feed(delta);
    }

}
