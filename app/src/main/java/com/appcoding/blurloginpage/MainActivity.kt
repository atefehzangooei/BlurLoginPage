package com.appcoding.blurloginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appcoding.blurloginpage.ui.theme.BlurLoginPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlurLoginPageTheme {
                MyLoginPage()
            }
        }
    }
}

@Composable
fun MyLoginPage() {

    val configuration = LocalConfiguration.current
    val color_ligh = colorResource(id = R.color.gradiant_front_light_blue)
    val color_blue = colorResource(id = R.color.gradiant_front_blue)
    val screen_width = configuration.screenWidthDp.toFloat()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.background))
    ){

        Column(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .blur(2.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            colorResource(id = R.color.gradiant_back_blue),
                            colorResource(id = R.color.gradiant_back_green)
                        )
                    ), shape = RoundedCornerShape(0.dp, 0.dp, 60.dp, 60.dp)
                )
            ){

                DrawCircle(screen_width, color_ligh, color_blue)

            }


            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f))
        }

        DesignSigninBox()
    }
}

@Composable
fun DesignSigninBox() {
    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Text(modifier = Modifier.padding(10.dp),
                text = "Welcome",
                fontSize = 16.sp,
                color = Color.White)

            Icon(modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.heart),
                contentDescription ="",
                tint = Color.White
            )

            Text(modifier = Modifier.padding(10.dp),
                text = "COMPONY",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(modifier = Modifier.padding(5.dp),
                text = "LOGO",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold)

        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(0.75f),
            contentAlignment = Alignment.TopStart)
        {

            SigninBox()
        }



    }
}

@Composable
fun DrawCircle(screen_width : Float, color_ligh : Color, color_blue : Color) {
    Canvas(modifier = Modifier.fillMaxSize()
        .offset(x = (-120).dp, y = (-120).dp),
        onDraw ={
            drawCircle(radius = screen_width * 2f,
                brush = Brush.horizontalGradient(listOf(
                    color_ligh, color_blue
                )))
        } )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SigninBox() {

    var newvalue by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(intrinsicSize = IntrinsicSize.Min)
        .padding(20.dp))
    {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp)
                .alpha(0.6f)
                .blur(50.dp, BlurredEdgeTreatment.Unbounded),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.box_signin)
            )
        ) {

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp)
                .border(
                    BorderStroke(
                        2.dp, Brush.horizontalGradient(
                            listOf(
                                colorResource(id = R.color.box_signin),
                                Color.White
                            )
                        )
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            colorResource(id = R.color.box_signin),
                            colorResource(id = R.color.box_signin)
                        )
                    ),
                    shape = RoundedCornerShape(20.dp),
                    alpha = 0.4f
                )
                .padding(20.dp)
        )
        {
            Signin_Title()

            Signin_NewUSer()

// new comment
            //textfiled email
            TextField(modifier = Modifier
                .fillMaxWidth(),
                value = "",
                onValueChange = { newvalue = it },
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White
                ),
                placeholder = { Text(text = "Email address") }

            )

            Spacer(modifier = Modifier.size(10.dp))

            //textfiled password
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = "",
                onValueChange = { newvalue = it },
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White
                ),
                placeholder = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation()

            )

            Spacer(modifier = Modifier.size(10.dp))

            //continue Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.button_blue),
                        contentColor = Color.White
                    )
                ) {

                    Text(text = "Continue")
                }
            }

            Spacer(modifier = Modifier.size(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Or",
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.hint)
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Signin_GoogleButton()

            Spacer(modifier = Modifier.size(10.dp))

            Signin_ButtonFacebook()
        }
    }

}

@Composable
fun Signin_ButtonFacebook() {

    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.button_blue),
            contentColor = Color.White
        )
    )
    {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.facebookicon),
            contentDescription = "",
            tint = Color.White
        )

        Spacer(modifier = Modifier.size(15.dp))

        Text(text = "Continue with Facebook")
    }
}

@Composable
fun Signin_GoogleButton() {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = colorResource(id = R.color.hint)
        )
    )
    {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.googleicon),
            contentDescription = "",
            tint = colorResource(id = R.color.google_icon)
        )

        Spacer(modifier = Modifier.size(15.dp))

        Text(text = "Continue with Google")
    }


}

@Composable
fun Signin_NewUSer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(
            text = "New user?",
            fontSize = 14.sp,
            color = Color.White
        )

        TextButton(
            onClick = {}
        ) {
            Text(
                text = "Create an account",
                fontSize = 14.sp,
                color = colorResource(id = R.color.text_green)
            )

        }
    }
}

@Composable
fun Signin_Title() {
    Text(
        text = "Sign in",
        fontSize = 18.sp,
        color = Color.White
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BlurLoginPageTheme {
        MyLoginPage()
    }
}