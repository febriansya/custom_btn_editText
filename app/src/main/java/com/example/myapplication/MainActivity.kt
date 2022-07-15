package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var button: MyButton
    private lateinit var text: MyEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn)
        text = findViewById(R.id.myEditText)

        setMyButtonEnable()

        text.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                    todeo
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    setMyButtonEnable()
                }

                override fun afterTextChanged(p0: Editable?) {
//                   tidi
                }
            }
        )
        button.setOnClickListener {
            Toast.makeText(this@MainActivity, text.text, Toast.LENGTH_LONG).show()
        }
    }

    private fun setMyButtonEnable() {
        val result = text.text
        button.isEnabled = result != null && result.toString().isNotEmpty()
    }
}