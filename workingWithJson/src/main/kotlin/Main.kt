import serialization.*



//./gradlew run
fun main(args: Array<String>) {
    println("serialize all the things in Kotlin!")

    println("deserialize:")
    deSerializeWithJackson()
    deSerializeWithJacksonFromFile()
    println("serialize:")
    serializeWithJackson()

}