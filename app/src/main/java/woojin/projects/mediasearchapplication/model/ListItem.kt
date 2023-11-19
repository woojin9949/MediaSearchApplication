package woojin.projects.mediasearchapplication.model

import java.util.Date

interface ListItem {

    val thumbnailUrl: String
    val dateTime: Date
    var isFavorite: Boolean

}