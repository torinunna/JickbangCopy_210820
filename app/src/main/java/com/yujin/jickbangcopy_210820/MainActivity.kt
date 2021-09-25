package com.yujin.jickbangcopy_210820

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yujin.jickbangcopy_210820.adapters.RoomAdapter
import com.yujin.jickbangcopy_210820.datas.RoomData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mRoomList = ArrayList<RoomData>()

    lateinit var mRoomAdapter : RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRoomList.add( RoomData( 8300, "서울시 동대문구", 5, "1번째 방입니다." ) )
        mRoomList.add( RoomData( 25000, "서울시 동대문구", 0, "2번째 방입니다." ) )
        mRoomList.add( RoomData( 38000, "서울시 동대문구", 7, "3번째 방입니다." ) )
        mRoomList.add( RoomData( 9700, "서울시 서대문구", -2, "4번째 방입니다." ) )
        mRoomList.add( RoomData( 164000, "서울시 서대문구", 14, "5번째 방입니다." ) )
        mRoomList.add( RoomData( 95000, "서울시 서대문구", -1, "6번째 방입니다." ) )


        mRoomAdapter = RoomAdapter( this, R.layout.room_list_item, mRoomList )
        roomListView.adapter = mRoomAdapter


        roomListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedRoom = mRoomList[ position ]

            val myIntent = Intent(this, ViewRoomDetailActivity::class.java)

            myIntent.putExtra("roomData", clickedRoom)

            startActivity(myIntent)

        }
    }
}