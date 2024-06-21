package com.example.tetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.postDelayed
import kotlin.random.Random
import kotlin.random.nextInt

class Game : AppCompatActivity() {

    private val gridLayoutItems = mutableMapOf<Int, TextView>()
    private val playingField = mutableMapOf<Int, TextView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)
        val miniGrid  = findViewById<GridLayout>(R.id.miniGrid)

        val numRows = 15
        val numCols = 10
        var kol = 1

        for (row in 0 until numRows){
            for (col in 0 until numCols){
                val textView = TextView(this)
                val customId = ("B$kol")
                textView.id =customId.hashCode()
                textView.layoutParams = GridLayout.LayoutParams().apply {
                    width = resources.getDimensionPixelSize(R.dimen.grid_item_size)
                    height = resources.getDimensionPixelSize(R.dimen.grid_item_size)
                    rowSpec = GridLayout.spec(row)
                    columnSpec = GridLayout.spec(col)
                }
                textView.background = ContextCompat.getDrawable(this, R.drawable.gray)
                textView.textSize = 0f
//                textView.text = ""
                playingField[textView.id] = textView
                gridLayout.addView(textView)
//                println("TextView id: $customId")
                kol++
            }
        }

        kol = 1
        for (row in 0 until 4){
            for (col in 0 until 3){
                val textView = TextView(this)
                val customId = ("b$kol")
                textView.id =customId.hashCode()
                textView.layoutParams = GridLayout.LayoutParams().apply {
                    width = resources.getDimensionPixelSize(R.dimen.grid_item_size)
                    height = resources.getDimensionPixelSize(R.dimen.grid_item_size)
                    rowSpec = GridLayout.spec(row)
                    columnSpec = GridLayout.spec(col)
                }
                textView.background = ContextCompat.getDrawable(this, R.drawable.gray)
                textView.textSize = 0f
                gridLayoutItems[textView.id] = textView
                miniGrid.addView(textView)
//                println("TextView id: $customId")
                kol++
            }
        }
        val tV2 = findViewById<TextView>(R.id.textView2)
        downArray.add(tV2)
        downArray.apply {
            for (i in 1..150){
                val textViewId = "B$i"
                val textView:TextView? = playingField[textViewId.hashCode()]
                textView?.let { add(it) }
            }
        }

        next_shape()
    }

    var nextUp = 0
    var starting = 0
    var num1 = 0; var num2 = 0; var num3 = 0; var num4 = 0
    var shape_is = 0
    var stop = 0
    var lines = 1
    var once = 0
    var x = 0
    var points = 0
    val arrayCollectPreviousOne = arrayListOf<TextView>()
    val array = arrayListOf<TextView>()
    val downArray: ArrayList<TextView> = arrayListOf<TextView>()



    private fun loseAline(){
        val pointTally = findViewById<TextView>(R.id.textView);
//        for (i in 11..141) {
//            var isAllZero = (i..(i + 9)).all { downArray[it]?.text == "0" }
//            if (isAllZero) {
//                for (i in i..(i + 9)) {
//                    downArray[i]?.setBackgroundResource(R.drawable.gray)
//                    downArray[i]?.text = ""
//                }
//                points += 100;
//            }
//        }
        var isAllZero = (11..20).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 11..20){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 2
            }
        }
        isAllZero = (21..30).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 21..30){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 3
            }
        }
        isAllZero = (31..40).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 31..40){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 4
            }
        }
        isAllZero = (41..50).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 41..50){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 5
            }
        }
        isAllZero = (51..60).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 51..60){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 6
            }
        }
        isAllZero = (61..70).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 61..70){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 7
            }
        }
        isAllZero = (71..80).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 71..80){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 8
            }
        }
        isAllZero = (81..90).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 81..90){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 9
            }
        }
        isAllZero = (91..100).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 91..100){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 10
            }
        }
        isAllZero = (101..110).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 101..110){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 11
            }
        }
        isAllZero = (111..120).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 111..120){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 12
            }
        }
        isAllZero = (121..130).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 121..130){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 13
            }
        }
        isAllZero = (131..140).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 131..140){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 14
            }
        }
        isAllZero = (141..150).all { downArray[it]?.text == "0" }
        if (isAllZero) {
            for (i in 141..150){
                downArray[i]?.setBackgroundResource(R.drawable.gray)
                downArray[i]?.text = ""
                points += 100;
                lines = 15
            }
        }

