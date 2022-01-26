package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplication.models.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {
    private lateinit var profilePhoto: ImageView
    private lateinit var textView: TextView
    private lateinit var photoLink: EditText
    private lateinit var userName : EditText
    private lateinit var save : Button
    private lateinit var buttonPasswordChange:Button
    private lateinit var buttonLogout: Button
    private lateinit var home : Button
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")
    private val auth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        init()

        registerListener()

        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo : UserInfo = snapshot.getValue(UserInfo::class.java)?: return
                textView.text = userInfo.name
                Glide.with(this@ProfileActivity)
                    .load(userInfo.imageUrl).placeholder(R.drawable.ic_launcher_foreground).into(profilePhoto)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }

    private fun init(){
        profilePhoto=findViewById(R.id.profilePhoto)
        photoLink=findViewById(R.id.photoLink)
        userName=findViewById(R.id.userName)
        textView=findViewById(R.id.textView)
        save=findViewById(R.id.save)
        buttonPasswordChange=findViewById(R.id.buttonPasswordChange)
        buttonLogout=findViewById(R.id.buttonLogout)
        home=findViewById(R.id.home)
    }

    private fun registerListener(){

        save.setOnClickListener(){
            val name = userName.text.toString()
            val imageUrl = photoLink.text.toString()

            if (name.isEmpty() || imageUrl.isEmpty()){
                return@setOnClickListener
            }

            val userInfo = UserInfo(name, imageUrl)
            db.child(auth.currentUser?.uid!!)
                .setValue(userInfo)
        }

        buttonLogout.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        buttonPasswordChange.setOnClickListener(){
            startActivity(Intent(this, PasswordChangeActivity::class.java))

        }
        home.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}