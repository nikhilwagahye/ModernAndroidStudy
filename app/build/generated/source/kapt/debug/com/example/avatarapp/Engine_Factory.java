package com.example.avatarapp;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class Engine_Factory implements Factory<Engine> {
  @Override
  public Engine get() {
    return newInstance();
  }

  public static Engine_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Engine newInstance() {
    return new Engine();
  }

  private static final class InstanceHolder {
    private static final Engine_Factory INSTANCE = new Engine_Factory();
  }
}
