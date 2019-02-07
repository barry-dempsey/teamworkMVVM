package sdk.teamwork.com.teamworkapp.core.features.projects

import com.dempsey.teamwork.data.model.Projects
import sdk.teamwork.com.teamworkapp.core.exception.Failure
import sdk.teamwork.com.teamworkapp.core.functional.Either
import sdk.teamwork.com.teamworkapp.core.interactor.UseCase
import javax.inject.Inject

class ProjectsUseCase @Inject constructor(

) : UseCase<Projects, Unit>() {

    override suspend fun run(params: Unit): Either<Failure, Projects> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}