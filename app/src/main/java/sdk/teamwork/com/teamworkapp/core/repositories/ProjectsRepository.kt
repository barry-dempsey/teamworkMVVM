package sdk.teamwork.com.teamworkapp.core.repositories

import com.dempsey.teamwork.data.model.Projects
import com.dempsey.teamwork.service.project.ProjectsService
import retrofit2.Call
import sdk.teamwork.com.teamworkapp.core.exception.Failure
import sdk.teamwork.com.teamworkapp.core.functional.Either
import sdk.teamwork.com.teamworkapp.core.platform.NetworkHandler
import javax.inject.Inject

interface ProjectsRepository {

    fun projects(): Either<Failure, Projects>

    class Network
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: ProjectsService
    ) : ProjectsRepository
    {
        override fun projects(): Either<Failure, Projects> {
            return when (networkHandler.isConnected) {
                true -> request(service.getAllProjects(), { it }, Projects())
                false, null -> Either.Left(Failure.NetworkConnection)
            }
        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }
    }
}