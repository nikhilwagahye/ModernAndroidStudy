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
public final class GetEpisodesByWriterUseCase_Factory implements Factory<GetEpisodesByWriterUseCase> {
  private final Provider<EpisodeRepository> repositoryProvider;

  public GetEpisodesByWriterUseCase_Factory(Provider<EpisodeRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetEpisodesByWriterUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetEpisodesByWriterUseCase_Factory create(
      Provider<EpisodeRepository> repositoryProvider) {
    return new GetEpisodesByWriterUseCase_Factory(repositoryProvider);
  }

  public static GetEpisodesByWriterUseCase newInstance(EpisodeRepository repository) {
    return new GetEpisodesByWriterUseCase(repository);
  }
}
