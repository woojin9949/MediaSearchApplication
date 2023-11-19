package woojin.projects.mediasearchapplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import coil.load
import java.text.SimpleDateFormat
import java.util.Date

//xml 파일에 속성으로 사용할 수 있게 Binding을 함
@BindingAdapter("visible")
fun View.setVisible(isShow: Boolean) {
    isVisible = isShow
}

@BindingAdapter("image")
fun ImageView.setImage(imageUrl: String?) {
    load(imageUrl) {
        crossfade(300)
    }
}

@BindingAdapter("date")
fun TextView.setDataText(date: Date?) {
    if (date == null) {
        return
    }
    text = SimpleDateFormat("YYYY.MM.dd HH:mm:ss").format(date)
}

@BindingAdapter("favorite")
fun ImageView.setFavorite(isFavorite: Boolean) {
    setImageResource(if (isFavorite) R.drawable.baseline_favorite_24 else R.drawable.baseline_favorite_border_24)
}