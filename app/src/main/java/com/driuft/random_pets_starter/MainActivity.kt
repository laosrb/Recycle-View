package com.driuft.random_pets_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    private lateinit var contactList: MutableList<String>
    private lateinit var rvContact: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvContact = findViewById(R.id.contact_list)
        contactList = mutableListOf()
//        val sampleNames = listOf<String>("Alice", "Bob", "Eva", )



        getDogImageURL()
    }

    private fun getDogImageURL() {
        val client = AsyncHttpClient()

        client["https://dog.ceo/api/breeds/image/random/20", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Contact Success", "$json")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Contact Error", errorResponse)
            }
        }]
    }
}