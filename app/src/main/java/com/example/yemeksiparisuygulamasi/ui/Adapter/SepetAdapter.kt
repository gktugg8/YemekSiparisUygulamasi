package com.example.yemeksiparisuygulamasi.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparisuygulamasi.databinding.SepetTasarimBinding
import com.example.yemeksiparisuygulamasi.data.entity.SepetYemek
import com.google.android.material.snackbar.Snackbar

class SepetAdapter(var mContext:Context,var sepetListesi:List<SepetYemek>)
    :RecyclerView.Adapter<SepetAdapter.SepetTasarimTutucu>() {
    inner class SepetTasarimTutucu(tasarim:SepetTasarimBinding):RecyclerView.ViewHolder(tasarim.root) {

        var tasarim: SepetTasarimBinding

        init {
            this.tasarim = tasarim

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetTasarimTutucu {
       val layoutInflater =LayoutInflater.from(mContext)
        val tasarim =SepetTasarimBinding.inflate(layoutInflater,parent,false)
        return SepetTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: SepetTasarimTutucu, position: Int) {
        val sepet =sepetListesi.get(position)
        val t =holder.tasarim
        t.imageViewSepet.setImageResource(mContext.resources.getIdentifier(sepet.yemek_resim_adi,"drawable",mContext.packageName))
        t.textViewSepetYemekAdi.text ="${sepet.yemek_adi}"
        t.textViewSepetAdet.text="${sepet.yemek_siparis_adet}"
        t.buttonSepetSil.setOnClickListener {
            Snackbar.make(it,"${sepet.yemek_adi} Silindi.",Snackbar.LENGTH_LONG).show()
        }

    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }

}


