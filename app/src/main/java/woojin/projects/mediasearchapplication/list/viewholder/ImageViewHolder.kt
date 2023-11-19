package woojin.projects.mediasearchapplication.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import woojin.projects.mediasearchapplication.databinding.ItemImageBinding
import woojin.projects.mediasearchapplication.model.ImageItem
import woojin.projects.mediasearchapplication.model.ListItem

//RecyclerView에 주로 inner class로 선언된 ViewHolder를 밖에서 선언
class ImageViewHolder(
    private val binding: ItemImageBinding
) : RecyclerView.ViewHolder(binding.root) {

    //ListItem은 Interface로 선언 구현되는 ImageItem 사용
    fun bind(item: ListItem){
        item as ImageItem
        binding.item = item
    }
}