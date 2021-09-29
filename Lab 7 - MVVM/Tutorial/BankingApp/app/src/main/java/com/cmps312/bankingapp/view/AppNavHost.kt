package com.cmps312.bankingapp.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(){
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "transferList"){
        composable(route = "transferDetails"){ TransferDetails(onSubmit = {
            navHostController.navigate("transferList")
        })}
        composable(route = "transferList"){ TransferList(onTransferSelected = {
            navHostController.navigate("transferDetails")
        })}
    }

}
