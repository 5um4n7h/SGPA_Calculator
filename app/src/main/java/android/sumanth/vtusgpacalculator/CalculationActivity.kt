package sumanth.sgpacalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculation.*

class CalculationActivity : AppCompatActivity() {

    var Credits = listOf<Int>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)

        //fetching selected sem
        val selected : Int = intent.getIntExtra("selected",1)

        //Log.d("Second", "onCreate: "+selected)


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
                Credits = listOf(4,4,3,3,3,1,1,1,0)

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
                Credits = listOf<Int>(3,4,3,3,3,3,2,2,1)



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
                Credits = listOf<Int>(3,4,3,3,3,3,2,2,1)

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
                Credits = listOf(3,4,4,3,3,3,2,2,1)

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
                Credits = listOf(4,4,4,3,3,2,2,2,0)

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


    fun calculate(view: View) {


       val m1  = TxtToInt(etMarks)
       val m2  = TxtToInt(etMarks2)
       val m3  = TxtToInt(etMarks3)
       val m4  = TxtToInt(etMarks4)
       val m5  = TxtToInt(etMarks5)
       val m6  = TxtToInt(etMarks6)
       val m7  = TxtToInt(etMarks7)
       val m8  = TxtToInt(etMarks8)
       val m9  = TxtToInt(etMarks9)

        val Marks  = listOf(m1,m2,m3,m4,m5,m6,m7,m8,m9)

        //init
        val GradePoints  = mutableListOf<Int>()
        val CreditPoints : MutableList<Int> = mutableListOf()
        var CreditPointsSum = 0.0
        var CreditsSum = 0.0


        //calculating Grade Points
        for(m in Marks){
            if (m>=90){
                GradePoints.add(10)
            }
            if(m in 80..89){
                GradePoints.add(9)
            }
            if(m in 70..79){
                GradePoints.add(8)
            }
            if(m in 60..69){
                GradePoints.add(7)
            }
            if(m in 45..59){
                GradePoints.add(6)
            }
            if(m in 40..44){
                GradePoints.add(4)
            }
            if(m < 40){
                GradePoints.add(0)
            }
        }

//        for(i : Int in 0 until  GradePoints.size)
//        Log.d(TAG, "calculate: GP: "+ GradePoints[i])

        //credit points calculation
        for((j, i : Int) in GradePoints.withIndex())
            CreditPoints.add(i* Credits[j])

//        for(i : Int in 0 until  CreditPoints.size)
//            Log.d(TAG, "calculate: CP: "+ CreditPoints.get(i))


        for(i : Int in 0 until  CreditPoints.size) {
           // Log.d(TAG, "calculate: " + CreditPoints[i])
            CreditPointsSum+= CreditPoints[i]
          //  Log.d(TAG, "calculate: sum1 : $CreditPointsSum")
        }


        for(i : Int in Credits.indices) {
            //Log.d(TAG, "calculate: " + Credits[i])
            CreditsSum+= Credits[i]
            //Log.d(TAG, "calculate: sum2 : $CreditsSum")
        }


        //Log.d(TAG, "calculate: "+CreditPointsSum+" , "+CreditsSum)

        val result : Double = String.format("%.2f",CreditPointsSum / CreditsSum).toDouble()
        tvResult.setText("Your SGPA is : $result")

    }



    private fun TxtToInt(etMarks: EditText?): Int {

        val result : Int
        try {
            //if marks available
            result = Integer.parseInt(etMarks?.text.toString())
            return result
        }catch (nE : Exception){
            //if marks is NA
            return  0
        }

    }
}