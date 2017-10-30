package io.github.aretche.griffonWslite

import griffon.core.artifact.GriffonController
import griffon.core.controller.ControllerAction
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor
import griffon.transform.Threading
import javax.annotation.Nonnull
import javax.inject.Inject

@ArtifactProviderFor(GriffonController)
class GriffonWsliteController {
    @MVCMember @Nonnull
    GriffonWsliteModel model

    @Inject
    private GriffonWsliteService griffonWsliteService

    @ControllerAction
    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    void buscar() {
        println "llamando ${model.cuitBuscar}..."
        def respuesta = griffonWsliteService.getInscripcionAFIP(model.cuitBuscar)
        println respuesta
        if(respuesta){
            model.inscripcion = respuesta.inscripcion
        } else {
            model.inscripcion = "No se encontró inscripción para el cuit ${model.cuitBuscar}"
        }
    }
}