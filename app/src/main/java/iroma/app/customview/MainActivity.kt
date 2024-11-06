package iroma.app.customview

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val emojiView = findViewById<View>(R.id.emotionalFaceView)
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Я очень рад!"
        emojiView.setOnClickListener{
            happinessState = when (happinessState) {
                EmojiState.HAPPY -> EmojiState.NORMAL
                EmojiState.NORMAL -> EmojiState.SAD
                EmojiState.SAD -> EmojiState.HAPPY
            }
            when (happinessState) {
                EmojiState.HAPPY -> textView.text = "Я очень рад!"
                EmojiState.NORMAL -> textView.text = "У меня все нормально"
                EmojiState.SAD -> textView.text = "Я грущу..."
            }
        }
    }
    companion object {
        var happinessState: EmojiState = EmojiState.HAPPY
    }
}