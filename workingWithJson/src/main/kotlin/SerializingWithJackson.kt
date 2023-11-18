package serialization

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue



fun deSerializeWithJackson(){
    /*
    * Reading data from a JSON string and converting it to a Kotlin object
    */

    val objectmapper = jacksonObjectMapper()

    val jsonPersons = """
    [
        {
        "id":1012,
        "name":"jan",
        "email":"jan@yolo.com",
        "age":8    
        },
        {
        "id":1013,
        "name":"Marie",
        "email":"marie@yolo.com",
        "age":4
        }        
    ]
    """

    val personsFromJson: Array<Person> = objectmapper.readValue(jsonPersons)
    for (person in personsFromJson)
        println(person)
}


fun serializeWithJackson(){
    /*
    * Creating a few Kotlin objects and converting them to JSON
    */

    var persons = mutableListOf<Person>()
    persons.add(Person(1, "Jan", "jan@gmal.com", 8))
    persons.add(Person(2, "Marie", "marie@gmal.com", 8))

    val mapper = jacksonObjectMapper()

    val serialized_persons = mapper.writeValueAsString(persons)
    print(serialized_persons)


}