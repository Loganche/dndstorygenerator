package lxndrloginov.projects.dndstorygenerator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lxndrloginov.projects.dndstorygenerator.screens.Screens

class MainViewModel : ViewModel() {

    private val _currentScreen = MutableLiveData<Screens>(Screens.DrawerScreens.About)
    val currentScreen: LiveData<Screens> = _currentScreen

    fun setCurrentScreen(screen: Screens) {
        _currentScreen.value = screen
    }
}