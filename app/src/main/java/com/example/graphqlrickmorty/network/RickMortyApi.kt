package com.example.graphqlrickmorty.network

import android.os.Looper
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

class RickMortyApi{

    fun getClient(): ApolloClient {
        check(Looper.myLooper() != Looper.getMainLooper()) {
            "Only main thread can access apollo client"
        }
        val okHttp = OkHttpClient.Builder().build()
        return ApolloClient.builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .okHttpClient(okHttp)
            .build()

    }
}