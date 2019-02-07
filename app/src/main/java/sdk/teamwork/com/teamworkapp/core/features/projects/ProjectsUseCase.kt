package sdk.teamwork.com.teamworkapp.core.features.projects

import com.dempsey.teamwork.data.model.Projects
import sdk.teamwork.com.teamworkapp.core.exception.Failure
import sdk.teamwork.com.teamworkapp.core.functional.Either
import sdk.teamwork.com.teamworkapp.core.interactor.UseCase
import sdk.teamwork.com.teamworkapp.core.repositories.ProjectsRepository
import javax.inject.Inject

class ProjectsUseCase @Inject constructor(
    private val projectsRepository: ProjectsRepository
) : UseCase<Projects, Unit>() {

    override suspend fun run(params: Unit): Either<Failure, Projects> = projectsRepository.projects()
}