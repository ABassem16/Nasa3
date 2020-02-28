package com.example.nasa2
public class Model {
    lateinit var copyright: String
    lateinit var date: String
    lateinit var explanation: String
    lateinit var hdurl: String
    lateinit var mediaType: String
    lateinit var serviceVersion: String
    lateinit var title: String
    lateinit var url: String

    constructor(
        copyright: String,
        date: String,
        explanation: String,
        hdurl: String,
        mediaType: String,
        serviceVersion: String,
        title: String,
        url: String
    ) {
        this.copyright = copyright
        this.date = date
        this.hdurl = hdurl
        this.explanation = explanation
        this.mediaType = mediaType
        this.serviceVersion = serviceVersion
        this.title = title
        this.url = url
    }
    constructor()
}