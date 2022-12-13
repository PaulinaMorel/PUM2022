package pl.edu.uwr.lista3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import pl.edu.uwr.lista3.databinding.FragmentABinding

private lateinit var binding: FragmentABinding

class add_fragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val databasehandler = DataBase(requireContext())
        binding.button.setOnClickListener {
            val Points = binding.editTextNumberSigned.text.toString()
            val Task = binding.editTextTextPersonName.text.toString()
            if(Points.isNotEmpty()&& Task.isNotEmpty()){
                databasehandler.addRec(Task, Points.toInt())
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

}