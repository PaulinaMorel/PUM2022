package pl.edu.uwr.lista3v3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import pl.edu.uwr.lista3v3.databinding.FragmentAddBinding
import pl.edu.uwr.lista3v3.databinding.FragmentDetalBinding


class DetalFragment : Fragment() {
    private val dbHandler by lazy {
        DBHandler(requireContext())
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_detal, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val numlist = requireArguments().getInt("valNum")
            view.findViewById<ViewPager2>(R.id.viewPager).apply {
                adapter = PagerAdapter(dbHandler,numlist)
                println("jasne")
            }

            var button = view.findViewById<Button>(R.id.button4)
            button.setOnClickListener {
                view.findNavController().navigate(
                    DetalFragmentDirections.actionDetalFragmentToFragmentAdd(
                        valNum = numlist

                    )
                )
            }

            var button1 = view.findViewById<Button>(R.id.button_photos)
            button1.setOnClickListener {
                view.findNavController().navigate(
                    DetalFragmentDirections.actionDetalFragmentToFragmentGalery(
                        valNum = numlist

                    )
                )
            }
        }

}