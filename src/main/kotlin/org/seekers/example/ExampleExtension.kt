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