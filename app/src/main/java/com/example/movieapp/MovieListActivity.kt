package com.example.movieapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private var movies = mutableListOf(
        Movie("Inception", "A thief steals corporate secrets through dream-sharing."),
        Movie("The Dark Knight", "Batman faces the Joker in Gotham City."),
        Movie("Interstellar", "A space journey to save humanity."),
        Movie("Django Unchained", "A freed slave embarks on a quest."),
        Movie("Parasite", "A tale of class divide."),
        Movie("Avengers: Endgame", "Heroes battle Thanos to save the universe."),
        Movie("The Godfather", "A saga of the Corleone family."),
        Movie("The Shawshank Redemption", "A story of hope and friendship in prison."),
        Movie("The Matrix", "Reality questioned in a dystopian future."),
        Movie("Pulp Fiction", "Interwoven stories of crime and redemption.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val username = intent.getStringExtra("username") ?: "User"

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        welcomeTextView.text = "Welcome, $username!"

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        movieAdapter = MovieAdapter(movies)
        recyclerView.adapter = movieAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movie_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_more -> {
                addMoreMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addMoreMovies() {
        val newMovies = listOf(
            Movie("Guardians of the Galaxy", "A group of misfits band together to save the galaxy."),
            Movie("The Lion King", "A young lion must reclaim his throne."),
            Movie("Frozen", "Two sisters try to save their kingdom."),
            Movie("The Avengers", "Superheroes team up to save the world."),
            Movie("Star Wars: A New Hope", "The Rebels battle the Empire in a galaxy far, far away.")
        )


        movies.addAll(newMovies)
        movieAdapter.notifyDataSetChanged()

        Toast.makeText(this, "5 more movies added", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}