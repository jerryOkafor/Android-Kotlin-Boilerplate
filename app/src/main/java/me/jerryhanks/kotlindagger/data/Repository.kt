package me.jerryhanks.kotlindagger.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import me.jerryhanks.kotlindagger.data.db.entity.User
import me.jerryhanks.kotlindagger.data.remote.AppApiService

/**
 * @author <@Po10cio> on 10/4/17 for KotlinDagger
 *
 */
open class Repository(val apiService: AppApiService) : DataSource {

    override fun loadUsers(): LiveData<List<User>> {

//        val mutableLiveData = MutableLiveData<List<User>>()
//
//        val users = ArrayList<User>()
//
//        (1..5).mapTo(users) { User("Jerry $it", "hanks@gmail.com") }
//
//        mutableLiveData.value = users
//        return mutableLiveData
        return Transformations.map(apiService.getUsers(), { response -> response.body })

    }

}