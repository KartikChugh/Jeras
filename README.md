![logo](jeras.png)

Jeras is a high-level, fluent API for neural networks written in Java and modeled after Keras.
It is designed to support Keras objects, such as:
- Optimizers
- Activations
- Layers
- Sequential models
- and more!

### Code example

```java
  // Build model architecture
  Sequential model = new Sequential();
  model.add(new Input(2).withBiasInitializer(ONES));
  model.add(new Dense(4).withBiasInitializer(CONSTANT.withValue(16)));
  model.add(new Dense(1));

  // Set training parameters
  model.compile()
          .withOptimizer(new Gd()
                  .withNesterov()
                  .withMomentum(0.2)
                  .withLearningRate(0.1))
          .withLossFunction(MSE);

  double[] y = model.predict(new double[]{1,2});
  System.out.println(Arrays.toString(y));
```

### Current Status
Work-in-progress! Check out components [here](https://github.com/KartikChugh/Jeras/tree/master/src/kc/ml/jeras)
