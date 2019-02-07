package sdk.teamwork.com.teamworkapp.core.platform

import android.content.Context
import sdk.teamwork.com.teamworkapp.core.extension.networkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHandler
@Inject constructor(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnected
}