package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.colina.animal.names.R
import data_models.AnimalDetails

class AnimalAdapter(private val animalList: List<AnimalDetails>) : BaseAdapter() {

    override fun getCount(): Int = animalList.size

    override fun getItem(position: Int): Any = animalList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(parent.context).inflate(R.layout.animal_names, parent, false)

        val animalName = view.findViewById<TextView>(R.id.animalName)

        val name = animalList[position]
        animalName.text = name.animalName

        return view
    }
}