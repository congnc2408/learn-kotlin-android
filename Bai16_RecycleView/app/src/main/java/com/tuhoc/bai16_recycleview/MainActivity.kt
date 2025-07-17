package com.tuhoc.bai16_recycleview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuhoc.bai16_recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var  bidning: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bidning = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bidning.root)

        val ds = mutableListOf<OutData>()
        ds.add(OutData(R.drawable.jjk, "Jujutsu Kaisen", "Jujutsu Kaisen là một bộ anime nổi tiếng với cốt truyện hấp dẫn và hình ảnh đẹp mắt."))
        ds.add(OutData(R.drawable.akira, "Akira", "Akira là một bộ anime kinh điển, nổi tiếng với hình ảnh đẹp và cốt truyện sâu sắc."))
        ds.add(OutData(R.drawable.gintama, "Gintama", "Gintama là một bộ anime hài hước và hành động, nổi tiếng với những tình huống dở khóc dở cười."))
        ds.add(OutData(R.drawable.zootpia, "Zootopia", "Zootopia là một bộ phim hoạt hình nổi tiếng với thông điệp về sự đa dạng và chấp nhận lẫn nhau."))
        ds.add(OutData(R.drawable.sakamoto_day, "Sakamoto Days", "Sakamoto Days là một bộ manga hành động hài hước, kể về cuộc sống của một sát thủ đã giải nghệ."))
        ds.add(OutData(R.drawable.one_punch_man, "One Punch Man","Phồng tôm"))
        ds.add(OutData(R.drawable.beelzebub, "Beelzebub", "Beelzebub là một bộ manga hài hước về cuộc sống của một học sinh trung học nuôi một quỷ nhỏ."))
        ds.add(OutData(R.drawable.sogeking_soma_p1, "Sogeking Soma P1", "Sogeking Soma P1 là một bộ manga hành động phiêu lưu, kể về cuộc hành trình của một anh hùng trẻ tuổi."))

        val adaptervv = RvAdapter(ds,object : RvInterface {
            override fun OnClickView(pos: Int) {
                // Xử lý sự kiện khi người dùng nhấn vào một mục trong RecyclerView
                val selectedItem = ds[pos]
                // Bạn có thể thực hiện các hành động khác tại đây, ví dụ: hiển thị thông tin chi tiết về mục đã chọn
                Toast.makeText(this@MainActivity,"Bạn đã chọn: ${selectedItem.title}", Toast.LENGTH_SHORT).show()
            }
        })
        bidning.recyclerView.adapter = adaptervv
        bidning.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}