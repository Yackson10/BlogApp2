package com.example.blogapp2.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.blogapp2.R
import com.example.blogapp2.core.Resource
import com.example.blogapp2.data.remote.home.HomeScreenDataSource
import com.example.blogapp2.databinding.FragmentHomeScreenBinding
import com.example.blogapp2.domain.home.HomeScreenRepoImpl
import com.example.blogapp2.presentation.main.HomeScreenViewModel
import com.example.blogapp2.presentation.main.HomeScreenViewModelFactory
import com.example.blogapp2.ui.main.adapter.HomeScreenAdapter


class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding
    private val viewModel by viewModels<HomeScreenViewModel> {
        HomeScreenViewModelFactory(HomeScreenRepoImpl(HomeScreenDataSource()))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        viewModel.fetchLatestPosts().observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvHome.adapter = HomeScreenAdapter(it.data)
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(),"Ocurrio un error ${it.exception}", Toast.LENGTH_SHORT).show()
                }
            }

        })



//        val postList = listOf(
//            Post("https://omargamboa.com/wp-content/uploads/2020/10/omargamboa-pikachu.jpg","picachu", Timestamp.now(), "https://cdn.alfabetajuega.com/alfabetajuega/abj_public_files/multimedia/imagenes/alfabetajuega-pm-1-090518.jpg"),
//            Post("https://assets.stickpng.com/images/580b57fcd9996e24bc43c32a.png","escuartule", Timestamp.now(), "https://i.pinimg.com/736x/6b/cf/0d/6bcf0d88ac78f51676ed50f6ae0b1b70.jpg"),
//            Post("https://i.pinimg.com/originals/cd/69/3e/cd693e769495d644302de8592fcae7d0.gif","charmander", Timestamp.now(), "https://static0.gamerantimages.com/wordpress/wp-content/uploads/2022/09/Pokemon-Fan-Artist-Gives-Charmander-Evolution-Line-a-Halloween-Inspired-Makeover.jpg"),
//            Post("https://i.pinimg.com/originals/3b/78/47/3b7847675982776e5219e12a680ecd84.png","bolbasory", Timestamp.now(), "https://i.pinimg.com/736x/e5/ed/cb/e5edcb3d1e96c3e0a2aa5646bbe9c87e.jpg")
//            )

        //binding.rvHome.adapter = HomeScreenAdapter(postList)

    }


    //https://www.movilzona.es/app/uploads-movilzona.es/2022/05/fondos-de-pantalla-pokemon.jpg

    //linearMensajeEmergente.background = ContextCompat.getDrawable(this@SinisterFollowActivity, R.drawable.border_sinister_style_alert)

}