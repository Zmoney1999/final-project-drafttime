import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.connectedweather.R
import com.example.drafttime.data.PlayerInfo
import kotlin.random.Random


class CustomAdapter(val playerdata: List<List<PlayerInfo>>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.team_list_view, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return playerdata.size
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.playerdata[position])

        // sets the image to the imageview from our itemHolder class


    }

    // return the number of the items in the list

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {






        val pName: TextView= itemView.findViewById(R.id.name)
        val pAge: TextView = itemView.findViewById(R.id.age)
        var pPosition : TextView = itemView.findViewById(R.id.position)
        val pTeam: TextView = itemView.findViewById(R.id.team_name)
        val optionMenu: Button = itemView.findViewById(R.id.textViewOptions)
        var playerItem: PlayerInfo? = null

        ///Handle clicks from the user

        init {
            optionMenu.setOnClickListener {

              val popupMenu = PopupMenu(itemView.context, it)
                val inflater = popupMenu.menuInflater
                popupMenu.inflate(R.menu.options_menu)

                //Log.d("ViewHolder" , "Clicked")
                popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {item: MenuItem? ->
                    when(item!!.itemId){
                        R.id.menu1->
                            println("Clicked menu 1")
                        R.id.menu2->
                            println("Clicked Menu 2")
                        R.id.menu3->
                            println("Clicked menu 3")

                    }
                    true


                })
                popupMenu.show()

                }

            }


        private fun showPopup(itemView: View) {


        }

        fun bind(playerInfo: List<PlayerInfo>) {
            val value = Random.nextInt(0,10)

            pName.text = playerInfo[value].fullName
            pAge.text = playerInfo[value].age
            pPosition.text = playerInfo[value].postion
            pTeam.text = playerInfo[value].team



        }
    }
}
