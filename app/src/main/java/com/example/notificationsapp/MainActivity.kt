package com.example.notificationsapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_main_send_notification.setOnClickListener {
            if(et_main_notification_msg.text.isNotEmpty()){
                val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    val notificationChannel = NotificationChannel("Hello world", "getCoffee()", NotificationManager.IMPORTANCE_HIGH)
                    notificationManager.createNotificationChannel(notificationChannel)

                    val builder = Notification.Builder(this, "Hello world")
                        .setSmallIcon(R.drawable.ic_baseline_code_24)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_baseline_code_24))
                        .setContentTitle("My Notification")
                        .setContentText(et_main_notification_msg.text.toString())

                    notificationManager.notify(12, builder.build())
                }
                else{
                    val builder = Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_baseline_code_24)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_baseline_code_24))
                        .setContentTitle("My Notification")
                        .setContentText(et_main_notification_msg.text.toString())

                    notificationManager.notify(12, builder.build())

                }

            }

        }

    }
}