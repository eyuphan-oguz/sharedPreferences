package com.eyuphanoguz.hidetousername

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var alinanKullaniciAdi : String ? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         sharedPreferences =  this.getSharedPreferences("com.eyuphanoguz.hidetousername",
            Context.MODE_PRIVATE)

        alinanKullaniciAdi=sharedPreferences.getString("username","test")

        if(alinanKullaniciAdi!=null){
            var showMessageInput = findViewById<TextView>(R.id.textView)
            showMessageInput.text="Kaydedilen kullanici adi : ${alinanKullaniciAdi}"
        }

    }

    fun removeButton(view:View){
        alinanKullaniciAdi = sharedPreferences.getString("username","")

        if(alinanKullaniciAdi != null){
            var showMessageInput = findViewById<TextView>(R.id.textView)
            showMessageInput.text=""
            sharedPreferences.edit().remove("username").apply()
        }

    }

    fun saveButton(view:View){
        var kullaniciAdi = findViewById<EditText>(R.id.editText).text.toString()
        var showMessageInput = findViewById<TextView>(R.id.textView)

        if(kullaniciAdi.isEmpty()){
            Toast.makeText(this,"Alanı boş geçmeyiniz.",Toast.LENGTH_LONG).show()
        }else{
            sharedPreferences.edit().putString("username",kullaniciAdi).apply()
            showMessageInput.text="Kaydedilen kullanici adi : ${kullaniciAdi}"

        }
    }

}