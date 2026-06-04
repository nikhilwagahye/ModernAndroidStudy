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
public final class GetFormattedEpisodesUseCase_Factory implements Factory<GetFormattedEpisodesUseCase> {
  private final Provider<EpisodeRepository> repositoryProvider;

  private final Provider<EpisodeTitleFormatter> formatterProvider;

  public GetFormattedEpisodesUseCase_Factory(Provider<EpisodeRepository> repositoryProvider,
      Provider<EpisodeTitleFormatter> formatterProvider) {
    this.repositoryProvider = repositoryProvider;
    this.formatterProvider = formatterProvider;
  }

  @Override
  public GetFormattedEpisodesUseCase get() {
    return newInstance(repositoryProvider.get(), formatterProvider.get());
  }

  public static GetFormattedEpisodesUseCase_Factory create(
      Provider<EpisodeRepository> repositoryProvider,
      Provider<EpisodeTitleFormatter> formatterProvider) {
    return new GetFormattedEpisodesUseCase_Factory(repositoryProvider, formatterProvider);
  }

  public static GetFormattedEpisodesUseCase newInstance(EpisodeRepository repository,
      EpisodeTitleFormatter formatter) {
    return new GetFormattedEpisodesUseCase(repository, formatter);
  }
}
