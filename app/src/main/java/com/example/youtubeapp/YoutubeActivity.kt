package com.example.youtubeapp
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

const val YOUTUBE_VIDEO_ID = "HhjHYkPQ8F0"
const val YOUTUBE_PLAYLIST_ID = "PLrxXqHDadmdcBen3zGdAWiGSVOcS0JfMK"

class YoutubeActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    val TAG = "YOUuuuu"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)
        val layout = findViewById<ConstraintLayout>(R.id.youTubePlayer)

        val videoPlayerView = YouTubePlayerView(this)
        videoPlayerView.layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        layout.addView(videoPlayerView)

        videoPlayerView.initialize(getString(R.string.GOOGLE_API_KEY) , this)
    }


    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        youTubePlayer: YouTubePlayer?,
        wasRestored: Boolean
    ) {
       if(!wasRestored){
           youTubePlayer?.cueVideo(YOUTUBE_VIDEO_ID)
       }

    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        val REQUEST_CODE = 0
        if (p1?.isUserRecoverableError == true){
            p1.getErrorDialog(this, REQUEST_CODE).show()
        }else{
            val errorMsg = "yalahwyyyyyyyy"
            Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
        }
    }
    private val playBackListener = object : YouTubePlayer.PlaybackEventListener{
        override fun onPlaying() {
            TODO("Not yet implemented")
        }

        override fun onPaused() {
            TODO("Not yet implemented")
        }

        override fun onStopped() {
            TODO("Not yet implemented")
        }

        override fun onBuffering(p0: Boolean) {
            TODO("Not yet implemented")
        }

        override fun onSeekTo(p0: Int) {
            TODO("Not yet implemented")
        }
    }
}