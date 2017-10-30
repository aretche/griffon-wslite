package io.github.aretche.griffonWslite

import griffon.core.artifact.GriffonService
import wslite.rest.RESTClient
import wslite.rest.Response

/**
 * Created by arellanog on 30/10/17.
 */
@javax.inject.Singleton
@griffon.metadata.ArtifactProviderFor(GriffonService)
class GriffonWsliteService {

    GriffonWsliteModel getInscripcionAFIP(String cuit){
        def inscripcion
        RESTClient client = new RESTClient("https://soa.afip.gob.ar/sr-padron/v2/persona")
        Response response = client.get(path: "/${cuit}")

        if(response?.json?.success){
            inscripcion = new GriffonWsliteModel(response.json.data)
        } else {
            println response.dump()
        }
        inscripcion
    }
}
