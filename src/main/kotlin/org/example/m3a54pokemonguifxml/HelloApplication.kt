package org.example.m3a54pokemonguifxml

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 455.0, 550.0)
        stage.title = "Pokémons!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {

    Application.launch(HelloApplication::class.java)


}


