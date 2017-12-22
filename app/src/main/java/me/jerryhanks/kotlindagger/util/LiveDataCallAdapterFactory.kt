package me.jerryhanks.kotlindagger.util

import android.arch.lifecycle.LiveData
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

import me.jerryhanks.kotlindagger.data.remote.ApiResponse
import retrofit2.CallAdapter
import retrofit2.Retrofit

/**
 * Factory class that is used to create the LiveDataCallAdapter
 * */

class LiveDataCallAdapterFactory private constructor() : CallAdapter.Factory() {

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if (getRawType(returnType) != LiveData::class.java) {
            return null
        }
        val observableType = getParameterUpperBound(0, returnType as ParameterizedType)
        val rawObservableType = getRawType(observableType)

        if (rawObservableType != ApiResponse::class.java) {
            throw IllegalArgumentException("type must be a resource")
        }

        if (observableType !is ParameterizedType) {
            throw IllegalArgumentException("resource must be parameterized")
        }

        val bodyType = getParameterUpperBound(0, observableType)
        return LiveDataCallAdapter<Any>(bodyType)
    }

    companion object {

        fun create(): LiveDataCallAdapterFactory {
            return LiveDataCallAdapterFactory()
        }
    }
}