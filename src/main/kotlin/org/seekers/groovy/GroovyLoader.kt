package org.seekers.groovy

import org.seekers.grpc.SeekersClient
import org.seekers.plugin.LanguageLoader

class GroovyLoader: LanguageLoader {
    override fun recognizedPatterns(): Collection<String> {
        return listOf(".groovy") // TODO Add your patterns here
    }

    override fun create(): SeekersClient {
        return GroovyClient() // TODO Create a new instance of your client
    }
}
