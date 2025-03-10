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
import android.widget.ImageView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.mobile.ui.theme.MobileTheme

class SecondActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileTheme {
                IsiProfil()
            }
        }
    }
}

@Composable
fun IsiProfil() {
    AndroidView(
        factory = { context ->
            val layout = ConstraintLayout(context).apply {
                setBackgroundColor(ContextCompat.getColor(context,R.color.black))
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
                val back = Intent(context, MainActivity::class.java)
                context.startActivity(back)
            }

            val btnNext = Button(context).apply{
                id = View.generateViewId()
                setBackgroundResource(R.drawable.baseline_arrow_forward_24)
                layoutParams = LayoutParams(
                    90,
                    90
                )
            }

            btnNext.setOnClickListener{
                val next = Intent(context, ThirdActivity::class.java)
                context.startActivity(next)
            }

            val header = TextView(context).apply {
                id = View.generateViewId()
                text ="Profile"
                setTypeface(null,Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context,R.color.white))
                textSize = 32f
            }

            val textduwa = TextView(context).apply {
                id = View.generateViewId()
                text ="Customize your Threads profile"
                setTextColor(ContextCompat.getColor(context,R.color.lightgray))
            }

            val bgProfil = ImageView(context).apply{
                id = View.generateViewId()
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bg_profil))
                layoutParams = LayoutParams(900,740)
            }

            val profil = TextView(context).apply {
                id = View.generateViewId()
                text = "Name"
                textSize = 18f
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            val iconpw = ImageView(context).apply{
                id = View.generateViewId()
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.icon_pw))
                layoutParams = LayoutParams(50,50)
            }

            val line1 = View(context).apply {
                id = View.generateViewId()
                setBackgroundColor(ContextCompat.getColor(context,R.color.lightgray))
                layoutParams = LayoutParams(600,1)
            }

            val addphoto = ImageView(context).apply{
                id = View.generateViewId()
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.addphoto))
                layoutParams = LayoutParams(140,140)
            }

            val bio = TextView(context).apply {
                id = View.generateViewId()
                text = "Bio"
                textSize = 18f
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            val tulisbio = TextView(context).apply{
                id = View.generateViewId()
                text = "+ Write Bio"
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
            }

            val line2 = View(context).apply {
                id = View.generateViewId()
                setBackgroundColor(ContextCompat.getColor(context,R.color.lightgray))
                layoutParams = LayoutParams(800,1)
            }

            val link = TextView(context).apply {
                id = View.generateViewId()
                text = "Link"
                textSize = 18f
                setTypeface(null, Typeface.BOLD)
                setTextColor(ContextCompat.getColor(context, R.color.white))
            }

            val tambahlink = TextView(context).apply{
                id = View.generateViewId()
                text = "+ Add link"
                setTextColor(ContextCompat.getColor(context, R.color.lightgray))
            }

            val line3 = View(context).apply {
                id = View.generateViewId()
                setBackgroundColor(ContextCompat.getColor(context,R.color.lightgray))
                layoutParams = LayoutParams(800,1)
            }

            layout.addView(btnBack)
            layout.addView(btnNext)
            layout.addView(header)
            layout.addView(textduwa)
            layout.addView(bgProfil)
            layout.addView(profil)
            layout.addView(iconpw)
            layout.addView(addphoto)
            layout.addView(line1)
            layout.addView(bio)
            layout.addView(tulisbio)
            layout.addView(line2)
            layout.addView(link)
            layout.addView(tambahlink)
            layout.addView(line3)

            val constraintSet = ConstraintSet()
            constraintSet.clone(layout)

            constraintSet.connect(btnBack.id, ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,60)
            constraintSet.connect(btnBack.id, ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,60)

            constraintSet.connect(btnNext.id, ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END,60)
            constraintSet.connect(btnNext.id, ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,60)

            constraintSet.connect(header.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 200)
            constraintSet.connect(header.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(header.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            constraintSet.connect(textduwa.id, ConstraintSet.TOP, header.id, ConstraintSet.BOTTOM,20)
            constraintSet.connect(textduwa.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(textduwa.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            constraintSet.connect(bgProfil.id, ConstraintSet.TOP, textduwa.id, ConstraintSet.BOTTOM,300)
            constraintSet.connect(bgProfil.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
            constraintSet.connect(bgProfil.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

            constraintSet.connect(profil.id, ConstraintSet.TOP, bgProfil.id, ConstraintSet.TOP,50)
            constraintSet.connect(profil.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,50)

            constraintSet.connect(iconpw.id, ConstraintSet.TOP, profil.id, ConstraintSet.TOP,100)
            constraintSet.connect(iconpw.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)

            constraintSet.connect(line1.id, ConstraintSet.TOP, iconpw.id, ConstraintSet.TOP,100)
            constraintSet.connect(line1.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)

            constraintSet.connect(addphoto.id, ConstraintSet.TOP, bgProfil.id, ConstraintSet.TOP,50)
            constraintSet.connect(addphoto.id, ConstraintSet.END, bgProfil.id, ConstraintSet.END,60)

            constraintSet.connect(bio.id, ConstraintSet.TOP, line1.id, ConstraintSet.BOTTOM,50)
            constraintSet.connect(bio.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,50)

            constraintSet.connect(tulisbio.id, ConstraintSet.TOP, bio.id, ConstraintSet.TOP,80)
            constraintSet.connect(tulisbio.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)

            constraintSet.connect(line2.id, ConstraintSet.TOP, tulisbio.id, ConstraintSet.TOP,100)
            constraintSet.connect(line2.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)

            constraintSet.connect(link.id, ConstraintSet.TOP, line2.id, ConstraintSet.BOTTOM,50)
            constraintSet.connect(link.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,50)

            constraintSet.connect(tambahlink.id, ConstraintSet.TOP, link.id, ConstraintSet.TOP,80)
            constraintSet.connect(tambahlink.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)

            constraintSet.connect(line3.id, ConstraintSet.TOP, tambahlink.id, ConstraintSet.TOP,100)
            constraintSet.connect(line3.id, ConstraintSet.START, bgProfil.id, ConstraintSet.START,48)


            constraintSet.applyTo(layout)
            layout
        }
    )
}

@Preview(showBackground = true)
@Composable
fun greetingPreview(){
    MobileTheme {
        IsiProfil()
    }
}