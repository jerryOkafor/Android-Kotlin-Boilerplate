package me.jerryhanks.kotlindagger.data.db

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import org.junit.After
import org.junit.Before


/**
 * @author <@Po10cio> on 11/2/17 for AndroidKotlinBoilerplate
 *
 */

open class DBTest {

    protected lateinit var appDatabase: AppDatabase

    @Before
    fun initDb() {
        //we shall use an in-memory database because the information stored here shall disappear after test
        appDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase::class.java)
                //allow mainThread queries for the purpose of testing.
                .allowMainThreadQueries()
                .build()

    }


    @After
    fun closeDb() {
        //finally close the database
        appDatabase.close()
    }
}