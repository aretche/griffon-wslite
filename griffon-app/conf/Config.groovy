application {
    title = 'griffon-wslite'
    startupGroups = ['griffonWslite']
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "griffonWslite"
    'griffonWslite' {
        model      = 'io.github.aretche.griffonWslite.GriffonWsliteModel'
        view       = 'io.github.aretche.griffonWslite.GriffonWsliteView'
        controller = 'io.github.aretche.griffonWslite.GriffonWsliteController'
    }
}