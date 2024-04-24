package org.seekers.example

import org.seekers.plugin.LanguageLoader
import org.seekers.plugin.SeekersExtension

class ExampleExtension: SeekersExtension {
    override fun addLanguageLoaders(loaders: MutableList<LanguageLoader>) {
        // TODO Add here your language loaders
        loaders.add(ExampleLoader())
    }
}