package io.github.aretche.griffonWslite

import griffon.core.artifact.GriffonView
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor
import javafx.scene.Scene
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import javafx.stage.Stage
import org.kordamp.ikonli.fontawesome.FontAwesome
import org.kordamp.ikonli.javafx.FontIcon

import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonView)
class GriffonWsliteView {
    @MVCMember @Nonnull
    FactoryBuilderSupport builder
    @MVCMember @Nonnull
    GriffonWsliteModel model

    private TabPane tabPane

    @Override
    void initUI() {
        // Stage sería la ventana
        Stage stage = (Stage) application.createApplicationContainer([:])
        // Definimos el título de la ventana
        stage.title = application.configuration.getAsString('application.title')
        // Definimos el tamaño de la ventana
        stage.width = 640
        stage.height = 480
        // Deshabilitamos el botón de maximizar
        stage.setResizable(false)

        stage.scene = init()

        // Creo un tab usando GroovyFX
        Tab tab1 = new Tab(text: application.messageSource.getMessage('wsLite.tabAFIP.label'))
        builder.with {
            content = anchorPane {
                vbox(leftAnchor: 20, prefWidth: 600){
                    hbox{
                        toolBar(hgrow: 'always') {
                            label(text: application.messageSource.getMessage('wsLite.cuit.label'))
                            textField(prefWidth: 150, text: bind(model.cuitBuscarProperty()))
                            button(text: application.messageSource.getMessage('wsLite.searchButton.label'),
                                    buscarAction)
                        }
                    }
                    textArea(prefHeight: 360, prefWidth: 600,
                            text: bind(model.inscripcionProperty()))
                }
            }
        }
        tab1.graphic = new FontIcon(FontAwesome.TWITTER)
        tab1.content = builder.content
        tab1.closable = false
        tabPane.tabs.add(tab1)

        application.windowManager.attach('mainWindow', stage)
    }

    // Construye la Interfaz
    private Scene init() {
        tabPane = new TabPane()
        Scene scene = new Scene(tabPane)
        scene.fill = Color.WHITE
        scene
    }

}