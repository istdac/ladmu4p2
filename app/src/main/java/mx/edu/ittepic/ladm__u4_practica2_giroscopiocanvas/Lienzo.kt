package mx.edu.ittepic.ladm__u4_practica2_giroscopiocanvas

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.View
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService

class Lienzo(p: MainActivity,sm:SensorManager, pr: Sensor, gy:Sensor): View(p),SensorEventListener {

    private lateinit var sensorManager: SensorManager
    //bitmaps
    var bru = BitmapFactory.decodeResource(resources,R.drawable.witch)
    var nub = BitmapFactory.decodeResource(resources,R.drawable.iconfinder_05_cloud_smile_cloudy_emoticon_weather_smiley_3375695)
    var nub1 = BitmapFactory.decodeResource(resources,R.drawable.iconfinder_05_cloud_smile_cloudy_emoticon_weather_smiley_3375695)
    var nub2 = BitmapFactory.decodeResource(resources,R.drawable.iconfinder_05_cloud_smile_cloudy_emoticon_weather_smiley_3375695)
    var nub3 = BitmapFactory.decodeResource(resources,R.drawable.iconfinder_05_cloud_smile_cloudy_emoticon_weather_smiley_3375695)
    var nub4 = BitmapFactory.decodeResource(resources,R.drawable.iconfinder_05_cloud_smile_cloudy_emoticon_weather_smiley_3375695)
    var nub5 = BitmapFactory.decodeResource(resources,R.drawable.iconfinder_05_cloud_smile_cloudy_emoticon_weather_smiley_3375695)
    var nub6 = BitmapFactory.decodeResource(resources,R.drawable.iconfinder_05_cloud_smile_cloudy_emoticon_weather_smiley_3375695)
    var nub7 = BitmapFactory.decodeResource(resources,R.drawable.iconfinder_05_cloud_smile_cloudy_emoticon_weather_smiley_3375695)
    var nub8 = BitmapFactory.decodeResource(resources,R.drawable.iconfinder_05_cloud_smile_cloudy_emoticon_weather_smiley_3375695)
    var nubes = arrayOf(nub,nub1,nub2,nub3,nub4,nub5,nub6,nub7,nub8)
    var sun = BitmapFactory.decodeResource(resources,R.drawable.sun)
    var moon = BitmapFactory.decodeResource(resources,R.drawable.moon)
    var dia = false
    var sp=pr
    var sg=gy
    var sm=sm
    var xs=0f
    var ys=0f
    init {
        sm.registerListener(this,this.sg,SensorManager.SENSOR_DELAY_NORMAL)
        sm.registerListener(this,this.sp,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        when(p0!!.sensor.type){
            sp.type->{
                println("Proximidad "+p0!!.values[0])
                if(p0!!.values[0]>=5){
                    dia=true
                }else {dia=false}
            }
            sg.type->{
                println("Gyro "+p0!!.values[0])
                println("Gyro "+p0!!.values[1])
                println("Gyro "+p0!!.values[2])
                if(p0!!.values[0]!=0.0f){
                    xs=p0!!.values[0]*10
                }
                if(p0!!.values[1]!=0.0f){
                    ys=p0!!.values[1]*20
                }

            }
        }
        invalidate()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var pa = Paint()
        if(dia){
            pa.setColor(Color.rgb(255,251,128))
            c.drawRect(0f,0f,1080f,2220f,pa)
            c.drawBitmap(sun,150f,20f,pa)
        }else{
            pa.setColor(Color.rgb(68,61,255))
            c.drawRect(0f,0f,1080f,2220f,pa)
            c.drawBitmap(moon,150f,20f,pa)
        }
        c.drawBitmap(bru,300f+xs,500f+ys,pa)
        c.drawBitmap(nub,100f+xs,600f+ys,pa)
        c.drawBitmap(nub1,370f+xs,100f+ys,pa)
        c.drawBitmap(nub2,600f+xs,800f+ys,pa)
        c.drawBitmap(nub3,200f+xs,200f+ys,pa)
        c.drawBitmap(nub4,350f+xs,1300f+ys,pa)
        c.drawBitmap(nub5,100f+xs,1200f+ys,pa)
        c.drawBitmap(nub6,850f+xs,1000f+ys,pa)
        c.drawBitmap(nub7,650f+xs,1200f+ys,pa)
        c.drawBitmap(nub8,700f+xs,100f+ys,pa)


    }
}