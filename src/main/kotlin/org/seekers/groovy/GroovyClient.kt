package org.seekers.groovy

import io.grpc.ManagedChannelBuilder
import io.grpc.ManagedChannel
import org.seekers.grpc.SeekersClient
import org.seekers.grpc.net.JoinRequest
import org.seekers.grpc.net.SeekersGrpc
import org.seekers.grpc.net.SeekersGrpc.SeekersBlockingStub
import java.io.File
import java.io.IOException

class GroovyClient: SeekersClient {

    private val channel: ManagedChannel = ManagedChannelBuilder.forAddress("localhost", 8888)
        .usePlaintext().build()
    private val stub: SeekersBlockingStub = SeekersGrpc.newBlockingStub(channel)

    override fun host(file: File) {
        // TODO Host the file
        stub.join(JoinRequest.newBuilder().build())
    }

    @Throws(IOException::class)
    override fun close() {
        // TODO Close the resource
        channel.shutdown()
    }
}
