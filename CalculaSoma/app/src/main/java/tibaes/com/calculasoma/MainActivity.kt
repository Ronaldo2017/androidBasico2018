package tibaes.com.calculasoma

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         *  É possível desenvolver a função do botão através de
         *  uma função anônima no Listener do click
         */
        btnCalcular.setOnClickListener {
            /**
             * O Kotlin possui uma função chamada toDouble que converte o valor
             * String em Double.
             * Essa função faz parte de uma função extendida da classe String,
             * desenvolvida pelo Kotlin
             */
            val resultado = txtValor1.text.toString().toDouble() +
                    txtValor2.text.toString().toDouble()
            /**
             * A classe Toast é responsável por exibir alertas temporários na
             * tela do usuário, podendo ser longo (LENGTH_LONG) ou curto (LENGTH_SHORT)
             * Para o método makeText funcionar, é necessário informar o contexto,
             * que normalmente é a classe de exibição (this), a mensagem de texto que será exibida
             * e a quantidade de tempo que a mensagem será exibida.
             * Por fim, usa-se o show()para mostrar a mensagem na tela.
             */
            //Toast.makeText(this, resultado.toString(), Toast.LENGTH_LONG).show()

            // Uma alternativa é colocar o resultado em um campo de texto na tela.
            txtResultado.text = resultado.toString()
        }
    }

    /*
    * É possível adicionar uma função em um botão, desenvolvendo uma função
    * que receba um objeto View

    fun calcula(v: View){
        /**
         * O Kotlin possui uma função chamada toDouble que converte o valor
         * String em Double.
         * Essa função faz parte de uma função extendida da classe String,
         * desenvolvida pelo Kotlin
         */
        val resultado = txtValor1.text.toString().toDouble() +
                txtValor2.text.toString().toDouble()
        /**
         * A classe Toast é responsável por exibir alertas temporários na
         * tela do usuário, podendo ser longo (LENGTH_LONG) ou curto (LENGTH_SHORT)
         * Para o método makeText funcionar, é necessário informar o contexto,
         * que normalmente é a classe de exibição (this), a mensagem de texto que será exibida
         * e a quantidade de tempo que a mensagem será exibida.
         * Por fim, usa-se o show()para mostrar a mensagem na tela.
         */
        Toast.makeText(this, resultado.toString(), Toast.LENGTH_LONG).show()
    }
    */
}
