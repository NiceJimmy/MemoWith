package common.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myapp.memowith.viewmodel.MainViewModel
import com.myapp.memowith.viewmodel.MyAlarmsViewModel
import com.myapp.memowith.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyAlarmsViewModel::class)
    internal abstract fun bindMyAlarmsViewModel(myAlarmsViewModel: MyAlarmsViewModel): ViewModel

}