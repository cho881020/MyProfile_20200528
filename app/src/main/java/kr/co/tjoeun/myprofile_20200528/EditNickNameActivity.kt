package kr.co.tjoeun.myprofile_20200528

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)

        val nick = intent.getStringExtra("nowNickName")
        nickNameEdt.setText(nick)

        okBtn.setOnClickListener {
            val newNickName = nickNameEdt.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("nick", newNickName)

            setResult(Activity.RESULT_OK, resultIntent)

            finish()

        }

    }
}
