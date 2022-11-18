package pl.edu.uwr.lista2

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.lista2.AdapterFragmentA.FragmentAViewHolder

class AdapterFragmentA : RecyclerView.Adapter<FragmentAViewHolder>(){
    val list_crime = pl.edu.uwr.lista2.List.list

    inner class FragmentAViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textId: TextView = itemView.findViewById(R.id.case_id_list)
        val detalId: TextView = itemView.findViewById(R.id.casedetal)
        val detalsId: TextView = itemView.findViewById(R.id.casedetals)
        val imageId: ImageView = itemView.findViewById(R.id.image)
        fun goto(item: CrimeList) {
            textId.text = "Case #" + item.id.toString()
            detalId.text = item.name
            detalsId.text = item.date
            if (item.solve=="Solve"){
                imageId.setImageResource(R.drawable.solved)
            }else if(item.solve=="In Progress"){
                imageId.setImageResource(R.drawable.inprogress)
            }else{
                imageId.setImageResource(R.drawable.unsolved)
            }
        }
    }
    override fun getItemCount(): Int = list_crime.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentAViewHolder {
        return FragmentAViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FragmentAViewHolder, position: Int) {
        val item = list_crime[position]
        holder.goto(item)
        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(
                FragmentADirections.actionFragmentAToFragmentB(
                    moduleId = item.id
                )
            )
        }
    }}
