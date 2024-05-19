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

import org.seekers.grpc.SeekersClient
import org.seekers.plugin.ClientLoader

object ExampleLoader: ClientLoader {
    override fun recognizedPatterns(): Collection<String> {
        return listOf(".abc", ".xyz") // TODO Add your patterns here
    }

    override fun create(): SeekersClient {
        return ExampleClient() // TODO Create a new instance of your client
    }
}
