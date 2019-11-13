package kc.ml.jeras.architecture;

public final class Dense extends Layer<Dense> {

    public Dense(int units) {
        super(Dense.class, units);
    }

    public Dense withActivationFunction() {
        // TODO
        return super.getSelf();
    }

}
