package sdk.teamwork.com.teamworkapp.core.repositories

import com.dempsey.teamwork.data.model.Projects
import com.dempsey.teamwork.service.project.ProjectService
import io.reactivex.Observable
import retrofit2.Call
import sdk.teamwork.com.teamworkapp.core.exception.Failure
import sdk.teamwork.com.teamworkapp.core.functional.Either
import sdk.teamwork.com.teamworkapp.core.platform.NetworkHandler
import javax.inject.Inject

interface ProjectsRepository {

    fun projects(): Either<Failure, Projects>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: ProjectService) : ProjectsRepository {

        override fun projects(): Either<Failure, Projects> {
            return when (networkHandler.isConnected) {
                true -> request(service.allProjects, { it.map { it.to } }, Observable.empty())
                false, null -> Either.Left(Failure.NetworkConnection)
            }
        }

        private fun <T, R> request(call: Call<Observable<T>>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body()?.blockingFirst() ?: default)))
                    false -> Either.Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }
    }
}