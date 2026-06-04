package com.example.avatarapp.domain.usecase;

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
public final class EpisodeTitleFormatter_Factory implements Factory<EpisodeTitleFormatter> {
  @Override
  public EpisodeTitleFormatter get() {
    return newInstance();
  }

  public static EpisodeTitleFormatter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static EpisodeTitleFormatter newInstance() {
    return new EpisodeTitleFormatter();
  }

  private static final class InstanceHolder {
    private static final EpisodeTitleFormatter_Factory INSTANCE = new EpisodeTitleFormatter_Factory();
  }
}
