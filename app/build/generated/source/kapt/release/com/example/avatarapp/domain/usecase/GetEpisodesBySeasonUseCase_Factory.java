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
public final class GetEpisodesBySeasonUseCase_Factory implements Factory<GetEpisodesBySeasonUseCase> {
  private final Provider<EpisodeRepository> repositoryProvider;

  public GetEpisodesBySeasonUseCase_Factory(Provider<EpisodeRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetEpisodesBySeasonUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetEpisodesBySeasonUseCase_Factory create(
      Provider<EpisodeRepository> repositoryProvider) {
    return new GetEpisodesBySeasonUseCase_Factory(repositoryProvider);
  }

  public static GetEpisodesBySeasonUseCase newInstance(EpisodeRepository repository) {
    return new GetEpisodesBySeasonUseCase(repository);
  }
}
