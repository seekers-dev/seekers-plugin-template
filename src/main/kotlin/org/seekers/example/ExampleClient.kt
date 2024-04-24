/*
 * Copyright (C) 2024  Seekers Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.seekers.example

import io.grpc.ManagedChannelBuilder
import io.grpc.ManagedChannel
import org.seekers.grpc.SeekersClient
import org.seekers.grpc.net.JoinRequest
import org.seekers.grpc.net.SeekersGrpc
import org.seekers.grpc.net.SeekersGrpc.SeekersBlockingStub
import java.io.File
import java.io.IOException

class ExampleClient: SeekersClient {

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
