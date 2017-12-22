package me.jerryhanks.kotlindagger.data.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import me.jerryhanks.kotlindagger.data.db.entity.Pet
import me.jerryhanks.kotlindagger.data.db.entity.User

/**
 * @author <@Po10cio> on 11/2/17 for AndroidKotlinBoilerplate
 *
 */
@Dao
interface UsersDao {

    /**
     * Get a user by id
     *
     * @param id The id of teh user
     * @return user from the table with the specific id
     * */
    @Query("SELECT * from Users WHERE id = :id")
    fun getUserById(id: String): LiveData<User>

    /**
     * Insert a user to the database, if the user already exist, replace it
     *
     * @param user The user tobe inserted
     * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)


    /**
     * Delete all the users from the database
     * */
    @Query("DELETE FROM Users")
    fun deleteAllUsers()

    /**
     * Delete a single User from teh Database
     *
     * @param user The User to be deleted
     * */
    @Delete
    fun deleteUser(user: User)

    /**
     * Deletes a varable number of users
     * */
    @Delete
    fun deleteUsers(vararg user: User)

    /**
     * Loads all the users in the db
     * */
    @Query("SELECT * FROM Users")
    fun getAllUsers(): LiveData<List<User>>

    /**
     * Inserts a user and hist pets
     * */
    @Insert
    fun insertUserAndPets(user: User, pets: List<Pet>)
}