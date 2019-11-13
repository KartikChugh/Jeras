package kc.ml.jeras.lossfunctions;
// QUESTION - inconsistent import api?
public abstract class LossFunction {

    public static final LossFunction MSE = new LossFunction() {
        @Override
        public double loss(double y_true, double y_pred) {
            return Math.pow(y_true - y_pred, 2);
        }
    };

    public static final LossFunction MAE = new LossFunction() {
        @Override
        public double loss(double y_true, double y_pred) {
            return Math.abs(y_true - y_pred);
        }
    };

    public abstract double loss(double y_true, double y_pred);

}
