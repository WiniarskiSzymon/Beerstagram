package com.projects.bigswierku.beerstagram.View


import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.projects.bigswierku.beerstagram.R
import kotlinx.android.synthetic.main.log_in.*
import kotlinx.android.synthetic.main.log_in.view.*
import kotlinx.android.synthetic.main.oauth_web_viee.*

class LogInFragment :Fragment(){

    private val clientID = "7BA7E574D1C0CEFCEB7FDAB198D5A68F402FC9A8"
    private val redirectURL = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        val view =  inflater.inflate(R.layout.log_in, container, false)
        view.log_in_button.setOnClickListener {
            logIn(clientID,redirectURL)
        }

        return view

    }

    private fun logIn(clientID: String, redirectURL : String) {
        val uri = with(Uri.Builder()) {
            path("https://untappd.com/oauth/authenticate/")
            //appendQueryParameter("client_id", clientID)
            //appendQueryParameter("response_type", "code")
            //appendQueryParameter("redirect_url", redirectURL)
            build()
        }
        //oauth_webview.loadUrl(uri.toString())

        val intent  = Intent(ACTION_VIEW, uri)
        startActivity(intent)
    }

    companion object {
        fun newInstance(): LogInFragment = LogInFragment()
    }

}