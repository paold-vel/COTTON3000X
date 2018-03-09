package com.example.cuser.cotton3000x.drawerlayoutANKO

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar

import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import com.example.cuser.cotton3000x.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.contentFrameLayout

import org.jetbrains.anko.custom.customView


class DrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var draw : DrawUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        draw = customView{}
        setContentView(draw)

        findOptional<LinearLayout>(R.id.linear_layout)!!.contentFrameLayout {
            textView("text")
            //вот здесь, если так делать правильно
            recyclerView {

            }
        }

        val toolbar = findOptional<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, draw, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        draw.addDrawerListener(toggle)
        toggle.syncState()

        findOptional<NavigationView>(R.id.nav_bar)!!.setNavigationItemSelectedListener(this)



    }

    override fun onBackPressed() {
        if (draw.isDrawerOpen(GravityCompat.START)) {
            draw.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {
                findOptional<LinearLayout>(R.id.linear_layout)!!.contentFrameLayout {
                    textView("nav_camera")
                }
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        draw.closeDrawer(GravityCompat.START)
        return true
    }
}

data class GitHubRepositoryInfo(val name: String) {
    class List : ArrayList<GitHubRepositoryInfo>()
}

inline fun Activity.recyclerView(init: RecyclerView.() -> Unit) {
    val recyclerView = RecyclerView(this)
    recyclerView.init()
    setContentView(recyclerView)
}

