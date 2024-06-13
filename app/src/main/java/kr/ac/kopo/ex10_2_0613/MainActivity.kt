package kr.ac.kopo.ex10_2_0613

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var voteCount = IntArray(9)

        for(i in 0..8){
            voteCount[i] = 0
        }

        var image = arrayOfNulls<ImageView>(9)

        var imageId = arrayOf(R.id.img01, R.id.img02, R.id.img03,
            R.id.img04, R.id.img05, R.id.img06,
            R.id.img07, R.id.img08, R.id.img09) // 초기값을 위해 지정

        var imgNamge = arrayOf("주토피아", "코코", "소울",
            "주먹왕 랄프", "루카", "피노키오",
            "미키마우스", "위시", "다이노소어")

        for(i in imageId.indices){ // indices는 배열 길이만큼 반복 도와주는 명령어
//            ImageView객체의 참조값을 배열에 저장
            image[i] = findViewById<ImageView>(imageId[i])
            image[i]!!.setOnClickListener { // !! = 널값이 존재하지 않다고 가정
                voteCount[i]++
                Toast.makeText(applicationContext, imgNamge[i] + ": 총 " + voteCount[i] + " 표", Toast.LENGTH_SHORT).show()
            }
        }

        var btnDone = findViewById<Button>(R.id.btnDone)
        btnDone.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("imgName", imgNamge)
            intent.putExtra("voteCount", voteCount)

            startActivity(intent)
        }
    }
}