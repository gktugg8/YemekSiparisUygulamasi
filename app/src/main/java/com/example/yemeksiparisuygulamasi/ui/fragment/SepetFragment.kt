package com.example.yemeksiparisuygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksiparisuygulamasi.ui.Adapter.SepetAdapter
import com.example.yemeksiparisuygulamasi.databinding.FragmentSepetBinding
import com.example.yemeksiparisuygulamasi.data.entity.SepetYemek


class SepetFragment : Fragment() {
    private lateinit var tasarim:FragmentSepetBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentSepetBinding.inflate(inflater, container, false)

        tasarim.toolbarSepet.title="Sepet"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarSepet)
        tasarim.rvSepet.layoutManager=LinearLayoutManager(requireContext())

        val sepetListesi = ArrayList<SepetYemek>()
        val s1=SepetYemek(1,"Köfte","kofte",35,5,"ahmet")

        sepetListesi.add(s1)

        val adapter =SepetAdapter(requireContext(),sepetListesi)
        tasarim.rvSepet.adapter =adapter
        return tasarim.root
    }


}