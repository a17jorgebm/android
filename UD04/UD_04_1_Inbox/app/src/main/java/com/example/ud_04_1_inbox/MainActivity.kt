package com.example.ud_04_1_inbox

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val actionBar=findViewById<MaterialToolbar>(R.id.materialToolBar)
        setSupportActionBar(actionBar)
        val navegadorFragmentos= supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment
        val navController= navegadorFragmentos.navController
        var appBarConf=  AppBarConfiguration.Builder(navController.graph).build()
        actionBar.setupWithNavController(navController, appBarConf)

        //de esta maneira, facemos esa barra a por defecto da aplicacion
        val actionBarBottom=findViewById<BottomNavigationView>(R.id.botton_navigation)
        actionBarBottom.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var controladorNavegacion = findNavController(R.id.container_fragment)
        NavigationUI.onNavDestinationSelected(item, controladorNavegacion)
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}