package sumanth.sgpacalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculation.*

class CalculationActivity : AppCompatActivity() {

    var crdtPnC = listOf<Int>()
    val TAG = "CalAct"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)

        val selected : Int = intent.getIntExtra("selected",9)
        Log.d("Second", "onCreate: "+selected)

        when(selected){

            1,2 -> {
                tvTitle.setText("I / II Semester")
                tvSub1.setText("18***11 / 18***21")
                tvSub2.setText("18***12 / 18***22")
                tvSub3.setText("18***13 / 18***23")
                tvSub4.setText("18***14 / 18***24")
                tvSub5.setText("18***15 / 18***25")
                tvSub6.setText("18***16 / 18***26")
                tvSub7.setText("18***17 / 18***27")
                tvSub8.setText("18***18 / 18***28")
                tvSub9.visibility= View.GONE
                etMarks9.visibility = View.GONE
                crdtPnC = listOf(4,4,3,3,3,1,1,1,0)

            }

            3 -> {

                tvTitle.setText("III Semester")
                tvSub1.setText("18***31")
                tvSub2.setText("18**32")
                tvSub3.setText("18**33")
                tvSub4.setText("18**34")
                tvSub5.setText("18**35")
                tvSub6.setText("18**36")
                tvSub7.setText("18***37")
                tvSub8.setText("18***38")
                tvSub9.setText("18***39")
                crdtPnC = listOf<Int>(3,4,3,3,3,3,2,2,1)



            }

            4 -> {

                tvTitle.setText("IV Semester")
                tvSub1.setText("18***41")
                tvSub2.setText("18**42")
                tvSub3.setText("18**43")
                tvSub4.setText("18**44")
                tvSub5.setText("18**45")
                tvSub6.setText("18**46")
                tvSub7.setText("18***47")
                tvSub8.setText("18***48")
                tvSub9.setText("18***49")
                crdtPnC = listOf<Int>(3,4,3,3,3,3,2,2,1)

            }

            5 -> {
                tvTitle.setText("V Semester")
                tvSub1.setText("18**51")
                tvSub2.setText("18**52")
                tvSub3.setText("18**53")
                tvSub4.setText("18**54")
                tvSub5.setText("18**55")
                tvSub6.setText("18**56")
                tvSub7.setText("18***57")
                tvSub8.setText("18***58")
                tvSub9.setText("18***59")
                crdtPnC = listOf(3,4,4,3,3,3,2,2,1)

            }

            6 -> {
                tvTitle.setText("VI Semester")
                tvSub1.setText("18**61")
                tvSub2.setText("18**62")
                tvSub3.setText("18**63")
                tvSub4.setText("18**64X")
                tvSub5.setText("18**65X")
                tvSub6.setText("18**66")
                tvSub7.setText("18***67")
                tvSub8.setText("18***68")
                tvSub9.visibility= View.GONE
                etMarks9.visibility = View.GONE
                crdtPnC = listOf(4,4,4,3,3,2,2,2,0)

            }






        }

    }

    fun clear(view: View) {

        etMarks.setText("")
        etMarks2.setText("")
        etMarks3.setText("")
        etMarks4.setText("")
        etMarks5.setText("")
        etMarks6.setText("")
        etMarks7.setText("")
        etMarks8.setText("")
        etMarks9.setText("")
        tvResult.text = ""


    }

    @SuppressLint("SetTextI18n")
    fun calculate(view: View) {


       val m1  = StoI(etMarks)
       val m2  = StoI(etMarks2)
       val m3  = StoI(etMarks3)
       val m4  = StoI(etMarks4)
       val m5  = StoI(etMarks5)
       val m6  = StoI(etMarks6)
       val m7  = StoI(etMarks7)
       val m8  = StoI(etMarks8)
       val m9  = StoI(etMarks9)


        val Marks  = listOf(m1,m2,m3,m4,m5,m6,m7,m8,m9)
        val GP : MutableList<Int> = mutableListOf<Int>()
        for(m in Marks){
            if (m>=90){
                GP.add(10)
            }
            if(m in 80..89){
                GP.add(9)
            }
            if(m in 70..79){
                GP.add(8)
            }
            if(m in 60..69){
                GP.add(7)
            }
            if(m in 45..59){
                GP.add(6)
            }
            if(m in 40..44){
                GP.add(4)
            }
            if(m < 40){
                GP.add(0)
            }
        }

        for(i : Int in 0 until  GP.size)
        Log.d(TAG, "calculate: GP: "+ GP[i])

        val CP : MutableList<Int> = mutableListOf()
        for((j, i : Int) in GP.withIndex()){

                CP.add(i* crdtPnC[j])

        }

        for(i : Int in 0 until  CP.size)
            Log.d(TAG, "calculate: CP: "+ CP.get(i))

        var sum1 = 0.00
        for(i : Int in 0 until  CP.size) {
            Log.d(TAG, "calculate: " + CP[i])
            sum1+= CP[i]
            Log.d(TAG, "calculate: sum1 : $sum1")
        }

        var sum2 = 0.00
        for(i : Int in crdtPnC.indices) {
            Log.d(TAG, "calculate: " + crdtPnC[i])
            sum2+= crdtPnC[i]
            Log.d(TAG, "calculate: sum2 : $sum2")
        }


        Log.d(TAG, "calculate: "+sum1+" , "+sum2)

        val result : Double = String.format("%.2f",sum1 / sum2).toDouble()
        tvResult.setText("Your SGPA is : $result")

    }

    private fun StoI(etMarks: EditText?): Int {

        val result : Int
        try {
            result = Integer.parseInt(etMarks?.text.toString())

        }catch (nE : Exception){
            return  0
        }
        return result
    }
}