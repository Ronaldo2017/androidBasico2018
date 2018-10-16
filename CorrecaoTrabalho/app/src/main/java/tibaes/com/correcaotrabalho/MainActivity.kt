package tibaes.com.correcaotrabalho

import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    // variável que será inicializada posteriormente
    lateinit var resultado:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // atribuímos um script quando algum radio button for clicado
        radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            resultado = ""
            // pega o id do radio button (semelhante ao switch case
            when(checkedId){
                /*
                Caso o radio button com checked igual a true, ele irá
                fazer a função associada a ele
                 */
                R.id.rbSoma -> resultado = (txtValor1.text.toString().toDouble() +
                        txtValor2.text.toString().toDouble()).toString()
                R.id.rbSubracao -> resultado = (txtValor1.text.toString().toDouble() -
                        txtValor2.text.toString().toDouble()).toString()
                R.id.rbMultiplicacao -> resultado = (txtValor1.text.toString().toDouble() *
                        txtValor2.text.toString().toDouble()).toString()
                R.id.rbDivisao -> resultado = (txtValor1.text.toString().toDouble() /
                        txtValor2.text.toString().toDouble()).toString()
            }

           exibeResultado()
        }

        sExibe?.setOnClickListener {
            exibeResultado()
        }

        sbKm2Miles.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener {
                    // função para adicionar a função ao alterar o progresso
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                        txtKm.text = (progress.toString() + " Km")
                        txtMiles.text = (" - " + (progress.toDouble()
                                * 1.6).toString() + " mils")

                        // verifica o progresso e mostra o quanto as estrelas serão pintadas
                        if(progress > 20) rbClassificacao.rating = 2.toFloat()
                        else rbClassificacao.rating = 0.toFloat()
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                        //To change body of created functions use File | Settings | File Templates.
                    }

                    // função acionada ao parar o progresso
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        txtKm.text = (seekBar?.progress.toString() + " Km")
                        txtMiles.text = (" - " + (seekBar!!.progress.toDouble()
                                * 1.6).toString() + " mils")

                        // verifica o progresso e mostra o quanto as estrelas serão pintadas
                        if(seekBar.progress > 20) rbClassificacao.rating = 2.toFloat()
                        else rbClassificacao.rating = 0.toFloat()
                    }

                })
    }

    private fun exibeResultado(){
        /*
           Verifica se o switch está como true, caso esteja
           irá exibir o resultado no campo txtResultado
           Caso contrário, irá mostrar o resultado em aviso
            */
        if(sExibe.isChecked){
            Toast.makeText(this, resultado, Toast.LENGTH_LONG)
            txtResultado.text = ""
        }
        else {
            txtResultado.text = resultado
        }
    }
}
