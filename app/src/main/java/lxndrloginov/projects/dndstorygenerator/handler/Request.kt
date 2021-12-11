package lxndrloginov.projects.dndstorygenerator.handler

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import org.jetbrains.annotations.NotNull
import java.io.File
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.TimeUnit

const val URL_HANDLER  = "http://192.168.1.100"
const val PORT_HANDLER = "1488"
const val REQUEST_HANDLER = "/generate"
const val INPUTS_HANDLER = "inputs"
val CACHE_DIRECTORY = File("G:\\Programming\\dnd-story-generator-app\\app\\cache")

class RequestHandler {
    var outputs = mutableListOf<String>()
    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .callTimeout(10, TimeUnit.SECONDS)
        .cache(Cache(
            directory = CACHE_DIRECTORY,
            maxSize = 10L * 1024L * 1024L // 10 MiB
        ))
        .build()


    @DelicateCoroutinesApi
    @Override
    fun run(inputs: String): String {
        var output_string = ""
        val request = Request.Builder()
            .url("$URL_HANDLER:$PORT_HANDLER$REQUEST_HANDLER?$INPUTS_HANDLER=$inputs")
            .build()

        println("Request:          $request")
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    println("Response response:          $it")
                    println("Response cache response:    ${it.cacheResponse}")
                    println("Response network response:  ${it.networkResponse}")

                    output_string = response.body!!.string()
                    outputs.add(output_string)
                }
            }
        })
        return output_string
    }
}


/*
class Request {
    fun sendRequest(inputs: String): String {
        val url = URL("$URL_HANDLER:$PORT_HANDLER$ROUTE_HANDLER")
        var outputs = ""

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"  // optional default is GET

            inputStream.bufferedReader().use {
                it.lines().forEach { line ->
                    outputs = line
                }
            }
        }
        return outputs
    }
}*/