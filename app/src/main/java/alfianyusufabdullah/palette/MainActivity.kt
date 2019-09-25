package alfianyusufabdullah.palette

import alfianyusufabdullah.palette.android_pallete_example.R
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                spinnerItems
            )

        spinnerSelectImage.adapter = adapter
        spinnerSelectImage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                imagePreview.setImageResource(images[p2])

                generatePalette(BitmapFactory.decodeResource(resources, images[p2]))
            }
        }
    }

    private fun generatePalette(bitmap: Bitmap) {
        Palette.from(bitmap).generate { palette ->
            val defValue = 0x000000

            prevVibrant.setBackgroundColor(palette?.getVibrantColor(defValue) ?: defValue)
            prevVibrantDark.setBackgroundColor(palette?.getDarkVibrantColor(defValue) ?: defValue)
            prevVibrantLight.setBackgroundColor(palette?.getLightVibrantColor(defValue) ?: defValue)
            prevMuted.setBackgroundColor(palette?.getMutedColor(defValue) ?: defValue)
            prevMutedDark.setBackgroundColor(palette?.getDarkMutedColor(defValue) ?: defValue)
            prevMutedDarkLight.setBackgroundColor(palette?.getLightMutedColor(defValue) ?: defValue)
            prevDominant.setBackgroundColor(palette?.getDominantColor(defValue) ?: defValue)
        }
    }

    private val images = listOf(
        R.drawable.poster_aladdin,
        R.drawable.poster_angel_has_fallen,
        R.drawable.poster_avengers_endgame,
        R.drawable.poster_cars,
        R.drawable.poster_dark_phoenix,
        R.drawable.poster_fast___furious_presents_hobbs___shaw,
        R.drawable.poster_godzilla_king_of_the_monsters,
        R.drawable.poster_good_boys,
        R.drawable.poster_it_chapter_two,
        R.drawable.poster_john_wick,
        R.drawable.poster_john_wick_chapter_3__parabellum,
        R.drawable.poster_men_in_black_international,
        R.drawable.poster_red_shoes_and_the_seven_dwarfs,
        R.drawable.poster_spiderman_far_from_home,
        R.drawable.poster_the_caged_flower,
        R.drawable.poster_the_dead_dont_die,
        R.drawable.poster_the_lion_king,
        R.drawable.poster_the_old_man___the_gun
    )

    private val spinnerItems = Array(images.size) {
        "Gambar ${it + 1}"
    }
}

