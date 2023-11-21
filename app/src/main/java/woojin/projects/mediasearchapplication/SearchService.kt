package woojin.projects.mediasearchapplication

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import woojin.projects.mediasearchapplication.BuildConfig.KAKAO_REST_API_KEY
import woojin.projects.mediasearchapplication.model.ImageListResponse
import woojin.projects.mediasearchapplication.model.VideoListResponse

interface SearchService {

    @Headers("Authorization: KakaoAK ${KAKAO_REST_API_KEY}")
    @GET("image")
    fun searchImage(@Query("query") query: String): Observable<ImageListResponse>

    @Headers("Authorization: KakaoAK ${KAKAO_REST_API_KEY}")
    @GET("vclip")
    fun searchVideo(@Query("query") query: String): Observable<VideoListResponse>
}