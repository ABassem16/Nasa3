package com.example.nasa2
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView

class CustomAdapter(context: Context,arrayListDetails:ArrayList<Model>) : BaseAdapter(){

    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<Model>

    init {
        this.layoutInflater = LayoutInflater.from(context)
        this.arrayListDetails=arrayListDetails
    }

    override fun getCount(): Int {
        return arrayListDetails.size
    }

    override fun getItem(position: Int): Any {
        return arrayListDetails.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val listRowHolder: ListRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.adapter_layout, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }

        listRowHolder.tvCopyright.text = arrayListDetails.get(position).copyright
        listRowHolder.tvDate.text = arrayListDetails.get(position).date
        listRowHolder.tvExplanation.text = arrayListDetails.get(position).explanation
        listRowHolder.tvHdURL.text = arrayListDetails.get(position).hdurl
        listRowHolder.tvMediaType.text = arrayListDetails.get(position).mediaType
        listRowHolder.tvServiceVersion.text = arrayListDetails.get(position).serviceVersion
        listRowHolder.tvTitle.text = arrayListDetails.get(position).title
        listRowHolder.tvURL.text = arrayListDetails.get(position).url
        return view
    }
}

private class ListRowHolder(row: View?) {
    public val tvCopyright: TextView
    public val tvDate: TextView
    public val tvExplanation: TextView
    public val tvHdURL: TextView
    public val tvMediaType: TextView
    public val tvServiceVersion: TextView
    public val tvTitle: TextView
    public val tvURL: TextView
    public val linearLayout: LinearLayout

    init {
        this.tvCopyright= row?.findViewById<TextView>(R.id.tvCopyright) as TextView
        this.tvDate = row?.findViewById<TextView>(R.id.tvDate) as TextView
        this.tvExplanation = row?.findViewById<TextView>(R.id.tvExplanation) as TextView
        this.tvHdURL= row?.findViewById<TextView>(R.id.tvHdURL) as TextView
        this.tvMediaType= row?.findViewById<TextView>(R.id.tvMediaType) as TextView
        this.tvServiceVersion= row?.findViewById<TextView>(R.id.tvServiceVersion) as TextView
        this.tvTitle= row?.findViewById<TextView>(R.id.tvTitle) as TextView
        this.tvURL= row?.findViewById<TextView>(R.id.tvURL) as TextView
        this.linearLayout = row?.findViewById<LinearLayout>(R.id.linearLayout) as LinearLayout
    }
}