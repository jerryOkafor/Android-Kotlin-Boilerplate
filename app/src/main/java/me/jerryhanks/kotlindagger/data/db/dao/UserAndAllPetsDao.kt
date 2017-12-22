package me.jerryhanks.kotlindagger.data.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import me.jerryhanks.kotlindagger.data.db.model.UserAndAllPets

/**
 * @author <@Po10cio> on 11/5/17 for AndroidKotlinBoilerplate
 *
 */

@Dao
interface UserAndAllPetsDao {
    /**
     * Loads all the users and their pets
     *
     * @return List of [UserAndAllPets]
     * */
    @Query("SELECT * FROM Users")
    fun loadUsersAndPets(): LiveData<List<UserAndAllPets>>


    /**
     * Loads a single user with list of hu=is pets as [UserAndAllPets]
     * @return [UserAndAllPets]
     * */
    @Query("SELECT * FROM Users WHERE id = :id")
    fun loadUserAndPets(id: String): LiveData<UserAndAllPets>
}