package woojin.projects.mediasearchapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

//ViewPager Fragment 설정
class ViewPagerAdapter(
    fa:FragmentActivity,
    private val list: List<Fragment>
) : FragmentStateAdapter(fa) {
    override fun getItemCount() = list.size

    override fun createFragment(position: Int) = list[position]
}