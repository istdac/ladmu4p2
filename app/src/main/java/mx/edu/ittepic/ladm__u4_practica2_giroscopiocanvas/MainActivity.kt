package mx.edu.ittepic.ladm__u4_practica2_giroscopiocanvas

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var sensorManager: SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        var prox = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        var gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
        println(deviceSensors)
        prox = deviceSensors.find { s -> s.type==Sensor.TYPE_PROXIMITY }
        gyro = deviceSensors.find { s -> s.type==Sensor.TYPE_ACCELEROMETER }
        println(prox)
        setContentView(Lienzo(this,sensorManager,prox,gyro))
    }
}