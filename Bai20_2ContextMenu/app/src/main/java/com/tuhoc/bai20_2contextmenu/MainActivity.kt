package com.tuhoc.bai20_2contextmenu

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuhoc.bai20_2contextmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //enableEdgeToEdge()
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = Toolbar(this)
        var layoutParams  = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        toolbar.layoutParams = layoutParams
        toolbar.setBackgroundColor(Color.parseColor("#C1276D"))

        toolbar.setTitleTextColor(Color.WHITE)
        if (binding.root is LinearLayout) {
            (binding.root as LinearLayout).addView(toolbar, 0)
        }else{

        }
        setSupportActionBar(toolbar)
        supportActionBar?.title = "my app"
        registerForContextMenu(binding.txtContext)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //add(int groupId: Int, itemId: Int, order: Int, title: CharSequence?): MenuItem
        menu?.add(1, 1, 1, "Red")
        menu?.add(1, 2, 2, "Green")
        menu?.add(1, 3, 3, "Blue")

        //sub menu
        var subMenu = menu?.addSubMenu("Sex")
        subMenu?.add(2, 21, 1, "male")?.setChecked(true)
        subMenu?.add(2, 22, 2, "female")
        /* setGroupCheckable(int group, boolean checkable, boolean exclusive)
         * group: the group to which the items belong
         * checkable: whether the items in the group are checkable
         * exclusive: whether only one item in the group can be checked at a time

        */
        subMenu?.setGroupCheckable(2, true, true)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                binding.txtOption.setTextColor(Color.RED)
            }

            2 -> {
                binding.txtOption.setTextColor(Color.GREEN)
            }

            3 -> {
                binding.txtOption.setTextColor(Color.BLUE)
            }

            21 -> {
                binding.txtOption.setText("Bạn là nam")
            }
            22 -> {
                binding.txtOption.setText("Bạn là nữ")
            }

        }
        return super.onOptionsItemSelected(item)
    }
}