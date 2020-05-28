package kr.co.tjoeun.myprofile_20200528

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeNickBtn.setOnClickListener {
            val myIntent = Intent(this, EditNickNameActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }
    }
}
