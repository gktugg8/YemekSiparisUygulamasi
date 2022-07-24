package com.example.yemeksiparisuygulamasi.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.data.entity.Yemekler
import com.example.yemeksiparisuygulamasi.databinding.CardTasarimBinding
import com.example.yemeksiparisuygulamasi.ui.fragment.AnaSayfaFragmentDirections

class YemeklerAdapter(var mContext:Context,var yemeklerListesi:List<Yemekler>)
    :RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding

        init{

            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater =LayoutInflater.from(mContext)
        val tasarim =CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
       val yemek =yemeklerListesi.get(position)
        val t =holder.tasarim
        t.imageViewYemekResim.setImageResource(mContext.resources.getIdentifier(yemek.yemek_resim_adi,"drawable",mContext.packageName))
        t.textViewYemekAdi.text =yemek.yemek_adi
        t.textViewFiyat.text ="${yemek.yemek_fiyat}₺"
        t.buttonCardSepeteEkle.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sepetGecis)
        }

       t.cardViewYemek.setOnClickListener {
           val gecis = AnaSayfaFragmentDirections.detayGecis(yemekDetay = yemek)
           Navigation.findNavController(it).navigate(gecis)
       }

    }

    override fun getItemCount(): Int {
       return yemeklerListesi.size
    }


}