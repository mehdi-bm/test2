package com.example.test2.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.Tricks.ViewPagerEx
import com.example.test2.databinding.ActivitySliderViewBinding

class SliderViewActivity : AppCompatActivity(),BaseSliderView.OnSliderClickListener,ViewPagerEx.OnPageChangeListener {
    private val data= listOf(
        "http://www.coca.ir/wp-content/uploads/2017/02/nature-photos-2.jpg",
        "http://www.coca.ir/wp-content/uploads/2017/02/nature-photos-3.jpg",
        "http://www.coca.ir/wp-content/uploads/2014/02/beautiful-winter-photos-1.jpg",
        "http://www.coca.ir/wp-content/uploads/2013/05/tuscany-italy-photos-1.jpg"
    )
    private lateinit var binding: ActivitySliderViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySliderViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSlider()
    }

    private fun setupSlider() {
        for (item in 0 until data.count()){
            val textSliderView=TextSliderView(this)
                .description("slide ${item+1}")
                .image(data[item])

            binding.slider.addSlider(textSliderView)
        }
    }

    override fun onStop() {
        binding.slider.stopAutoCycle()
        super.onStop()
    }

    override fun onSliderClick(slider: BaseSliderView?) {
        TODO("Not yet implemented")
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        TODO("Not yet implemented")
    }

    override fun onPageSelected(position: Int) {
        TODO("Not yet implemented")
    }

    override fun onPageScrollStateChanged(state: Int) {
        TODO("Not yet implemented")
    }
}