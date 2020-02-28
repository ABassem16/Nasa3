package com.example.nasa2
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var listView_details: ListView
    var arrayList_details:ArrayList<Model> = ArrayList();
    //OkHttpClient creates connection pool between client and server
    val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView_details = findViewById<ListView>(R.id.listView) as ListView
        run("https://api.nasa.gov/planetary/apod?api_key=jTcWV0pmMmG6SOjwIGacrJLlDm1Vj5fmZsO0TBMP")
    }

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                var str_response = response.body()!!.string()
                //creating json object
                val json_contact:JSONObject = JSONObject(str_response)
                //creating json array
                var jsonarray_info:JSONArray= json_contact.getJSONArray("info")
                var i:Int = 0
                var size:Int = jsonarray_info.length()
                arrayList_details= ArrayList();
                for (i in 0.. size-1) {
                    var json_objectdetail:JSONObject=jsonarray_info.getJSONObject(i)
                    var model:Model= Model();
                    model.explanation=json_objectdetail.getString("explanation")
                    model.serviceVersion=json_objectdetail.getString("serviceVersion")
                    model.mediaType=json_objectdetail.getString("mediaType")
                    model.copyright=json_objectdetail.getString("copyright")
                    model.date=json_objectdetail.getString("date")
                    model.hdurl=json_objectdetail.getString("hdurl")
                    model.title=json_objectdetail.getString("title")
                    model.url=json_objectdetail.getString("url")
                    arrayList_details.add(model)
                }

                runOnUiThread {
                    //stuff that updates ui
                    val obj_adapter : CustomAdapter
                    obj_adapter = CustomAdapter(applicationContext,arrayList_details)
                    listView_details.adapter=obj_adapter
                }
            }
        })
    }
}