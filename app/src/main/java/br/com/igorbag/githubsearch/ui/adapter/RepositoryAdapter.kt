package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository
import android.widget.ImageButton
import android.widget.TextView

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var carItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //@TODO 8 -  Realizar o bind do viewHolder
        val repository = repositories[position]

        // Preencha os elementos do ViewHolder com dados do repositório
        holder.nomeDoRepositorio.text = repository.name

        // Define um clique no item
        holder.itemView.setOnClickListener {
            carItemLister(repository)
        }

        // Define um clique no botão Share
        holder.btnShare.setOnClickListener {
            btnShareLister(repository)
        }
    }

    // Pega a quantidade de repositorios da lista
    //@TODO 9 - realizar a contagem da lista
    override fun getItemCount(): Int {
        return repositories.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //@TODO 10 - Implementar o ViewHolder para os repositorios

        val nomeDoRepositorio: TextView = view.findViewById(R.id.repo_name)
        val btnShare: ImageButton = view.findViewById(R.id.btn_share)
    }
}


