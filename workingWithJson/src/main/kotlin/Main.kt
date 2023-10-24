import serialization.*
import java.io.File
import java.io.InputStream
import java.nio.charset.Charset

//./gradlew run
fun main(args: Array<String>) {
    println("serialize all the things in Kotlin!")

    println("deserialize:")
    deSerializeWithJackson()
    deSerializeWithJacksonFromFile()
    println("serialize:")

    serializeWithJackson()


}