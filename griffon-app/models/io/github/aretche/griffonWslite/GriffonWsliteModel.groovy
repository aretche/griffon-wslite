package io.github.aretche.griffonWslite

import griffon.core.artifact.GriffonModel
import griffon.transform.FXObservable
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonModel)
class GriffonWsliteModel {
    @FXObservable String clickCount = "0"
}