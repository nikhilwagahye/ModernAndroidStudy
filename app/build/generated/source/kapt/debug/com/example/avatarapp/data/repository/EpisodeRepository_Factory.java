package com.example.avatarapp.data.repository;

import com.example.avatarapp.data.api.ApiService;
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
public final class EpisodeRepository_Factory implements Factory<EpisodeRepository> {
  private final Provider<ApiService> apiServiceProvider;

  public EpisodeRepository_Factory(Provider<ApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public EpisodeRepository get() {
    return newInstance(apiServiceProvider.get());
  }

  public static EpisodeRepository_Factory create(Provider<ApiService> apiServiceProvider) {
    return new EpisodeRepository_Factory(apiServiceProvider);
  }

  public static EpisodeRepository newInstance(ApiService apiService) {
    return new EpisodeRepository(apiService);
  }
}
