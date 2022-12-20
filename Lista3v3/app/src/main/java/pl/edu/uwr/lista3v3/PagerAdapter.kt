package pl.edu.uwr.lista3v3

import  pl.edu.uwr.lista3v3.MainActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.lista3v3.databinding.DetalViewBinding

class PagerAdapter (private val dbHandler: DBHandler, private val number: Int): RecyclerView.Adapter<PagerAdapter.ViewHolder>() {
//private lateinit var binding: DetalViewBinding
    class ViewHolder(private var itemBinding: DetalViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val del = itemBinding.DELETE
        val edit = itemBinding.EDIT
        fun bind(text: TabelaList){
            println(text)
            itemBinding.textView.text = text.opis
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = DetalViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(dbHandler.getElement(number)[position])
        holder.del.setOnClickListener {
            dbHandler.deleteElement(dbHandler.getElement(number)[position].id)
            notifyDataSetChanged()
        }
        holder.edit.setOnClickListener {
            holder.itemView.findNavController().navigate(
                DetalFragmentDirections.actionDetalFragmentToFragmentEdit(
                valId = dbHandler.getElement(number)[position].id
                )
            )
        }
    }

    override fun getItemCount(): Int{
        return dbHandler.getElement(number).size
    }
}