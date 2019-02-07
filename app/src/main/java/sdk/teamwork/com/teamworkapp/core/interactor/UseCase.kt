package sdk.teamwork.com.teamworkapp.core.interactor

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import sdk.teamwork.com.teamworkapp.core.exception.Failure
import sdk.teamwork.com.teamworkapp.core.functional.Either

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        val job = async(CommonPool) { run(params) }
        launch(UI) { onResult(job.await()) }
    }

    class None
}
