package me.jerryhanks.kotlindagger.data.db.entity

import android.arch.persistence.room.*

/**
 * @author <@Po10cio> on 11/5/17 for AndroidKotlinBoilerplate
 *
 */
@Entity(
        tableName = "pets",
        foreignKeys = arrayOf(ForeignKey(entity = User::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("user_id"),
                onDelete = ForeignKey.CASCADE)),
        indices = arrayOf(Index("user_id")))
data class Pet(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id: Long,

        @ColumnInfo(name = "name")
        val name: String,

        @ColumnInfo(name = "user_id")
        val userId: String)