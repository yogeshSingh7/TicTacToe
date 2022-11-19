package com.yogeshsingh.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var flag =0
    var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun onClick(view: View)
    {
        val btnCurrent = view as Button

        if (btnCurrent.text == "") {

            count++;

            if (flag == 0) {
                btnCurrent.text = "O";
                flag = 1;
            } else {
                btnCurrent.text = "X";
                flag = 0;
            }

            if(count>4)
            {
                when {
                    checkCond(btn1,btn2,btn3) -> {
                        showMsg("Winner is ${btn1.getStr()}")
                        newGame()
                    }
                    checkCond(btn4,btn5,btn6) -> {
                        showMsg("Winner is ${btn4.getStr()}")
                        newGame()
                    }
                    checkCond(btn7,btn8,btn9) -> {
                        showMsg("Winner is ${btn7.getStr()}")
                        newGame()
                    }
                    checkCond(btn1,btn4,btn7) -> {
                        showMsg("Winner is ${btn1.getStr()}")
                        newGame()
                    }
                    checkCond(btn2,btn5,btn8) -> {
                        showMsg("Winner is ${btn2.getStr()}")
                        newGame()
                    }
                    checkCond(btn3,btn6,btn9) -> {
                        showMsg("Winner is ${btn3.getStr()}")
                        newGame()
                    }
                    checkCond(btn1,btn5,btn9) -> {
                        showMsg("Winner is ${btn1.getStr()}")
                        newGame()
                    }
                    checkCond(btn3,btn5,btn7) -> {
                        showMsg("Winner is ${btn3.getStr()}")
                        newGame()
                    }
                    count==9 -> {
                        showMsg("Game Draw")
                        newGame()
                    }
                }
            }

        }
    }

    fun Button.getStr() = this.text.toString()


    val checkCond : (Button,Button,Button) -> Boolean = { a,b,c ->
        a.getStr()==b.getStr()
                && b.getStr()==c.getStr()
                && c.getStr()!=""
    }


    val showMsg:(String)->Unit = {msg:String ->
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    fun newGame()
    {
        btn1.text=""
        btn2.text=""
        btn3.text=""
        btn4.text=""
        btn5.text=""
        btn6.text=""
        btn7.text=""
        btn8.text=""
        btn9.text=""
        count=0;
        flag=0;
    }

}



