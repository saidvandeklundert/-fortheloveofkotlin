package serialization


/**
 * This example class serves to illustrate how to use Jackson to serialize and deserialize
 */
data class Person (
    val id: Int,
    val name: String,
    val email: String,
    val age: Int
)