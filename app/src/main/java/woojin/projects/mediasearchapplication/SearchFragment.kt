package woojin.projects.mediasearchapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import woojin.projects.mediasearchapplication.databinding.FragmentSearchBinding
import woojin.projects.mediasearchapplication.list.ListAdapter

class SearchFragment : Fragment() {
    private var binding: FragmentSearchBinding? = null

    private val adapter by lazy { ListAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSearchBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            recyclerView.adapter = adapter
        }
    }

    //Destroy시 null 초기화
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun searchKeyword(text: String) {

    }
}
