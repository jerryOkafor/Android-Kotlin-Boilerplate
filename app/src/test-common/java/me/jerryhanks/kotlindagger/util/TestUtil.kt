package me.jerryhanks.kotlindagger.util

import android.arch.lifecycle.LiveData
import me.jerryhanks.kotlindagger.data.db.entity.User

/**
 * @author <@Po10cio> on 11/3/17 for AndroidKotlinBoilerplate
 *
 */
class TestUtil {

    companion object {
        fun createUsers(): LiveData<List<User>> {
            return object : LiveData<List<User>>() {
                override fun onActive() {
                    super.onActive()
                    val users = ArrayList<User>()
                    (1..5).mapTo(users) { User("Jerry $it", "hanks@gmail.com") }

                    postValue(users)
                }
            }
        }

        fun createEmptyUsers(): LiveData<List<User>>? {
            return object : LiveData<List<User>>() {
                override fun onActive() {
                    super.onActive()
                    postValue(null)
                }
            }
        }


    }
}