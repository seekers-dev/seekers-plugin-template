package org.seekers.groovy

import groovy.lang.GroovyClassLoader
import groovy.lang.GroovyObject
import org.junit.Test

class TestGroovy {
    @Test
    fun executeFunction() {
        val loader = GroovyClassLoader()

        val type = loader.parseClass(javaClass.getResource("TestClass.groovy")!!.toExternalForm())
        val constructor = type.getConstructor()
        val instance = constructor.newInstance() as GroovyObject
        instance.invokeMethod("execute", instance)
    }
}
