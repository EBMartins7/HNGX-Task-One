package com.mbabalola.hngtaskone.screens

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController


@Composable
fun GithubScreen(navController: NavController) {
    WebViewPage(url = "https://github.com/EBMartins7")
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewPage(url: String) {

    var backEnabled by remember { mutableStateOf(false) }
    var webView: WebView? = null

    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()

            settings.javaScriptEnabled = true

            webViewClient = object : WebViewClient() {

                override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
                    backEnabled = view.canGoBack()
                }
            }

            loadUrl(url)
            webView = this
        }
    }, update = {
        webView = it
    })
    
    BackHandler(enabled = backEnabled) {
        webView?.goBack()
    }
}