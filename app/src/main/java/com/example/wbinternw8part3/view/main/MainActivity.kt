package com.example.wbinternw8part3.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import com.example.wbinternw8part3.R
import com.example.wbinternw8part3.view.aboutapp.AboutAppFragment
import com.example.wbinternw8part3.view.favorite.FavoriteFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite -> {
                findNavController(R.id.nav_host_fragment_activity_main).navigate(R.id.favoriteFragment)
            }
            R.id.aboutApp -> {
                findNavController(R.id.nav_host_fragment_activity_main).navigate(R.id.aboutAppFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}