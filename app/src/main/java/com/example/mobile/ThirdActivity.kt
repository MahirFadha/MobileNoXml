package com.example.mobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import android.graphics.Typeface
import android.view.Gravity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.mobile.ui.theme.MobileTheme

class ThirdActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileTheme {
                Privasi()
            }
        }
    }
}

@Composable
fun Privasi(){
    AndroidView(
        factory = {context ->
            val layout = ConstraintLayout(context).apply {
                setBackgroundColor(ContextCompat.getColor(context, R.color.black))
                layoutParams = LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT
                )
            }

            val btnBack = Button(context).apply {
                id = View.generateViewId()
                setBackgroundResource(R.drawable.baseline_arrow_back_24)
                layoutParams = LayoutParams(
                    90,
                    90
                )
            }

            btnBack.setOnClickListener{
                val back = Intent(context, SecondActivity::class.java)
                context.startActivity(back)
            }

            val textprivasi = TextView(context).apply{
                id = View.generateViewId()
                text = "Privacy"
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
                textSize = 32f
            }

            val textduwa = TextView(context).apply {
                id = View.generateViewId()
                text ="Your Privacy can be different on Threads and Instagram. Leran More"
                textAlignment = View.TEXT_ALIGNMENT_CENTER
                setTextColor(ContextCompat.getColor(context,R.color.lightgray))
                layoutParams = LayoutParams(800,90)
            }


            layout.addView(btnBack)
            layout.addView(textprivasi)
            layout.addView(textduwa)

            val constraintSet = ConstraintSet()
            constraintSet.clone(layout)

            constraintSet.connect(btnBack.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,60)
            constraintSet.connect(btnBack.id, ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP, 60)

            constraintSet.connect(textprivasi.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 200)
            constraintSet.connect(textprivasi.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(textprivasi.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            constraintSet.connect(textduwa.id, ConstraintSet.TOP, textprivasi.id, ConstraintSet.BOTTOM,20)
            constraintSet.connect(textduwa.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(textduwa.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            constraintSet.applyTo(layout)
            layout
        }
    ){}
}

@Preview(showBackground = true)
@Composable
fun PreviewPrivasi(){
    MobileTheme {
        Privasi()
    }
}