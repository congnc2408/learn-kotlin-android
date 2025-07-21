package com.tuhoc.bai18tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {

//    private val fragments = listOf(
//        FragmentMV1(),
//        FragmentMV2(),
//        FragmentMV3(),
//        FragmentMV4(),
//        FragmentMV5()
//    )

    private val pages = listOf(
        PageConfig("MV1") { FragmentMV1() },
        PageConfig("MV2") { FragmentMV2() },
        PageConfig("MV3") { FragmentMV3() },
        PageConfig("MV4") { FragmentMV4() },
        PageConfig("MV5") { FragmentMV5() },
        // PageConfig("Trang chi tiết") { DetailFragment.newInstance("data for detail") }
    )
    fun getPageTitle(position: Int): CharSequence{
        return pages[position].title
    }

    override fun createFragment(position: Int): Fragment {
      //return fragments[position]
        return pages[position].fragmentCreator.invoke()
    }

    override fun getItemCount(): Int {
        return pages.size
    }


}

data class PageConfig(
    val title: String,
    val fragmentCreator: () -> Fragment
)