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
public final class FilterEpisodesUseCase_Factory implements Factory<FilterEpisodesUseCase> {
  @Override
  public FilterEpisodesUseCase get() {
    return newInstance();
  }

  public static FilterEpisodesUseCase_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FilterEpisodesUseCase newInstance() {
    return new FilterEpisodesUseCase();
  }

  private static final class InstanceHolder {
    private static final FilterEpisodesUseCase_Factory INSTANCE = new FilterEpisodesUseCase_Factory();
  }
}
