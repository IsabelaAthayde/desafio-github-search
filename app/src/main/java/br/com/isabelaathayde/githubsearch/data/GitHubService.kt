package br.com.isabelaathayde.githubsearch.data

import br.com.isabelaathayde.githubsearch.domain.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users/{user}/repos")
    fun getRepositories(@Path("user") user: String): Call<List<Repository>>
}
