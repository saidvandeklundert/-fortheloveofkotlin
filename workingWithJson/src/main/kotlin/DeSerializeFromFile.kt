import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import serialization.Person
import java.io.File
import java.io.InputStream
import java.nio.charset.Charset

fun deSerializeWithJacksonFromFile(){
    /*
    * Reading JSON from a file and converting it to a Kotlin object
    */
    val filePath = "src/some_data.json"

    val fileReader: InputStream = File(filePath).inputStream()

    val fileContent:String = fileReader.readBytes().toString(Charset.defaultCharset())

    val objectmapper = jacksonObjectMapper()
    val personsFromJson: Array<Person> = objectmapper.readValue(fileContent)

    for (person in personsFromJson)
        println(person)
}