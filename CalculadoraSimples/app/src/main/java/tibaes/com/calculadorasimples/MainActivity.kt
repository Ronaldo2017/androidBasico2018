package tibaes.com.calculadorasimples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        radioGroup?.setOnCheckedChangeListener { group, checkedId ->

            when (checkedId) {
                R.id.rbSoma -> result = (txtValor1.text.toString().toDouble() + txtValor2.text.toString().toDouble()).toString()
                R.id.rbSubtracao -> result = (txtValor1.text.toString().toDouble() - txtValor2.text.toString().toDouble()).toString()
                R.id.rbMultiplicacao -> result = (txtValor1.text.toString().toDouble() * txtValor2.text.toString().toDouble()).toString()
                R.id.rbDivisao -> result = (txtValor1.text.toString().toDouble() / txtValor2.text.toString().toDouble()).toString()
            }
            exibeResult()
        }

        sAvisoLabel?.setOnClickListener {
            exibeResult()
        }

    }

    fun exibeResult(){
        if (result.isNotEmpty()) {
            if (sAvisoLabel.isChecked) {
                Toast.makeText(this, result, Toast.LENGTH_LONG).show()
                txtResultado.text = ""
            }
            else
                txtResultado.text = result
        }
    }
}