//        if (downArray[11]?.text == "0" && downArray[12]?.text == "0" && downArray[13]?.text == "0" && downArray[14]?.text == "0" && downArray[15]?.text == "0" &&
//            downArray[16]?.text == "0" && downArray[17]?.text == "0" && downArray[18]?.text == "0" && downArray[19]?.text == "0" && downArray[20]?.text == "0" ) {}
        Handler().postDelayed({
            if (lines == 15){isAllZero = (141..150).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 141..150){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=14
            }
            if (lines == 14){ isAllZero = (131..140).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 131..140){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=13
            }
            if (lines == 13){ isAllZero = (121..130).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 121..130){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=12
            }
            if (lines == 12){isAllZero = (111..120).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 111..120){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=11
            }
            if (lines == 11){isAllZero = (101..110).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 101..110){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=10
            }
            if (lines == 10){isAllZero = (91..100).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 91..100){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=9
            }
            if (lines == 9){isAllZero = (81..90).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 81..90){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=8
            }
            if (lines == 8){isAllZero = (71..80).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 71..80){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=7
            }
            if (lines == 7){isAllZero = (61..70).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 61..70){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=6
            }
            if (lines == 6){ isAllZero = (51..60).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 51..60){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=5
            }
            if (lines == 5){
                isAllZero = (41..50).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 41..50){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=4
            }
            if (lines == 4){ isAllZero = (31..40).all { downArray[it]?.text == "" }
                if (isAllZero) {
                    for (i in 31..40){
                        downArray[i]?.text = downArray[i-10].text
                        downArray[i]?.background = downArray[i-10].background
                        downArray[i-10].setBackgroundResource(R.drawable.gray)
                        downArray[i-10].text = ""
                    }
                }
                lines=3
            }
            if (lines == 3){lines=2}
            if (lines == 2){}
        },500)
        pointTally.text = "Счёт: $points"
    }
    private fun next_shape(){
        val b1 = gridLayoutItems[("b1").hashCode()]; val b2 = gridLayoutItems[("b2").hashCode()];val b3 = gridLayoutItems[("b3").hashCode()]
        val b4 = gridLayoutItems[("b4").hashCode()]; val b5 = gridLayoutItems[("b5").hashCode()];val b6 = gridLayoutItems[("b6").hashCode()]
        val b7 = gridLayoutItems[("b7").hashCode()]; val b8 = gridLayoutItems[("b8").hashCode()];val b9 = gridLayoutItems[("b9").hashCode()]
        val b10 = gridLayoutItems[("b10").hashCode()]; val b11 = gridLayoutItems[("b11").hashCode()];val b12 = gridLayoutItems[("b12").hashCode()]

        b1?.setBackgroundResource(R.drawable.gray); b2?.setBackgroundResource(R.drawable.gray); b3?.setBackgroundResource(R.drawable.gray);
        b4?.setBackgroundResource(R.drawable.gray); b5?.setBackgroundResource(R.drawable.gray); b6?.setBackgroundResource(R.drawable.gray);
        b7?.setBackgroundResource(R.drawable.gray); b8?.setBackgroundResource(R.drawable.gray); b9?.setBackgroundResource(R.drawable.gray);
        b10?.setBackgroundResource(R.drawable.gray); b11?.setBackgroundResource(R.drawable.gray); b12?.setBackgroundResource(R.drawable.gray);

        val random = Random.nextInt(1..7)
        when(random){
            1 -> {b9?.setBackgroundResource(R.drawable.red);b10?.setBackgroundResource(R.drawable.red); b11?.setBackgroundResource(R.drawable.red); b12?.setBackgroundResource(R.drawable.red);}
            2 -> {b7?.setBackgroundResource(R.drawable.orange);b8?.setBackgroundResource(R.drawable.orange); b11?.setBackgroundResource(R.drawable.orange); b12?.setBackgroundResource(R.drawable.orange);}
            3 -> {b8?.setBackgroundResource(R.drawable.pink);b9?.setBackgroundResource(R.drawable.pink); b11?.setBackgroundResource(R.drawable.pink); b12?.setBackgroundResource(R.drawable.pink);}
            4 -> {b7?.setBackgroundResource(R.drawable.green2);b10?.setBackgroundResource(R.drawable.green2); b11?.setBackgroundResource(R.drawable.green2); b12?.setBackgroundResource(R.drawable.green2);}
            5 -> {b9?.setBackgroundResource(R.drawable.blue);b8?.setBackgroundResource(R.drawable.blue); b11?.setBackgroundResource(R.drawable.blue); b10?.setBackgroundResource(R.drawable.blue);}
            6 -> {b8?.setBackgroundResource(R.drawable.purple);b10?.setBackgroundResource(R.drawable.purple); b11?.setBackgroundResource(R.drawable.purple); b12?.setBackgroundResource(R.drawable.purple);}
            7 -> {b2?.setBackgroundResource(R.drawable.turquoise);b5?.setBackgroundResource(R.drawable.turquoise); b8?.setBackgroundResource(R.drawable.turquoise); b11?.setBackgroundResource(R.drawable.turquoise);}
        }
        nextUp = random
        if(once == 0){
            b1?.setBackgroundResource(R.drawable.gray); b2?.setBackgroundResource(R.drawable.gray); b3?.setBackgroundResource(R.drawable.gray);
            b4?.setBackgroundResource(R.drawable.gray); b5?.setBackgroundResource(R.drawable.gray); b6?.setBackgroundResource(R.drawable.gray);
            b7?.setBackgroundResource(R.drawable.gray); b8?.setBackgroundResource(R.drawable.gray); b9?.setBackgroundResource(R.drawable.gray);
            b10?.setBackgroundResource(R.drawable.gray); b11?.setBackgroundResource(R.drawable.gray); b12?.setBackgroundResource(R.drawable.gray);
            b8?.setBackgroundResource(R.drawable.pink);b9?.setBackgroundResource(R.drawable.pink); b11?.setBackgroundResource(R.drawable.pink); b12?.setBackgroundResource(R.drawable.pink);
            nextUp = 3
            once = 1
        }

        if (starting == 0){
            Handler().postDelayed({shapes()}, 1500)
            starting = 1
        }
    }

    private fun shapes(){
        val b1 = gridLayoutItems[("b1").hashCode()]; val b2 = gridLayoutItems[("b2").hashCode()];val b3 = gridLayoutItems[("b3").hashCode()]
        val b4 = gridLayoutItems[("b4").hashCode()]; val b5 = gridLayoutItems[("b5").hashCode()];val b6 = gridLayoutItems[("b6").hashCode()]
        val b7 = gridLayoutItems[("b7").hashCode()]; val b8 = gridLayoutItems[("b8").hashCode()];val b9 = gridLayoutItems[("b9").hashCode()]
        val b10 = gridLayoutItems[("b10").hashCode()]; val b11 = gridLayoutItems[("b11").hashCode()];val b12 = gridLayoutItems[("b12").hashCode()]

        if (downArray.getOrNull(11)?.text == "0" || downArray.getOrNull(12)?.text == "0" || downArray.getOrNull(13)?.text == "0" || downArray.getOrNull(14)?.text == "0" ||
            downArray.getOrNull(15)?.text == "0" || downArray.getOrNull(16)?.text == "0" || downArray.getOrNull(17)?.text == "0" || downArray.getOrNull(18)?.text == "0" ||
            downArray.getOrNull(19)?.text == "0" || downArray.getOrNull(20)?.text == "0"){
            b1?.setBackgroundResource(R.drawable.gray); b2?.setBackgroundResource(R.drawable.gray); b3?.setBackgroundResource(R.drawable.gray);
            b4?.setBackgroundResource(R.drawable.gray); b5?.setBackgroundResource(R.drawable.gray); b6?.setBackgroundResource(R.drawable.gray);
            b7?.setBackgroundResource(R.drawable.gray); b8?.setBackgroundResource(R.drawable.gray); b9?.setBackgroundResource(R.drawable.gray);
            b10?.setBackgroundResource(R.drawable.gray); b11?.setBackgroundResource(R.drawable.gray); b12?.setBackgroundResource(R.drawable.gray);
            downArray.getOrNull(4)?.setBackgroundResource(R.drawable.turquoise);downArray.getOrNull(5)?.setBackgroundResource(R.drawable.turquoise); downArray.getOrNull(6)?.setBackgroundResource(R.drawable.turquoise); downArray.getOrNull(7)?.setBackgroundResource(R.drawable.turquoise);
            stop = 1
        }
        loseAline()
        if (stop == 0){
            a = 0; b = 0; z = 0; x = 0
            if(downArray.getOrNull(24)?.text == "0" || downArray.getOrNull(25)?.text == "0" ||
                downArray.getOrNull(26)?.text == "0" || downArray.getOrNull(27)?.text == "0"){nextUp=7}
            array.removeAll(array.toSet()); arrayCollectPreviousOne.removeAll(arrayCollectPreviousOne.toSet())
            shape_is = nextUp
            next_shape()
            when(shape_is){
                1 -> {downArray.getOrNull(6)?.setBackgroundResource(R.drawable.red);downArray.getOrNull(14)?.setBackgroundResource(R.drawable.red); downArray.getOrNull(15)?.setBackgroundResource(R.drawable.red); downArray.getOrNull(16)?.setBackgroundResource(R.drawable.red);}
                2 -> {downArray.getOrNull(5)?.setBackgroundResource(R.drawable.orange);downArray.getOrNull(6)?.setBackgroundResource(R.drawable.orange); downArray.getOrNull(16)?.setBackgroundResource(R.drawable.orange); downArray.getOrNull(17)?.setBackgroundResource(R.drawable.orange);}
                3 -> {downArray.getOrNull(5)?.setBackgroundResource(R.drawable.pink);downArray.getOrNull(6)?.setBackgroundResource(R.drawable.pink); downArray.getOrNull(15)?.setBackgroundResource(R.drawable.pink); downArray.getOrNull(16)?.setBackgroundResource(R.drawable.pink);}
                4 -> {downArray.getOrNull(5)?.setBackgroundResource(R.drawable.green2);downArray.getOrNull(15)?.setBackgroundResource(R.drawable.green2); downArray.getOrNull(16)?.setBackgroundResource(R.drawable.green2); downArray.getOrNull(17)?.setBackgroundResource(R.drawable.green2);}
                5 -> {downArray.getOrNull(5)?.setBackgroundResource(R.drawable.blue);downArray.getOrNull(6)?.setBackgroundResource(R.drawable.blue); downArray.getOrNull(14)?.setBackgroundResource(R.drawable.blue); downArray.getOrNull(15)?.setBackgroundResource(R.drawable.blue);}
                6 -> {downArray.getOrNull(6)?.setBackgroundResource(R.drawable.purple);downArray.getOrNull(15)?.setBackgroundResource(R.drawable.purple); downArray.getOrNull(16)?.setBackgroundResource(R.drawable.purple); downArray.getOrNull(17)?.setBackgroundResource(R.drawable.purple);}
                7 -> {downArray.getOrNull(4)?.setBackgroundResource(R.drawable.turquoise);downArray.getOrNull(5)?.setBackgroundResource(R.drawable.turquoise); downArray.getOrNull(6)?.setBackgroundResource(R.drawable.turquoise); downArray.getOrNull(7)?.setBackgroundResource(R.drawable.turquoise);}
            }
            when(shape_is){
                1 -> {num1 = 6; num2 =14; num3 = 15; num4 = 16}
                2 -> {num1 = 5; num2 =6; num3 = 16; num4 = 17}
                3 -> {num1 = 5; num2 =6; num3 = 15; num4 = 16}
                4 -> {num1 = 5; num2 =15; num3 = 16; num4 = 17}
                5 -> {num1 = 5; num2 =6; num3 = 14; num4 = 15}
                6 -> {num1 = 6; num2 =15; num3 = 16; num4 = 17}
                7 -> {num1 = 4; num2 =5; num3 = 6; num4 = 7}
            }
            list()
        }else{}
    }

    var a = 0; var b = 0; var z = 0;

    private fun list(){
        val right = findViewById<Button>(R.id.right_btn)
        val left = findViewById<Button>(R.id.left_btn)
        val down = findViewById<Button>(R.id.down_btn)
        val rotation = findViewById<Button>(R.id.rotation_btn)

        right.setOnClickListener(){
            if (a == 0){
                if (num1 != 10&&num1 != 20&&num1 != 30&&num1 != 40&&num1 != 50&&num1 != 60&&num1 != 70&&num1 != 80&&num1 != 90&&num1 != 100&&num1 != 110&&num1 != 120&&num1 != 130&&num1 != 140&&num1 != 150&&
                    num2 != 10&&num2 != 20&&num2 != 30&&num2 != 40&&num2 != 50&&num2 != 60&&num2 != 70&&num2 != 80&&num2 != 90&&num2 != 100&&num2 != 110&&num2 != 120&&num2 != 130&&num2 != 140&&num2 != 150&&
                    num3 != 10&&num3 != 20&&num3 != 30&&num3 != 40&&num3 != 50&&num3 != 60&&num3 != 70&&num3 != 80&&num3 != 90&&num3 != 100&&num3 != 110&&num3 != 120&&num3 != 130&&num3 != 140&&num3 != 150&&
                    num4 != 10&&num4 != 20&&num4 != 30&&num4 != 40&&num4 != 50&&num4 != 60&&num4 != 70&&num4 != 80&&num4 != 90&&num4 != 100&&num4 != 110&&num4 != 120&&num4 != 130&&num4 != 140&&num4 != 150
                    && downArray[num1 + 1].text=="" && downArray[num2 + 1].text=="" && downArray[num3 + 1].text=="" && downArray[num4 + 1].text==""){
                    num1+=1; num2+=1; num3+=1; num4+=1
                }
            }
        }
        left.setOnClickListener(){
            if (b == 0){
                if (num1 != 1 && num1 != 11&&num1 != 21&&num1 != 31&&num1 != 41&&num1 != 51&&num1 != 61&&num1 != 71&&num1 != 81&&num1 != 91&&num1 != 101&&num1 != 111&&num1 != 121&&num1 != 131&&num1 != 141&&
                    num2 != 1 && num2 != 11&&num2 != 21&&num2 != 31&&num2 != 41&&num2 != 51&&num2 != 61&&num2 != 71&&num2 != 81&&num2 != 91&&num2 != 101&&num2 != 111&&num2 != 121&&num2 != 131&&num2 != 141&&
                    num3 != 1 && num3 != 11&&num3 != 21&&num3 != 31&&num3 != 41&&num3 != 51&&num3 != 61&&num3 != 71&&num3 != 81&&num3 != 91&&num3 != 101&&num3 != 111&&num3 != 121&&num3 != 131&&num3 != 141&&
                    num4 != 1 && num4 != 11&&num4 != 21&&num4 != 31&&num4 != 41&&num4 != 51&&num4 != 61&&num4 != 71&&num4 != 81&&num4 != 91&&num4 != 101&&num4 != 111&&num4 != 121&&num4 != 131&&num4 != 141
                    && downArray[num1 - 1].text=="" && downArray[num2 - 1].text=="" && downArray[num3 - 1].text=="" && downArray[num4 - 1].text==""){
                    num1-=1; num2-=1; num3-=1; num4-=1
                }
            }
        }
        rotation.setOnClickListener(){
            if (downArray[num1+1].text == "" && downArray[num2+1].text == "" && downArray[num3+1].text == "" && downArray[num4+1].text == "" &&
                downArray[num1-1].text == "" && downArray[num2-1].text == "" && downArray[num3-1].text == "" && downArray[num4-1].text == "" &&
                downArray[num1+10].text == "" && downArray[num2+10].text == "" && downArray[num3+10].text == "" && downArray[num4+10].text == "" &&
                downArray[num1-10].text == "" && downArray[num2-10].text == "" && downArray[num3-10].text == "" && downArray[num4-10].text == "" ){
                when (shape_is){
                    1 -> {if (z == 0){num1-=1; num2+=1; num3+=10; num4+=10; z=1}; else if (z == 1){num1+=9; num2+=0; num3-=9; num4-=2; z=2};
                    else if (z == 2){num1-=10; num2-=10; num3-=1; num4+=1; z=3}; else{num1+=2; num2+=9; num3+=0; num4-=9; z=0}}
                    2 -> {if (z == 0){num1+=1; num2+=9; num3+=0; num4+=8; z=1}else{num1-=1; num2-=9; num3-=0; num4-=8; z=0}}
                    3 -> {}
                    4 -> {if (z == 0){num1+=0; num2-=9; num3-=1; num4+=8; z=1}; else if (z == 1){num1+=10; num2+=10; num3+=2; num4+=2; z=2};
                    else if (z == 2){num1-=8; num2+=1; num3+=9; num4+=0; z=3}; else{num1-=2; num2-=2; num3-=10; num4-=10; z=0}}
                    5 -> {if (z == 0){num1+=0; num2+=9; num3+=2; num4+=11; z=1}else{num1-=0; num2-=9; num3-=2; num4-=11; z=0}}
                    6 -> {if (z == 0){num1+=0; num2+=1; num3+=1; num4+=9; z=1}; else if (z == 1){num1+=9; num2+=0; num3+=0; num4+=0; z=2};
                    else if (z == 2){num1-=9; num2-=1; num3-=1; num4+=0; z=3}; else{num1+=0; num2+=0; num3+=0; num4-=9; z=0}}
                    7 -> {if (z == 0){num1+=1; num2+=10; num3+=19; num4+=28; z=1}else{num1-=1; num2-=10; num3-=19; num4-=28; z=0}}
                }
            }
        }
        down.setOnClickListener(){
            while (x==0){
                arrayCollectPreviousOne.add(downArray[num1]); arrayCollectPreviousOne.add(downArray[num2]);  arrayCollectPreviousOne.add(downArray[num3]);  arrayCollectPreviousOne.add(downArray[num4])
                num1+=10; num2+=10; num3+=10; num4+=10
                if (downArray[num1].text=="1" || downArray[num2].text=="1" || downArray[num3].text=="1" || downArray[num4].text=="1" ||
                    num1 == 141 || num1 == 142 || num1 == 143 || num1 == 144 || num1 == 145 || num1 == 146 || num1 == 147 || num1 == 148 || num1 == 149 || num1 == 150 ||
                    num2 == 141 || num2 == 142 || num2 == 143 || num2 == 144 || num2 == 145 || num2 == 146 || num2 == 147 || num2 == 148 || num2 == 149 || num2 == 150 ||
                    num3 == 141 || num3 == 142 || num3 == 143 || num3 == 144 || num3 == 145 || num3 == 146 || num3 == 147 || num3 == 148 || num3 == 149 || num3 == 150 ||
                    num4 == 141 || num4 == 142 || num4 == 143 || num4 == 144 || num4 == 145 || num4 == 146 || num4 == 147 || num4 == 148 || num4 == 149 || num4 == 150){
                    num1-=10; num2-=10; num3-=10; num4-=10; x=1; points+=5
                }
            }
        }

        if ((a == 0 || b == 0) && (num1 in 1 .. 140 && num2 in 1 .. 140 && num3 in 1 .. 140 && num4 in 1 .. 140)){num1+=10; num2+=10; num3+=10; num4+=10}
        println("1: $num1, 2: $num2, 3: $num3, 4: $num4")
        arrayCollectPreviousOne.add(downArray[num1]); arrayCollectPreviousOne.add(downArray[num2]);  arrayCollectPreviousOne.add(downArray[num3]);  arrayCollectPreviousOne.add(downArray[num4])
        array.add(downArray[num1]); array.add(downArray[num2]);  array.add(downArray[num3]);  array.add(downArray[num4])
        landing();color()
    }
    private fun list2(){
        if(downArray[num1-10].text == "") { downArray[num1-10].text = "1" } else if (downArray[num1-10].text == "0") {}
        if(downArray[num2-10].text == "") { downArray[num2-10].text = "1" } else if (downArray[num2-10].text == "0") {}
        if(downArray[num3-10].text == "") { downArray[num3-10].text = "1" } else if (downArray[num3-10].text == "0") {}
        if(downArray[num4-10].text == "") { downArray[num4-10].text = "1" } else if (downArray[num4-10].text == "0") {}
        shapes()
    }
    private fun R_L(){
        for (i in 1 .. 150){
            if (downArray.getOrNull(i)?.text != "0") {downArray.getOrNull(i)?.setBackgroundResource(R.drawable.gray)}
        }

    }
    private fun landing(){
        if (num1 == 141 || num1 == 142 || num1 == 143 || num1 == 144 || num1 == 145 || num1 == 146 || num1 == 147 || num1 == 148 || num1 == 149 || num1 == 150 ||
            num2 == 141 || num2 == 142 || num2 == 143 || num2 == 144 || num2 == 145 || num2 == 146 || num2 == 147 || num2 == 148 || num2 == 149 || num2 == 150 ||
            num3 == 141 || num3 == 142 || num3 == 143 || num3 == 144 || num3 == 145 || num3 == 146 || num3 == 147 || num3 == 148 || num3 == 149 || num3 == 150 ||
            num4 == 141 || num4 == 142 || num4 == 143 || num4 == 144 || num4 == 145 || num4 == 146 || num4 == 147 || num4 == 148 || num4 == 149 || num4 == 150) {
            array[0].text="0"; array[1].text="0"; array[2].text="0"; array[3].text="0"
        }
        if(array[0].text=="1" || array[1].text=="1" || array[2].text=="1" ||  array[3].text=="1"){array[0].text="0"; array[1].text="0"; array[2].text="0"; array[3].text="0"}
    }
    private fun color(){
        R_L()
        a=0; b=0
        arrayCollectPreviousOne[0].setBackgroundResource(R.drawable.gray); arrayCollectPreviousOne[1].setBackgroundResource(R.drawable.gray)
        arrayCollectPreviousOne[2].setBackgroundResource(R.drawable.gray); arrayCollectPreviousOne[3].setBackgroundResource(R.drawable.gray)
        when (shape_is){
            1 -> {array[0].setBackgroundResource(R.drawable.red); array[1].setBackgroundResource(R.drawable.red); array[2].setBackgroundResource(R.drawable.red); array[3].setBackgroundResource(R.drawable.red)}
            2 -> {array[0].setBackgroundResource(R.drawable.orange); array[1].setBackgroundResource(R.drawable.orange); array[2].setBackgroundResource(R.drawable.orange); array[3].setBackgroundResource(R.drawable.orange)}
            3 -> {array[0].setBackgroundResource(R.drawable.pink); array[1].setBackgroundResource(R.drawable.pink); array[2].setBackgroundResource(R.drawable.pink); array[3].setBackgroundResource(R.drawable.pink)}
            4 -> {array[0].setBackgroundResource(R.drawable.green2); array[1].setBackgroundResource(R.drawable.green2); array[2].setBackgroundResource(R.drawable.green2); array[3].setBackgroundResource(R.drawable.green2)}
            5 -> {array[0].setBackgroundResource(R.drawable.blue); array[1].setBackgroundResource(R.drawable.blue); array[2].setBackgroundResource(R.drawable.blue); array[3].setBackgroundResource(R.drawable.blue)}
            6 -> {array[0].setBackgroundResource(R.drawable.purple); array[1].setBackgroundResource(R.drawable.purple); array[2].setBackgroundResource(R.drawable.purple); array[3].setBackgroundResource(R.drawable.purple)}
            7 -> {array[0].setBackgroundResource(R.drawable.turquoise); array[1].setBackgroundResource(R.drawable.turquoise); array[2].setBackgroundResource(R.drawable.turquoise); array[3].setBackgroundResource(R.drawable.turquoise)}
        }
        if (array[0].text=="0" && array[1].text=="0" && array[2].text=="0" &&  array[3].text=="0"){ points+=15; list2() }
        else {array.removeAll(array); arrayCollectPreviousOne.removeAll(arrayCollectPreviousOne); Handler().postDelayed({list()}, 600)}
    }



}

