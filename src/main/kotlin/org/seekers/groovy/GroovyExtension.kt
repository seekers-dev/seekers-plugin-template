package org.seekers.groovy

import org.seekers.plugin.LanguageLoader
import org.seekers.plugin.SeekersExtension

class GroovyExtension: SeekersExtension {
    override fun addLanguageLoaders(loaders: MutableList<LanguageLoader>) {
        // TODO Add here your language loaders
        loaders.add(GroovyLoader())
    }
}