package woojin.projects.mediasearchapplication.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import woojin.projects.mediasearchapplication.databinding.ItemVideoBinding
import woojin.projects.mediasearchapplication.model.ListItem
import woojin.projects.mediasearchapplication.model.VideoItem

class VideoViewHolder(
    private val binding: ItemVideoBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ListItem) {
        item as VideoItem
        binding.item = item
    }
}