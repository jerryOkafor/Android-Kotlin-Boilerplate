package me.jerryhanks.kotlindagger.data.db

import android.support.test.runner.AndroidJUnit4
import me.jerryhanks.kotlindagger.data.db.entity.User
import me.jerryhanks.kotlindagger.util.LiveDataTestUtil.getValue
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

/**
 * @author <@Po10cio> on 11/2/17 for AndroidKotlinBoilerplate
 *
 */


/**
 * Tests the implementation of [UserDao]
 * */

@RunWith(AndroidJUnit4::class)
class UserDaoTest : DBTest() {

    @Test
    fun insertAndGetUser() {
        //insert a new user to the database
        appDatabase.usersDao().insertUser(USER)

        //get the same user
        val user = getValue(appDatabase.usersDao().getUserById(USER.id))
        assertThat(user?.id, `is`(USER.id))
        assertThat(user?.name, `is`(USER.name))
    }

    @Test
    fun getUserWhenNoUserInserted() {
        val user = getValue(appDatabase.usersDao().getUserById("123"))
        assertThat(user, nullValue())

    }

    @Test
    fun updateAndGetUser() {
        //given that we have a user in the database
        appDatabase.usersDao().insertUser(USER)

        //lets update the user
        val updatedUser = User(USER.id, "new username")

        //inserting an updated user with the same primary
        //key triggers a conflict which is resolved by replacing the existing user(Update)
        appDatabase.usersDao().insertUser(updatedUser)


        //retrieves the updated user
        val retrievedUser = getValue(appDatabase.usersDao().getUserById(USER.id))

        assertThat(retrievedUser?.name, `is`("new username"))

    }

    @Test
    fun deleteAndGetUser() {
        //given that we have a user in the database
        appDatabase.usersDao().insertUser(USER)

        //delete all the users in the data
        appDatabase.usersDao().deleteAllUsers()

        //when we try to get the /a user from the database
        val nullUser = getValue(appDatabase.usersDao().getUserById(USER.id))

        assertThat(nullUser, nullValue())
    }


    companion object {
        private val USER = User("id", "userName")
    }

}