package org.seekers.example

import org.ini4j.Profile
import org.pf4j.Extension
import org.seekers.plugin.LanguageLoader
import org.seekers.plugin.SeekersExtension

@Extension
class ExampleExtension: SeekersExtension {
    override fun setup(section: Profile.Section?) {
        // TODO Setup your plugin with the properties of the section
    }

    override fun addLanguageLoaders(loaders: MutableList<LanguageLoader>) {
        // TODO Add here your language loaders
        loaders.add(ExampleLoader)
    }
}