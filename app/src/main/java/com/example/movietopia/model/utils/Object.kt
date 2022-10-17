package com.example.movietopia.model.utils

import com.example.movietopia.BuildConfig

object Object {

    interface NETWORKING{
        companion object{
            const val BASE_URL = "https://api.themoviedb.org/"
            const val API_KEY = "f0e9e0e9f224c4feb567ad64ae5f0d04"
            const val language = "en-US"
            const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"
            const val YOUTUBE_URL = "https://www.youtube.com"
        }
    }

    interface MOVIE_CATEGORY{
        companion object{
            const val NOW_PLAYING = "Now Playing"
            const val POPULAR = "Popular"
            const val TOP_RATED = "Top Rated"
            const val UPCOMING = "Upcoming"
            const val LATEST = "Latest"
        }
    }

    fun convertNamingIntoNum(input: String): Int = when(input){
        "Action" -> 28
        "Adventure" -> 12
        "Animation" -> 16
        "Comedy" -> 35
        "Crime" -> 80
        "Documentary" -> 99
        "Drama" -> 18
        "Family" -> 10751
        "Fantasy" -> 14
        "History" -> 36
        "Horror" -> 27
        "Music" -> 10402
        "Mystery" -> 9648
        "Romance" -> 10749
        "Science Fiction" -> 878
        "TV Movie" -> 10770
        "Thriller" -> 53
        "War" -> 10752
        "Western" -> 37
        else -> 0
    }

    fun convertNumIntoNaming(input: Int): String = when(input){
        28 -> "Action"
        12 -> "Adventure"
        16 -> "Animation"
        35 -> "Comedy"
        80 -> "Crime"
        99 -> "Documentary"
        18 -> "Drama"
        10751 -> "Family"
        14 -> "Fantasy"
        36 -> "History"
        27 -> "Horror"
        10402 -> "Music"
        9648 -> "Mystery"
        10749 -> "Romance"
        878 -> "Science Fiction"
        10770 -> "TV Movie"
        53 -> "Thriller"
        10752 -> "War"
        37 -> "Western"
        else -> ""
    }

    fun convertListNumIntoListMovie(inputList: List<Int>): ArrayList<String>{
        var result = ArrayList<String>()

        for(i in inputList){
            var item = convertNumIntoNaming(i)
            result.add(item)
        }

        return result
    }

    fun convertListStringIntoString(inputList: ArrayList<String>):String{
        var result = ""

        for ((i,j) in inputList.withIndex()){
            when(i != inputList.size-1){
                true -> {
                    result = result + "${j}, "
                }
                else ->{
                    result = result + "${j}."
                }
            }
        }

        return result
    }

    fun getListMovie(): List<DummyMovie>{
        return listOf(
            DummyMovie(
                movieName = "Kamen Rider Blade: Missing Ace",
                movieRate = 7.4,
                movieYear = "2013",
                movieDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Est ultricies integer quis auctor elit sed vulputate mi sit. Id volutpat lacus laoreet non curabitur. Scelerisque mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus et. Viverra aliquet eget sit amet tellus cras. Id semper risus in hendrerit gravida rutrum quisque non."
            ),
            DummyMovie(
                movieName = "Kamen Rider Blade: Missing Ace",
                movieRate = 7.4,
                movieYear = "2013",
                movieDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Est ultricies integer quis auctor elit sed vulputate mi sit. Id volutpat lacus laoreet non curabitur. Scelerisque mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus et. Viverra aliquet eget sit amet tellus cras. Id semper risus in hendrerit gravida rutrum quisque non."
            ),
            DummyMovie(
                movieName = "Kamen Rider Blade: Missing Ace",
                movieRate = 7.4,
                movieYear = "2013",
                movieDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Est ultricies integer quis auctor elit sed vulputate mi sit. Id volutpat lacus laoreet non curabitur. Scelerisque mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus et. Viverra aliquet eget sit amet tellus cras. Id semper risus in hendrerit gravida rutrum quisque non."
            ),
            DummyMovie(
                movieName = "Kamen Rider Blade: Missing Ace",
                movieRate = 7.4,
                movieYear = "2013",
                movieDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Est ultricies integer quis auctor elit sed vulputate mi sit. Id volutpat lacus laoreet non curabitur. Scelerisque mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus et. Viverra aliquet eget sit amet tellus cras. Id semper risus in hendrerit gravida rutrum quisque non."
            ),
            DummyMovie(
                movieName = "Kamen Rider Blade: Missing Ace",
                movieRate = 7.4,
                movieYear = "2013",
                movieDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Est ultricies integer quis auctor elit sed vulputate mi sit. Id volutpat lacus laoreet non curabitur. Scelerisque mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus et. Viverra aliquet eget sit amet tellus cras. Id semper risus in hendrerit gravida rutrum quisque non."
            ),
            DummyMovie(
                movieName = "Kamen Rider Blade: Missing Ace",
                movieRate = 7.4,
                movieYear = "2013",
                movieDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Est ultricies integer quis auctor elit sed vulputate mi sit. Id volutpat lacus laoreet non curabitur. Scelerisque mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus et. Viverra aliquet eget sit amet tellus cras. Id semper risus in hendrerit gravida rutrum quisque non."
            ),
            DummyMovie(
                movieName = "Kamen Rider Blade: Missing Ace",
                movieRate = 7.4,
                movieYear = "2013",
                movieDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Est ultricies integer quis auctor elit sed vulputate mi sit. Id volutpat lacus laoreet non curabitur. Scelerisque mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus et. Viverra aliquet eget sit amet tellus cras. Id semper risus in hendrerit gravida rutrum quisque non."
            )
        )
    }
}