package chiquetano.luiz.movietheaterapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import chiquetano.luiz.movietheaterapp.R
import chiquetano.luiz.movietheaterapp.controller.AuthController

class MainActivity : AppCompatActivity() {

    private val authController = AuthController()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBt: Button = findViewById(R.id.loginBt)
        val signupBt: Button = findViewById(R.id.signup)
        val usernameEt: EditText = findViewById(R.id.username)
        val passwordEt: EditText = findViewById(R.id.password)

        loginBt.setOnClickListener(View.OnClickListener {
            var valid = authController.logIn(usernameEt.text.toString(), passwordEt.text.toString())
            if(valid) {
                val intent: Intent
                if (authController.userIsAdmin())
                    intent = Intent(this, AdminActivity::class.java)
                else intent = Intent(this, ClientActivity::class.java)
                startActivity(intent)
            }
            else showToast("Username ou senha inválidos")
        })

        signupBt.setOnClickListener(View.OnClickListener {
            var valid = authController.signIn(usernameEt.text.toString(), passwordEt.text.toString())
            if(valid){
                val intent = Intent(this, ClientActivity::class.java)
                startActivity(intent)
            }

        })

    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}