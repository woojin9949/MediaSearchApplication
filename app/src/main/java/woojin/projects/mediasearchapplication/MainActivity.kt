package woojin.projects.mediasearchapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import com.google.android.material.tabs.TabLayoutMediator
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import woojin.projects.mediasearchapplication.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val searchFragment = SearchFragment()
    private val fragmentList = listOf(searchFragment, FavoriteFragment())
    private val viewPagerAdapter = ViewPagerAdapter(this, fragmentList)

    //rx같은경우는 activity 해제될때 같이 해제해줘야함 null 처리
    private var observableTextQuery: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

    }

    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@MainActivity
            viewPager.adapter = viewPagerAdapter

            TabLayoutMediator(tabLayout, viewPager) { tab, positon ->
                tab.text = if (fragmentList[positon] is SearchFragment) {
                    "검색 결과"
                } else {
                    "즐겨 찾기"
                }
            }.attach()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        observableTextQuery = Observable.create { emitter: ObservableEmitter<String>? ->
            //searchView = menu.findItem(R.id.search).actionView as SearchView
            //searchView.setOnQueryTextListener(...)
            (menu.findItem(R.id.search).actionView as SearchView).apply {
                setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String): Boolean {
                        //입력하고 search버튼을 누를때. 실행
                        emitter?.onNext(query)
                        return false
                    }

                    override fun onQueryTextChange(newText: String): Boolean {
                        //searchText가 변경될때마다
                        binding.viewPager.setCurrentItem(0, true)
                        emitter?.onNext(newText)
                        return false
                    }
                })
            }
        }.debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                searchFragment.searchKeyword(it)
            }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        observableTextQuery?.dispose()
        observableTextQuery = null
    }
}