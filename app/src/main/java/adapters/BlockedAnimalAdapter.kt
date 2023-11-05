package adapters

import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.colina.animal.names.R
import data_models.AnimalDetails

class BlockedAnimalAdapter(private val blockedList: List<AnimalDetails>, private val unblockClickListener: UnblockClickListener) : BaseAdapter() {

    interface UnblockClickListener {
        fun onUnblockClick(animal: AnimalDetails)
    }

    override fun getCount(): Int = blockedList.size

    override fun getItem(position: Int): Any = blockedList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(parent.context).inflate(R.layout.animal_blocked, parent, false)

        val animalName = view.findViewById<TextView>(R.id.animalName)
        val blockedAnimal = blockedList[position]
        animalName.text = blockedAnimal.animalName

        val unblockText = view.findViewById<TextView>(R.id.unblockLink)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                unblockClickListener.onUnblockClick(blockedAnimal) //unblock animal when link is clicked
            }
        }

        val spannableString = SpannableString(unblockText.text)
        spannableString.setSpan(clickableSpan, 0, unblockText.length(), 0)

        unblockText.text = spannableString
        unblockText.movementMethod = LinkMovementMethod.getInstance()

        return view
    }
}
