package me.jerryhanks.kotlindagger.data

import android.arch.lifecycle.LiveData
import me.jerryhanks.kotlindagger.data.db.entity.User

/**
 * @author <@Po10cio> on 10/4/17 for KotlinDagger
 *
 *

 */

interface DataSource {
    /**
     * Loads a list of users
     * */
    fun loadUsers(): LiveData<List<User>>
}
