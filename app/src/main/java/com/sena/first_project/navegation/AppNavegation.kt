package com.sena.first_project.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sena.first_project.ui.screen.Home
import com.sena.first_project.ui.screen.Producto

@Composable
fun AppNavegation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Inicio
    ){
        composable<Inicio>{
            Home(
                onirProducto = {
                    navController.navigate(Productos)
                }
            )

        }
        composable<Productos>{
            Producto(
                onirDetalleProducto = { id ->
                    navController.navigate(DetalleProducto(id))
                },
                onVolverHome = {
                    navController.popBackStack()
                }
            )
        }
        composable<DetalleProducto>{dato->
            DetalleProducto(
                id = dato.arguments?.getInt("id") ?: 0
            )
        }
    }
}
