package woojin.projects.mediasearchapplication.repository

import io.reactivex.rxjava3.core.Observable
import woojin.projects.mediasearchapplication.model.ListItem

interface SearchRepository {

    fun search(query: String): Observable<List<ListItem>>

}