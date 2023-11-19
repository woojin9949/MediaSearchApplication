package woojin.projects.mediasearchapplication.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import woojin.projects.mediasearchapplication.databinding.ItemImageBinding
import woojin.projects.mediasearchapplication.model.ImageItem
import woojin.projects.mediasearchapplication.model.ListItem

class ImageViewHolder(
    private val binding: ItemImageBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ListItem){
        item as ImageItem
        binding.item = item
    }
}