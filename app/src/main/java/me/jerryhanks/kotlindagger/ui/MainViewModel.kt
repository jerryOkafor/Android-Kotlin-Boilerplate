package me.jerryhanks.kotlindagger.ui


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import me.jerryhanks.kotlindagger.data.DataSource
import me.jerryhanks.kotlindagger.data.db.entity.User
import javax.inject.Inject

/**
 * Created by Potencio on 7/18/2017. @ 11:07 AM
 * For android
 */

class MainViewModel @Inject
internal constructor(private val dataSource: DataSource) : ViewModel() {


    fun loadUsers(): LiveData<List<User>> {
        return dataSource.loadUsers()
    }

}
