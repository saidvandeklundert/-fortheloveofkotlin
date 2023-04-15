package solid

/**
 * This class does not adhere to the Single Responsibility Principle.
 * It has two responsibilities:
 *   1. It stores the name and age
 *   2. It offers a method to store the fields in a database
 *
 * The violation can be deduced by asking whether or not this class only has one reason
 * to change.
 *
 * The class will need to change:
 *  - if the model of HumanWrong changes
 *  - if the database we use changes
 **/
class HumanWrong(val name:String, var age:Int){

    fun introduce(){
        println("Hello, my name is $name and I am $age years old")
    }
    fun storeInDB(){
        println("Storing $name in DB")
    }

}


/**
 * The following classes adhere to the SRP since they do only one thing
 * and they only have one reason to change.
 **/
class Human(val name:String, var age:Int){
    fun introduce(){
        println("Hello, my name is $name and I am $age years old")
    }
}

class HumanRepository(){
    fun storeInDB(human: Human){
        println("Storing ${human.name} in DB")
    }
}


fun singleResponsibilityExample(){
    val jan = HumanWrong("Jan", 7)
    jan.introduce()
    jan.storeInDB()

    val marie = Human("marie", 4)
    marie.introduce()

    val humanRepository = HumanRepository()
    humanRepository.storeInDB(marie)
}
