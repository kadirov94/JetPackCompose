package com.example.jetpackcompose.jetpacknavigation

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose.jetpacknavigation.Screen

@Composable
fun Navigation() {
    val navControler = rememberNavController()
    NavHost(navController = navControler, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navControler)
            //DetailScreen(name = )
        }
        composable(
            route = Screen.DetailScreen.route,
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "NAME"
                    nullable = true
                }
            )
        ) { entry ->
            DetailScreen(name = entry.arguments?.getString("name").toString())
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    TextFieldCustom()
    ButtonCustoms(navController = navController)
}

@Composable
fun TextFieldCustom() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // TextField(value = String(), onValueChange = {  })
        // TextField(value = String(), onValueChange = {  })

        OutlinedTextField(
            value = String(), onValueChange = { String ->

            },
            label = {
                Text(text = "Логин")
            },
            //enable = false,
            maxLines = 2,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )
        )

        OutlinedTextField(
            value = String(), onValueChange = { String ->

            },
            label = {
                Text(text = "Пароль")
            },
            //enable = false,
            maxLines = 2,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )
        )
    }
}

@Composable
fun ButtonCustoms(navController: NavController) {

    val context = LocalContext.current

    var color = remember {
        mutableStateOf(Color.Blue)
    }
    val text = remember {
        mutableStateOf("OK")
    }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        onClick = {
            navController.navigate(Screen.DetailScreen.route)
            Toast.makeText(context, "$text", Toast.LENGTH_SHORT).show()
        }
    ) {
        Text(text = "OK")
    }
}

@Composable
fun DetailScreen(name: String){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter,
        ){
        Text(text = name)
    }
}