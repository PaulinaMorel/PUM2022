package pl.edu.uwr.lista3
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import pl.edu.uwr.lista3.databinding.FragmentBBinding

private lateinit var binding: FragmentBBinding


class BFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // val databasehandler = DataBase(requireContext())
        binding.button5.setOnClickListener {
            println("ALOHA")
            view.findNavController().navigate(
                BFragmentDirections.actionBFragmentToAfragment()
            )
        }
    }
   // findViewById<ViewPager2>(R.id.viewPager).apply {
       // adapter = PagerAdapter()

}