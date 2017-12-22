package me.jerryhanks.kotlindagger.data.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * @author <@Po10cio> on 11/2/17 for AndroidKotlinBoilerplate
 *
 */
@Entity(tableName = "users")
data class User(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: String = UUID.randomUUID().toString(),

        @ColumnInfo(name = "name")
        val name: String)