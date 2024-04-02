package com.driuft.random_pets_starter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views

class ContactsAdapter (private val mContacts: List<String>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Parcelable {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nameTextView = itemView.findViewById<TextView>(R.id.textView)
        val nameImageView = itemView.findViewById<ImageView>(R.id.ContactImage)



        fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.Contact_item, parent, false)
        return ViewHolder(view)
    }



        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<ViewHolder> {
            override fun createFromParcel(parcel: Parcel): ViewHolder {
                return ViewHolder(parcel)
            }

            override fun newArray(size: Int): Array<ViewHolder?> {
                return arrayOfNulls(size)
            }
        }

        fun onBindViewHolder(holder: ContactsAdapter.ViewHolder, position: Int) {
        // item is recycled
        Glide.with(holder.itemView)
            .load(ContactList[position])
            .centerCrop()
            .into(holder.Button)
        // `holder` can used to reference any View within the RecyclerView item's layout file
        holder.Button.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Contact at position$position clicked", Toast.LENGTH_SHORT).show()

    }

    fun getItemCount(): Int {
        return mContacts.size
    }
}




