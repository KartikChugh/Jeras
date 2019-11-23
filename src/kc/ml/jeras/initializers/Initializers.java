package kc.ml.jeras.initializers;

public final class Initializers {

    public static final Constant CONSTANT = new Constant();
    public static final Constant ZEROS = CONSTANT.withValue(0);
    public static final Constant ONES = CONSTANT.withValue(1);

    public static final RandomUniform RANDOM_UNIFORM = new RandomUniform();
    public static final LeCunUniform LECUN_UNIFORM = new LeCunUniform();
    public static final GlorotUniform GLOROT_UNIFORM = new GlorotUniform();
    public static final HeUniform HE_UNIFORM = new HeUniform();

    public static final RandomNormal RANDOM_NORMAL = new RandomNormal();
    public static final TruncatedNormal TRUNCATED_NORMAL = new TruncatedNormal();
    public static final LeCunNormal LECUN_NORMAL = new LeCunNormal();
    public static final GlorotNormal GLOROT_NORMAL = new GlorotNormal();
    public static final HeNormal HE_NORMAL = new HeNormal();

}
