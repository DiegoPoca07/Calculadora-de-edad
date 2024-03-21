package diego.rodriguez.calculandoedad

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtedad = findViewById<TextView>(R.id.txtedad)
        val btncalculando = findViewById<Button>(R.id.btncalculando)
        val txtresultado = findViewById<TextView>(R.id.txtresultado)
        val obj = Calcular()

        btncalculando.setOnClickListener {
            val result = obj.Sumar(txtedad.text.toString().toInt())
            txtresultado.text = "Su edad es: $result"
            Toast.makeText(this, "Su edad es: $result", Toast.LENGTH_LONG).show()
        }

    }
}