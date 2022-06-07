package common.di.module

import android.app.Application
import android.content.Context
import com.myapp.memowith.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(internal var mBaseApplication: BaseApplication) {

    @Provides
    @Singleton
    internal fun providesApplication(): Application {
        return mBaseApplication
    }

    @Provides
    @Singleton
    internal fun providesBaseApplication(): BaseApplication {
        return mBaseApplication
    }

    @Provides
    @Singleton
    internal fun providesContext(): Context {
        return mBaseApplication.applicationContext
    }
}