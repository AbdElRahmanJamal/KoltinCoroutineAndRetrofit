package com.m.koltincoroutineandretrofit.home.presenration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.m.koltincoroutineandretrofit.R
import com.m.koltincoroutineandretrofit.home.HomePageDataStore
import com.m.koltincoroutineandretrofit.home.HomePageRepository
import com.m.koltincoroutineandretrofit.preferencesGateway
import kotlinx.android.synthetic.main.home_page_fragment.*
import org.koin.android.ext.android.get

class HomePage : Fragment() {

    private lateinit var viewModel: HomePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = HomePageViewModelFactory(HomePageRepository(HomePageDataStore(get())))
        viewModel = ViewModelProviders.of(this, factory).get(HomePageViewModel::class.java)
        viewModel.getMarvelCharactersAsync(10, 0).observeForever {
            lottie_loading.visibility = View.GONE
        }

    }

}
