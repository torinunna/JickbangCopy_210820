package com.yujin.jickbangcopy_210820.datas

import java.io.Serializable
import java.text.NumberFormat
import java.util.*

class RoomData(
    val price : Int,
    val address : String,
    val floor : Int,
    val description : String ) : Serializable {

    fun getFormattedFloor() : String {

        if (this.floor > 0) {
            return "${this.floor}층"
        }
        else if (this.floor == 0) {
            return "반지하"
        }
        else {
            return "지하 ${-this.floor}층"
        }

    }

    fun getFormattedPrice() : String {

        if (this.price >= 10000) {
            val uk = this.price / 10000
            val rest = this.price % 10000

            val result = "${uk}억${NumberFormat.getNumberInstance(Locale.KOREA).format(rest)}"

            return result
        }
        else {
            val result  = NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)

            return result
        }

    }


}