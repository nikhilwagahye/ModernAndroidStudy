package com.example.avatarapp.domain.usecase;

import com.example.avatarapp.data.repository.EpisodeRepository;
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
public final class GetEpisodesUseCase_Factory implements Factory<GetEpisodesUseCase> {
  private final Provider<EpisodeRepository> repositoryProvider;

  public GetEpisodesUseCase_Factory(Provider<EpisodeRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetEpisodesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetEpisodesUseCase_Factory create(Provider<EpisodeRepository> repositoryProvider) {
    return new GetEpisodesUseCase_Factory(repositoryProvider);
  }

  public static GetEpisodesUseCase newInstance(EpisodeRepository repository) {
    return new GetEpisodesUseCase(repository);
  }
}
