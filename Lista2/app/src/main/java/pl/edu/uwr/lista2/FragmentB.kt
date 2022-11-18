package pl.edu.uwr.lista2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentB : Fragment() {
 private val module by lazy{
     val moduleId = arguments?.getInt("moduleId")
         ?:throw IllegalArgumentException("moduleId doesn't exist")
     List.list[moduleId-2001]

 }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.name).text = module.name
        view.findViewById<TextView>(R.id.caseId).text = module.id.toString()
        view.findViewById<TextView>(R.id.date).text = module.date
        view.findViewById<TextView>(R.id.solve).text = module.solve


    }
}