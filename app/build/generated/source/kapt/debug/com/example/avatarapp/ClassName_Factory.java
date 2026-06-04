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
public final class ClassName_Factory implements Factory<ClassName> {
  @Override
  public ClassName get() {
    return newInstance();
  }

  public static ClassName_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ClassName newInstance() {
    return new ClassName();
  }

  private static final class InstanceHolder {
    private static final ClassName_Factory INSTANCE = new ClassName_Factory();
  }
}
