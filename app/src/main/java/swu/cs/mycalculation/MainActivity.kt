package swu.cs.mycalculation

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //获取结果
        Result.setText(intent.getStringExtra("result"))
        //按下计算按钮
        calculate.setOnClickListener{
            Intent(this,SecondActivity::class.java).apply {
                putExtra("number1",Date1.text.toString())
                putExtra("number2",Date2.text.toString())
            }.also {
                startActivity(it)
            }
        }
        //按下使用微信分享按钮
        share.setOnClickListener{
            Intent().apply {
                action = "android.intent.action.WECHAT"
                data = Uri.parse("result:结果为${intent.getStringExtra("result")}")
            }.also {
                startActivity(it)
            }
        }
    }
}