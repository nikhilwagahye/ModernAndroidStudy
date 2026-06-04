package com.example.avatarapp;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<Car> object2Provider;

  public MainActivity_MembersInjector(Provider<Car> object2Provider) {
    this.object2Provider = object2Provider;
  }

  public static MembersInjector<MainActivity> create(Provider<Car> object2Provider) {
    return new MainActivity_MembersInjector(object2Provider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectObject2(instance, object2Provider.get());
  }

  @InjectedFieldSignature("com.example.avatarapp.MainActivity.object2")
  public static void injectObject2(MainActivity instance, Car object2) {
    instance.object2 = object2;
  }
}
