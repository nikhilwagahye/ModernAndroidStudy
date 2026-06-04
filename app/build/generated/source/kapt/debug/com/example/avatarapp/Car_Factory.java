package com.example.avatarapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class Car_Factory implements Factory<Car> {
  private final Provider<Engine> engineProvider;

  public Car_Factory(Provider<Engine> engineProvider) {
    this.engineProvider = engineProvider;
  }

  @Override
  public Car get() {
    return newInstance(engineProvider.get());
  }

  public static Car_Factory create(Provider<Engine> engineProvider) {
    return new Car_Factory(engineProvider);
  }

  public static Car newInstance(Engine engine) {
    return new Car(engine);
  }
}
