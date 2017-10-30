package io.github.aretche.griffonWslite

import griffon.core.artifact.GriffonModel
import griffon.transform.FXObservable
import griffon.metadata.ArtifactProviderFor
import groovyx.javafx.beans.FXBindable
import wslite.json.JSONObject

@ArtifactProviderFor(GriffonModel)
class GriffonWsliteModel {

    @FXObservable
    String cuitBuscar

    @FXObservable
    String inscripcion

    String cuit
    String nombre
    String domicilio

    GriffonWsliteModel(){}

    GriffonWsliteModel(JSONObject object){
        cuitBuscar = ""
        inscripcion = ""
        if(object?.idPersona){
            cuit = object?.idPersona
            inscripcion += "CUIT: ${cuit}"
        }
        if(object?.nombre){
            nombre = object.nombre
            inscripcion += "\nNombre: ${nombre}"
        }
        if(object?.domicilioFiscal?.direccion){
            domicilio = object.domicilioFiscal.direccion
            inscripcion += "\nDomicilio: ${domicilio}"
        }
    }
}