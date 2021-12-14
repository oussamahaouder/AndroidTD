package com.example.tp6;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Githubservice {
     class Repo {
        private int id ;
        private String name;
        private String Full_Name;
        private String html_url;

         public int getId() {
             return id;
         }
         public String getName() {
             return name;
         }
         public String getFull_Name() {
             return Full_Name;
         }
         public String getHtml_url() {
             return html_url;
         }
         public void setId(int id) {
             this.id = id;
         }
         public void setName(String name) {
             this.name = name;
         }
         public void setFull_Name(String full_Name) {
             Full_Name = full_Name;
         }
         public void setHtml_url(String html_url) {
             this.html_url = html_url;
         }
     }

    String ENDPOINT = " https://api.github.com";
    @GET("/users/{user}/repos")
    Call<List<Repo>> listrepos(@Path("user") String user) ;

    @GET("/search/reposotories")
    List<Repo> searchRepos(@Query("q") String query);


}
