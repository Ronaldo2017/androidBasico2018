package tibaes.com.friends.project.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_lista_amigo.*
import tibaes.com.friends.R
import tibaes.com.friends.project.adapter.AmigoRecyclerAdapter
import tibaes.com.friends.project.db.Friend
import tibaes.com.friends.project.viewmodel.FriendViewModel

class ListaAmigoActivity : AppCompatActivity() {

    private lateinit var friendViewModel: FriendViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_amigo)

        //val friend = Friend(1 , "Juliana")
        //val friend2 = Friend(nome = "Juliana", telefone = "9999-9999", id = 2)


        val recyclerView = rvListaAmigo
        val adapter = AmigoRecyclerAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        friendViewModel =
                ViewModelProviders.of(this).
                        get(FriendViewModel::class.java)

        friendViewModel.allFriends.observe(this, Observer {friends->
            friends?.let { adapter.setFriendList(it) }

        })
    }
}
