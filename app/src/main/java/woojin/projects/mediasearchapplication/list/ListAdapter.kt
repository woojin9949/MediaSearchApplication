package woojin.projects.mediasearchapplication.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import woojin.projects.mediasearchapplication.databinding.ItemImageBinding
import woojin.projects.mediasearchapplication.databinding.ItemVideoBinding
import woojin.projects.mediasearchapplication.list.viewholder.ImageViewHolder
import woojin.projects.mediasearchapplication.list.viewholder.VideoViewHolder
import woojin.projects.mediasearchapplication.model.ImageItem
import woojin.projects.mediasearchapplication.model.ListItem
import woojin.projects.mediasearchapplication.model.VideoItem

class ListAdapter : ListAdapter<ListItem, RecyclerView.ViewHolder>(diffUtil) {

    // 이렇게 inner class로 선언되어야할 것을 밖으로 빼서 설정
   /* private inner class ImageViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem) {
            binding.item = item as ImageItem
        }
    }
    private inner class VideoViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem) {
            binding.item = item as VideoItem
        }
    }*/

    //보여줘야할 ViewHolder가 두개이므로 구별을 위해 getItemViewType 사용
    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is ImageItem) {
            IMAGE
        } else {
            VIDEO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == IMAGE) {
            ImageViewHolder(ItemImageBinding.inflate(inflater, parent, false))
        } else {
            VideoViewHolder(ItemVideoBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //ViewHolder bind
        val item = getItem(position)
        if (getItemViewType(position) == IMAGE) {
            (holder as ImageViewHolder).bind(item)
        } else {
            (holder as VideoViewHolder).bind(item)
        }
    }

    companion object {
        private const val IMAGE = 0
        private const val VIDEO = 1


        private val diffUtil = object : DiffUtil.ItemCallback<ListItem>() {
            override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem) =
                oldItem.thumbnailUrl == newItem.thumbnailUrl

            override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem) =
                oldItem == newItem
        }
    }
}