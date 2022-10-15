package com.example.movietopia.model.utils

import com.example.movietopia.BuildConfig

object Object {

    interface MOVIE_CATEGORY{
        companion object{
            const val NOW_PLAYING = "Now Playing"
            const val POPULAR = "Popular"
            const val TOP_RATED = "Top Rated"
            const val UPCOMING = "Upcoming"
            const val LATEST = "Latest"
        }
    }

    fun getListMovieNowPlaying(): List<DummyMovie>{
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