package org.seekers.example

import org.seekers.grpc.SeekersClient
import org.seekers.plugin.LanguageLoader

object ExampleLoader: LanguageLoader {
    override fun recognizedPatterns(): Collection<String> {
        return listOf(".abc", ".xyz") // TODO Add your patterns here
    }

    override fun create(): SeekersClient {
        return ExampleClient() // TODO Create a new instance of your client
    }
}
