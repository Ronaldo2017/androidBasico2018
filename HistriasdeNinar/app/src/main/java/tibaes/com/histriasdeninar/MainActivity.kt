package tibaes.com.histriasdeninar

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * Variáveis para trabalhar com notificações a partir da versão oero
     */
    private val channelId = "tibaes.com.historiasdeninar"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // construindo um array com todos os itens da lista para aparecer no spinner
        // futuramente isso poderá ser uma lista recebida do banco de dados
        var historias = arrayOf("Chapeuzinho Vermelho", "Cinderela", "A bela Adormecida")


        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, historias)

        // adicionando o modelo com a lista de opções no spinner
        sHistoria.adapter = adapter

        sHistoria.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                // pegando o valor do item selecionado no spinner
                val selectedItem = parent.getItemAtPosition(position).toString()

                // para cada posição, iremos adicionar a história e uma imagem ilustrativa
                when (position) {
                    0 -> {
                        // adicionando a história no campo de texto
                        txtResumo.text = (selectedItem + "\nUma menina chamada Chapeuzinho Vermelho foi visitar sua avó " +
                                "que morava distante e estava doente. Sua mãe queria notícias da velha " +
                                "senhora e mandou a filha fazer-lhe uma visita, levando alguns doces. O " +
                                "caminho era longo e passava por uma floresta. Matreiro o Lobo-Mau, " +
                                "dizendo ser o guarda da floresta abordou a menina no caminho, fingindo " +
                                "ser amigo, pois sua intenção era comer a neta e a avó. Ao chegar à casa " +
                                "da avó Chapeuzinho Vermelho foi tomada de surpresa, pois achou-a um tanto " +
                                "diferente de como a conhecia. O Lobo-Mau já tinha comido a velhinha e vestido " +
                                "sua roupa, metendo-se em sua cama esperava para dar o bote final na menina. ")
                        //tornando a imagem visivel
                        imgHistoria.visibility = View.VISIBLE
                        // alterando a imagem. Essa nova imagem está no pacote drawable do projeto
                        imgHistoria.setImageResource(R.drawable.chapeuzinho)
                        // chamando a notificação
                        notificacao()

                    }
                    1 -> {
                        txtResumo.text = (selectedItem + "\nCinderela era filha de um comerciante rico, " +
                                "porém quando seu pai morreu, a madrastamalvada e as duas filhas fizeram " +
                                "Cinderela de criada. Um dia houve um baile, mas Cinderela não poderia ir " +
                                "pois tinha de limpar a casa e não tinha um vestido bonito para usar na" +
                                " festa. Sua fada madrinha apareceu e limpou toda a casa num piscar de " +
                                "olhos e deu um vestido lindo para Cinderela, porém, ele só duraria até " +
                                "meia noite. O príncipe se apaixonou por Cinderela e, na volta para casa, " +
                                "ela deixou cair na escada seu sapatinho de cristal. Querendo encontrá-la, " +
                                "o príncipe ordenou que todas as moças do reino experimentassem o sapato." +
                                " Cinderela experimentou e o sapato serviu. A jovem e o príncipe se casaram " +
                                "e viveram felizes para sempre.")
                        imgHistoria.visibility = View.VISIBLE
                        imgHistoria.setImageResource(R.drawable.cinderela)
                        notificacao()
                    }

                    2 -> {
                        txtResumo.text = (selectedItem + "\nEm um dia ensolarado e feliz,nascia a " +
                                "princesa Aurora.O rei ordenou que fizessem uma grande festa celebrando " +
                                "o nascimento de sua linda herdeira e convidou todas as fadas do reino.Cada " +
                                "fada presenteou a princesinha com um dom: beleza, bondade, alegria, inteligência e amor. \n" +
                                "De repente, apareceu a bruxa Malévola,furiosa por não ter sido convidada " +
                                "para a festa; e lançou uma maldição: \n" +
                                "-Quando a princesa completar quinze anos, espetará o dedo e morrerá! \n" +
                                "A fada Flora que ainda não tinha dado o seu presente, conseguiu modificar" +
                                " o feitiço dizendo: \n" +
                                "-A princesa não morrerá, dormirá um sono profundo, até que o beijo de " +
                                "um principe a desperte. \n" +
                                "Passaram-se os anos, a princesa crescia cada vez mais bela, cheia de " +
                                "bondade, alegria;tornando-se uma jovem muito inteligente e amorosa. \n" +
                                "no dia do seu aniversário de quinze anos,ela resolveu dar um passeio " +
                                "sozinha.Andando pelo palácio,subiu a escada que levava para a torre e " +
                                "lá encontrou uma velha máquina de fiar.Aproximou-se e curiosa, por até" +
                                " então nunca ter visto um instrumento daqueles, resolveu tocá-lo e assim " +
                                "fazendo,espetou o dedo e em seguida caiu num sono profundo. \n" +
                                "Houve um frio silêncio e no mesmo instante, todos no castelo adormeceram." +
                                "O tempo passou e uma imensa floresta cresceu em volta do castelo.Muitos" +
                                " anos depois, em um país vizinho, um principe ouviu falar do misterioso " +
                                "reino adormecido e determinou-seà encontra-lo.Corajoso e muito belo, o " +
                                "principe atravessou a floresta e finalmente encontrou o castelo.Entrou," +
                                " e espantado viu que todos dormiam, desde os criados, os guardas,até os animais. \n" +
                                "O principe também tinha ouvido falar que naquele reino do sono havia uma " +
                                "linda princesa.Subiu a escada da torre e ali encontrou Auroradormindo " +
                                "em uma cama de ouro.Era a mais bela jovem que ele já tinha visto.O principe " +
                                "ficou tão apaixonado , que não se conteve e aproximando-se da bela" +
                                " adormecida, beijou-a carinhosamente. \n" +
                                "No mesmo instante, a princesa Aurora despertou e com ela,o silêncio no " +
                                "castelo foi interrompido pelo canto dos pássaros, um por um no reino foi " +
                                "acordando, como se apenas por uma noite estivessem descansando. \n" +
                                "E assim, o feitiço de Malévola foi quebrado, dias depois, Aurora e o" +
                                " principe se casaram e foram felizes para sempre.")
                        imgHistoria.visibility = View.VISIBLE
                        imgHistoria.setImageResource(R.drawable.belinha)
                        notificacao()
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                imgHistoria.visibility = View.GONE
                txtResumo.text = ""
            }
        }

    }
    /**
     *  Trabalhando com notificações simples
     */
    fun notificacao(){
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val mNotification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, channelId)
        } else {
            Notification.Builder(this)
        }.apply {
            setContentIntent(pendingIntent)
            // adicionando um ícone na notificação
            setSmallIcon(R.drawable.notification_icon_background)
            setAutoCancel(true)
            // título da notificação
            setContentTitle(sHistoria.selectedItem.toString())
            // mensagem da notificação
            setContentText("MESSAGE")
        }.build()
        val mNotificationId: Int = 1000
        val nManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nManager.notify(mNotificationId, mNotification)
    }
}