package com.example.yemeksiparisuygulamasi.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.yemeksiparisuygulamasi.ui.Adapter.YemeklerAdapter
import com.example.yemeksiparisuygulamasi.databinding.FragmentAnaSayfaBinding
import com.example.yemeksiparisuygulamasi.data.entity.Yemekler
import com.example.yemeksiparisuygulamasi.R


class AnaSayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim:FragmentAnaSayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      tasarim =FragmentAnaSayfaBinding.inflate(inflater, container, false)

         tasarim.toolbarAnaSayfa.title="YemekSiparisiUygulaması"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnaSayfa)


        tasarim.rv.layoutManager =StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val yemeklerListesi =ArrayList<Yemekler>()
        val y1= Yemekler(1,"Kofte","kofte",45.88)
        val y2= Yemekler(2,"Izgara Somon","izgarasomon",32.50)
        val y3= Yemekler(3,"Lazanya","lazanya",40.99)
        val y4= Yemekler(4,"Izgara Tavuk","izgaratavuk",35.50)
        val y5= Yemekler(5,"Makarna","makarna",25.00)
        val y6= Yemekler(6,"Baklava","baklava",20.00)
        val y7= Yemekler(7,"Pizza","pizza",55.00)
        val y8= Yemekler(8,"Ayran","ayran",5.00)
        val y9= Yemekler(9,"Fanta","fanta",8.00)
        val y10= Yemekler(10,"Sütlaç","sutlac",15.00)
        val y11= Yemekler(11,"Tiramisu","tiramisu",15.00)
        val y12= Yemekler(12,"Kahve","kahve",17.00)
        val y13= Yemekler(13,"Su","su",3.00)
        val y14= Yemekler(13,"Kadayif","kadayif",25.00)
        yemeklerListesi.add(y1)
        yemeklerListesi.add(y2)
        yemeklerListesi.add(y3)
        yemeklerListesi.add(y4)
        yemeklerListesi.add(y5)
        yemeklerListesi.add(y6)
        yemeklerListesi.add(y7)
        yemeklerListesi.add(y8)
        yemeklerListesi.add(y9)
        yemeklerListesi.add(y10)
        yemeklerListesi.add(y11)
        yemeklerListesi.add(y12)
        yemeklerListesi.add(y13)
        yemeklerListesi.add(y14)


        val adapter =YemeklerAdapter(requireContext(),yemeklerListesi)
        tasarim.rv.adapter =adapter

         tasarim.fab.setOnClickListener {
           Navigation.findNavController(it).navigate(R.id.sepetGecis)
         }


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbarmenu,menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
       ara(query)
        return  true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true
    }


    fun ara(aramaKelimesi:String){

    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_ara ->{
                Log.e("Kişi","ara tıklandı")

            }
            R.id.action_cikis ->{
                Log.e("Kişi","Cıkıs")
            }
            else -> return super.onOptionsItemSelected(item)

        }
        return super.onOptionsItemSelected(item)
    }*/

}