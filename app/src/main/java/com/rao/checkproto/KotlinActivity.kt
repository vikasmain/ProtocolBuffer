package com.rao.checkproto

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.rao.checkproto.pb.Sample

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_layout)
        val sample = Sample.Builder()
                .id(2)
                .x(44)
                .y(88)
        val x_coordinates = findViewById<TextView>(R.id.kotlin_x_coordinates)
        val yCoordinates = findViewById<TextView>(R.id.kotlin_y_coordinates)
        val kotlin_id = findViewById<TextView>(R.id.kotlin_id)
        x_coordinates.text = "xCoordinate is ${sample.x}"
        yCoordinates.text = "yCoordinate is ${sample.y}"
        kotlin_id.text = "xCoordinate is ${sample.id}"

    }
}