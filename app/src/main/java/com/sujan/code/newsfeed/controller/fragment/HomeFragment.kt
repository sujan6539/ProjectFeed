package com.sujan.code.newsfeed.controller.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.sujan.code.newsfeed.R
import com.sujan.code.newsfeed.baseobservable.HomeFragmentBaseObservable
import com.sujan.code.newsfeed.baseobservable.ItemNewsFeedBaseObservable
import com.sujan.code.newsfeed.baseobservable.callbacks.FeedActionCallback
import com.sujan.code.newsfeed.controller.activity.HomeActivity
import com.sujan.code.newsfeed.databinding.FragmentHomeBinding
import com.sujan.code.newsfeed.utils.AndroidUtils

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var homeFragmentBaseObservable : HomeFragmentBaseObservable? = null

    val callback = object : FeedActionCallback {
        override fun onFeedClick(observable: ItemNewsFeedBaseObservable) {
            AndroidUtils.showToast(activity, "Clicked", Toast.LENGTH_SHORT)
        }
    }

    private val refreshListener = OnRefreshListener {
        (activity as? HomeActivity)?.run {
            repository.fetchNews()
            homeFragmentBaseObservable?.refreshing = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home, container, false)
        val fragmentHomeBinding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        fragmentHomeBinding.swipeRefreshCallback = refreshListener
        homeFragmentBaseObservable = HomeFragmentBaseObservable(callback)
        (activity as? HomeActivity)?.run {
            repository.topStoriesLiveData.observe(viewLifecycleOwner) { topStorieslist ->
                topStorieslist.forEach {
                    homeFragmentBaseObservable?.addItems(
                        ItemNewsFeedBaseObservable(
                            header = it.title,
                            description = it.abstract,
                            image = it.multimedia.firstOrNull()?.url ?: ""
                        )
                    )
                }
            }
        }
        fragmentHomeBinding.data = homeFragmentBaseObservable
        return fragmentHomeBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}