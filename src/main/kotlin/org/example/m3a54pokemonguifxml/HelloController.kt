package org.example.m3a54pokemonguifxml

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import model.Pokemon
import model.PokemonType
import java.io.File


class HelloController {

    var llistaPokemons: MutableList<Pokemon> = llegirDadesFitxer()
    var indexPokemon: Int = 0
    var pokemonActual: Pokemon = llistaPokemons[0]
    val imagenes: MutableList<String> = mutableListOf(
        "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png",
        "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/002.png",
        "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/003.png",
        "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/004.png",
        "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/005.png",
        "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/006.png",
        "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/007.png",
        "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/008.png",
        "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/009.png"
    )


    //GUI
    @FXML private lateinit var valueId: Label
    @FXML private lateinit var valueNombre: Label
    @FXML private lateinit var valueNombreG: Label
    @FXML private lateinit var valueTipo1: Label
    @FXML private lateinit var valueTipo2: Label
    @FXML private lateinit var valueTotal: Label
    @FXML private lateinit var valueHp: Label
    @FXML private lateinit var valueAtack: Label
    @FXML private lateinit var valueDefense: Label
    @FXML private lateinit var valueSpcAttack: Label
    @FXML private lateinit var valueSpcDefense: Label
    @FXML private lateinit var valueSpeed: Label
    @FXML private lateinit var imagenView: ImageView


    //buttons
    @FXML private lateinit var btnLeft: Button
    @FXML private lateinit var btnRight: Button


    //Panels
    @FXML private lateinit var paneTipo1: StackPane
    @FXML private lateinit var paneTipo2: StackPane

    @FXML
    fun initialize() {
        updateDades()
    }


    /**
     * Mètode que és cridat quan es prem la fletxa dreta. Canvia de pokemon posterior.
     */
    @FXML
    fun onRightButtonClick() {
        //si el pokemon actual és el primer, que passi a l'últim
        if (indexPokemon == llistaPokemons.size - 1) {
            indexPokemon = 0
        } else {
            indexPokemon++
        }

        pokemonActual = llistaPokemons[indexPokemon]
        updateDades()
    }

    /**
     * Mètode que és cridat quan es prem la fletxa esquerra. Canvia de pokemon anterior.
     */
    @FXML
    fun onLeftButtonClick() {
        //si el pokemon actual l'últim, que passi al primer
        if (indexPokemon == 0) {
            indexPokemon = llistaPokemons.size - 1
        } else {
            indexPokemon--
        }

        pokemonActual = llistaPokemons[indexPokemon]
        updateDades()
    }


    /**
     * Mètode que modifica les dades de la GUI per les del pokemonActual
     */
    private fun updateDades() {

        valueId.text = "N.º 000" + pokemonActual.getID().toString()
        valueNombre.text = pokemonActual.getnName()
        valueNombreG.text = valueNombre.text.uppercase()
        valueTipo1.text = pokemonActual.getTypeOne()
        valueTipo2.text = pokemonActual.getTypeTwo()
        valueTotal.text = pokemonActual.getTOtal().toString()
        valueHp.text = pokemonActual.gethp().toString()
        valueAtack.text = pokemonActual.getAtack().toString()
        valueDefense.text = pokemonActual.getDefensa().toString()
        valueSpcAttack.text = pokemonActual.getSPcAtack().toString()
        valueSpcDefense.text = pokemonActual.getSpcDEfense().toString()
        valueSpeed.text = pokemonActual.getSPeed().toString()
        val image = Image(imagenes[indexPokemon])
        imagenView.image = image

        colorejarTipus()

    }

    /**
     * Mètode que li canvia el color de fons al panell on estan els tipus
     */
    private fun colorejarTipus() {
        //a partir del String tipus faig que em retorni un enum
        val enumTipo: PokemonType = PokemonType.valueOf(valueTipo1.text.uppercase())

        paneTipo1.style = "-fx-background-color: ${enumTipo.backgroundColor};"
        paneTipo1.style += "-fx-background-radius: 5;"

        //comprovo si té segon tipus
        if(pokemonActual.getTypeTwo() != "") {
            paneTipo2.opacity = 100.00
            val enumTipo2: PokemonType = PokemonType.valueOf(valueTipo2.text.uppercase())

            paneTipo2.style = "-fx-background-color: ${enumTipo2.backgroundColor};"
            paneTipo2.style += "-fx-background-radius: 5;"
        } else {
            //si no té segon tipus amago el panel (baixo l'opacitat)
            paneTipo2.opacity = 0.0
        }


    }

    //FITXERS
    private fun llegirDadesFitxer(): MutableList<Pokemon> {
        var pokemons: MutableList<Pokemon> = mutableListOf()
        val fitxer: File = llegirFitxer()

        //llegeixo cada una de les línies (dades d'un pokemon) del fitxer
        fitxer.forEachLine {
            var valors: List<String> = it.split(",")

            //creo un pokemon amb les dades del fitxer
            val pokemon: Pokemon = Pokemon(
                valors[0].toInt(),
                valors[1],
                valors[2],
                valors[3],
                valors[4].toInt(),
                valors[5].toInt(),
                valors[6].toInt(),
                valors[7].toInt(),
                valors[8].toInt(),
                valors[9].toInt(),
                valors[10].toInt(),
                valors[11].toInt(),
                valors[12].toBoolean(),
            )

            pokemons.add(pokemon)
        }

        return pokemons
    }

    private fun llegirFitxer(): File {
        val carpeta: File = File("src/files")
        val fitxer: File = File(carpeta, "Pokemons.csv")


        if (!carpeta.exists()) {
            carpeta.mkdirs()
        }

        if (!fitxer.exists()) {
            fitxer.createNewFile()
        }

        return fitxer
    }


}