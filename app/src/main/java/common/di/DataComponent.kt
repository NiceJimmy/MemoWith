package common.di

import com.myapp.memowith.viewmodel.ViewModelFactory
import common.di.module.ApplicationModule
import common.di.module.ViewModelModule
import dagger.Component
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface DataComponent {


    val viewModelFactory: ViewModelFactory

}