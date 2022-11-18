package pl.edu.uwr.lista2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentA : Fragment() {

    private lateinit var adapter: AdapterFragmentA
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?){
    super.onViewCreated(itemView, savedInstanceState)
        val recyclerView = itemView.findViewById<RecyclerView>(R.id.letterRecyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = AdapterFragmentA()}}

}