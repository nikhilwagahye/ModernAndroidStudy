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
public final class GetEpisodeByIdUseCase_Factory implements Factory<GetEpisodeByIdUseCase> {
  private final Provider<EpisodeRepository> repositoryProvider;

  public GetEpisodeByIdUseCase_Factory(Provider<EpisodeRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetEpisodeByIdUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetEpisodeByIdUseCase_Factory create(
      Provider<EpisodeRepository> repositoryProvider) {
    return new GetEpisodeByIdUseCase_Factory(repositoryProvider);
  }

  public static GetEpisodeByIdUseCase newInstance(EpisodeRepository repository) {
    return new GetEpisodeByIdUseCase(repository);
  }
}
