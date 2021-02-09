package com.ricardocanales.moviesrcm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ricardocanales.moviesrcm.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieSelectionListener {

    private val moviesList = ArrayList<Movie>()
    private var customAdapter: CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateList()

        my_recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        customAdapter = CustomAdapter(moviesList,this)

        //assign adapter
        my_recycler_view.adapter = customAdapter

    }

    private fun populateList(){

        //Películas
        moviesList.add(Movie("Bohemian Rhapsody", "Película", "Freddie Mercury desafía los estereotipos y se convierte en uno de los vocalistas más reconocidos de la música mundial. Después de dejar la banda Queen para seguir una carrera como solista, Mercury se reúne con la banda para dar una de las mejores actuaciones en la historia del rock 'n' roll.",1))
        moviesList.add(Movie("Godzilla 2", "Película", "Las aventuras de unos criptzóologos de una agencia mientras tratan de enfrentarse a unos monstruos entre los que se encuentra el propio Godzilla. Entre todos intentarán frenar a estas criaturas que harán todo lo posible por sobrevivir.",2))
        moviesList.add(Movie("A dos metros de ti", "Película", "Stella, de 17 años, está ingresada en un hospital porque padece fibrosis quística. Su monótona existencia cambia cuando llega Will, un adolescente con la misma dolencia. Sin embargo, las normas del hospital prohíben el contacto entre ellos.",3))
        moviesList.add(Movie("Rápidos y furiosos: Hobbs & Shaw", "Película", "El policía Luke Hobbs se une al mercenario Deckard Shaw para luchar contra un terrorista que posee una fuerza sobrenatural, una mente brillante y un patógeno letal que podría aniquilar a la mitad de la población mundial.",4))
        moviesList.add(Movie("It: capítulo dos", "Película", "En el misterioso pueblo de Derry, un payaso llamado Pennywise vuelve 27 años después para atormentar a los ahora adultos miembros del Club de los Perdedores, que se encuentran alejados unos de otros.",5))
        //Serie
        moviesList.add(Movie("The Good Doctor", "Serie", "Un cirujano joven y autista que padece el síndrome del sabio empieza a trabajar en un hospital prestigioso. Allá tendrá que vencer el escepticismo con el que sus colegas lo reciben.",6))
        moviesList.add(Movie("Vikingos", "Serie", "Las aventuras de Ragnar Lothbrok, un vikingo agricultor, mientras asciende para convertirse en el rey de los vikingos.",7))
        moviesList.add(Movie("3%", "Serie", "En un futuro no muy lejano, los ciudadanos luchan por formar parte del grupo de los privilegiados y así evitar caer en la devastación.",8))
        moviesList.add(Movie("Jurassic World: Campamento Cretácico", "Serie", "Unos adolescentes asisten a un campamento de aventuras en el lado opuesto de la isla Nublar y deben unirse para sobrevivir cuando los dinosaurios causan estragos en la isla.",9))
        moviesList.add(Movie("Élite", "Serie", "Las Encinas es el colegio más exclusivo de España, el lugar donde estudian los hijos de la élite y donde acaban de ser admitidos tres jóvenes de clase baja, procedentes de un colegio público en ruinas.",10))
    }

    override fun onMovieSelected(movieIndex: Int) {
        val movieSelected = moviesList[movieIndex]
        val detailIntent = Intent(this,DetailActivity::class.java)

        detailIntent.putExtra("movieSelected",movieSelected)
        startActivity(detailIntent)
    }
}