package woojin.projects.mediasearchapplication.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import woojin.projects.mediasearchapplication.databinding.ItemVideoBinding
import woojin.projects.mediasearchapplication.model.ListItem
import woojin.projects.mediasearchapplication.model.VideoItem

//RecyclerView에 주로 inner class로 선언된 ViewHolder를 밖에서 선언
class VideoViewHolder(
    private val binding: ItemVideoBinding
) : RecyclerView.ViewHolder(binding.root) {

    //ListItem은 Interface로 선언 구현되는 VideoItem 사용
    fun bind(item: ListItem) {
        item as VideoItem
        binding.item = item
    }
}