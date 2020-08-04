package swu.cs.mycalculation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //获取数据并计算
        val n1 = intent.getStringExtra("number1")
        val n2 = intent.getStringExtra("number2")
        val n3 = n1?.toInt()
        val n4 = n2?.toInt()
        val result = n3?.plus(n4!!).toString()
        //按下自己计算按钮
        calculate_yourself.setOnClickListener{
            Intent(this,MainActivity::class.java).apply {
                putExtra("number1",n1)
                putExtra("number2",n2)
                putExtra("result",result)
            }.also {
                startActivity(it)
            }
        }
        //按下打电话咨询按钮
        calculate_call.setOnClickListener{
            Intent().apply{
                action = Intent.ACTION_DIAL
                data = Uri.parse("tel:15779110625")
            }.also {
                startActivity(it)
            }
        }
    }

}
