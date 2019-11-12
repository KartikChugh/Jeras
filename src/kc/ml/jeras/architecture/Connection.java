package kc.ml.jeras.architecture;

class Connection {

    private Node forward;
    private double weight;

    Connection(Node forward, double weight) {
        this.forward = forward;
        this.weight = weight;
    }

    // Fires
    void fire(double activation) {
        final double delta = activation * weight;
        forward.feed(delta);
    }

}
