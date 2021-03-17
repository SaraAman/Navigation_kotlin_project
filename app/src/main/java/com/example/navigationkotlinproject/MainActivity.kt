package com.example.navigationkotlinproject

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity()
{

    private var contact: ContactFragment? = null
    private var login: AccountFragment? = null
    private var favorite: Favorite? = null
    private var bottomNavigationView: BottomNavigationView? = null
    var navController: NavController? = null
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        // FloatingActionButton fab = findViewById(R.id.fab);
        // menu should be considered as top level destinations.
        contact = ContactFragment()
        login = AccountFragment()
        favorite = Favorite()
        bottomNavigationView = findViewById<View>(R.id.Button_nav) as BottomNavigationView


        bottomNavigationView!!.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home_guest -> {
                    navController!!.navigate(R.id.nav_home)
                    // setFregment(fhome);
                    //bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                    true
                }
                R.id.contact -> {
                    navController!!.navigate(R.id.nav_contact)
                    // setFregment(contact);
                    //bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                    true
                }
                R.id.login -> {
                    //setFregment(login);
                    navController!!.navigate(R.id.nav_account)
                    // bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                    true
                }
                R.id.fav -> {
                   // setFregment(favorite)
                    navController!!.navigate(R.id.nav_fav)
                    // bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                    true
                }
                else -> false
            }
        })


//        val fab: FloatingActionButton = findViewById(R.id.fab)
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
     navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController!!, appBarConfiguration)
        navView.setupWithNavController(navController!!)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}