package kr.co.tjoeun.myprofile_20200528

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smsBtn.setOnClickListener {
            val phoneNum = phoneNumEdt.text.toString()
            val inputContent = contentEdt.text.toString()

            val myUri = Uri.parse("smsto:${phoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body", inputContent)
            startActivity(myIntent)
        }

        dialBtn.setOnClickListener {
            val phoneNum = phoneNumEdt.text.toString()

            val myUri = Uri.parse("tel:${phoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }

        changeNickBtn.setOnClickListener {
            val myIntent = Intent(this, EditNickNameActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_NICKNAME) {
            if (resultCode == Activity.RESULT_OK) {
                val nickName = data?.getStringExtra("nick")

                nickNameTxt.text = nickName

                Toast.makeText(this, "닉네임 변경 완료.", Toast.LENGTH_SHORT).show()
            }
        }

    }

}
