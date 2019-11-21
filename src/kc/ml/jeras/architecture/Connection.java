package kc.ml.jeras.architecture;

class Connection {

    private final Node forward;
    private double weight;

    Connection(Node forward, double weight) {
        if (forward.isBias()) {
            throw new UnsupportedOperationException("Attempted to connect to bias unit");
        }
        this.forward = forward;
        this.weight = weight;
    }

    // Feeds weighted activation into forward node
    void feed(double activation) {
        final double delta = activation * weight;
        forward.feed(delta);
    }

}
