package com.app.credibanco_mobile.view

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.compiler.plugins.kotlin.ComposeFqNames.remember
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.credibanco_mobile.viewmodel.InsertViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.app.credibanco_mobile.model.dto.AuthorizationRequest
import kotlin.random.Random


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<InsertViewModel>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                content()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun content(
        modifier: Modifier = Modifier,
        navController: NavHostController = rememberNavController()
    ){

        NavHost(
            navController = navController,
            modifier = modifier,
            startDestination = "root"){

            composable("root"){
                form(navHostController = navController)
            }

//            composable("recipeDetail/{id}",
//                arguments = listOf(navArgument("id"){type = NavType.IntType})
//            ){
//                activityDetailRecipe(id = it.arguments!!.getInt("id"))
//            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun form(

        navHostController: NavHostController
    ){

        var amountText by remember{ mutableStateOf("Monto") }

        var cardText by remember{ mutableStateOf("Tarjeta") }

        Column{
            TextField(value = amountText,
                onValueChange = { amountText = it },
                label = { Text("Monto") }
            )

            TextField(value = cardText,
                onValueChange = { cardText = it },
                label = { Text("Número de Tarjeta") }
            )
            
            Button(onClick ={
                 val request = AuthorizationRequest(
                    id = Random.nextInt(100).toString(),
                    card = cardText,
                    amount = amountText,
                    commerceCode = "000123",
                    terminalCode = "000ABC"
                )
                viewModel.onCreate(request)

            }) {
                Text(text = "Autorizar")
            }

        }


    }

}