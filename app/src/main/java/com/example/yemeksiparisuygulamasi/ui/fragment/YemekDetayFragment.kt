package com.example.yemeksiparisuygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.databinding.FragmentYemekDetayBinding

class YemekDetayFragment : Fragment() {
    private lateinit var tasarim:FragmentYemekDetayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim=FragmentYemekDetayBinding.inflate(inflater, container, false)
         val bundle:YemekDetayFragmentArgs by navArgs()
        val gelenYemek =bundle.yemekDetay


        tasarim.toolbarDetay.title=gelenYemek.yemek_adi
        tasarim.imageViewResim.setImageResource(resources.getIdentifier(gelenYemek.yemek_resim_adi,"drawable",requireContext().packageName))

        tasarim.textViewAdet.text=tasarim.slider.progress.toString()
        tasarim.slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tasarim.textViewAdet.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        tasarim.textViewFiyatDetay.text = "${gelenYemek.yemek_fiyat}₺"
        tasarim.buttonDetaySepeteEkle.setOnClickListener {
           Navigation.findNavController(it).navigate(R.id.sepeteEkleGecis)
        }




        return tasarim.root
    }


}