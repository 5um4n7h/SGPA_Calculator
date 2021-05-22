package sumanth.sgpacalculator


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.github.johnpersano.supertoasts.library.Style
import com.github.johnpersano.supertoasts.library.SuperActivityToast
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sems = resources.getStringArray(R.array.Semesters)
        spinnerSem.adapter = ArrayAdapter(this,
                R.layout.spinner_items, sems)


    }


    fun proceed(view: View) {


        val selected: Int = spinnerSem.selectedItemPosition
        if (selected != 0) {
            val intent = Intent(this, CalculationActivity::class.java)
            intent.putExtra("selected", selected)
            startActivity(intent)
        } else {
            SuperActivityToast.create(this, Style(), Style.TYPE_STANDARD)
                    .setText("Select Semester !")
                    .setDuration(Style.DURATION_SHORT)
                    .setFrame(Style.FRAME_KITKAT)
                    .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_RED))
                    .setAnimations(Style.ANIMATIONS_POP).show()

        }


    }

}

