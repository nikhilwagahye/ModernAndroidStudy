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
public final class UseHere_Factory implements Factory<UseHere> {
  private final Provider<ClassName> classNameProvider;

  public UseHere_Factory(Provider<ClassName> classNameProvider) {
    this.classNameProvider = classNameProvider;
  }

  @Override
  public UseHere get() {
    return newInstance(classNameProvider.get());
  }

  public static UseHere_Factory create(Provider<ClassName> classNameProvider) {
    return new UseHere_Factory(classNameProvider);
  }

  public static UseHere newInstance(ClassName className) {
    return new UseHere(className);
  }
}
