package com.example.ud_04_1_inbox

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

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

        //pillamos drawer layout
        val drawerLayout=findViewById<DrawerLayout>(R.id.drawerMain)

        val navegadorFragmentos= supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment
        val navController= navegadorFragmentos.navController
        var appBarConf=  AppBarConfiguration.Builder(navController.graph)

        appBarConf.setOpenableLayout(drawerLayout) //antes de facer o build da barra para añadir ese menu lateral

        //navigationView do menu lateral
        val menuLateral=drawerLayout.findViewById<NavigationView>(R.id.nav_side)
        menuLateral.setupWithNavController(navController)

        actionBar.setupWithNavController(navController, appBarConf.build())

        //de esta maneira, facemos esa barra a por defecto da aplicacion
        val actionBarBottom=findViewById<BottomNavigationView>(R.id.botton_navigation)
        actionBarBottom.setupWithNavController(navController) //e pasamoslle o navigation pa que funcione
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