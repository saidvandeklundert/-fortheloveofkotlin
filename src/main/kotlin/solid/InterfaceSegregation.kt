package solid

/**
 * Interfaces should be small. The smaller, the better.

 * Ideally, clients should not be forced to take on methods they do not need.
 */


/**
 * This interface is too big. Animals that cannot do both exist.
 */
interface BadMovement{
    fun fly()
    fun swim()
}



/**
 * The following interfaces are smaller and more specific.
 */
interface Walker{
    fun walk()
}

interface WalkAndSwim: Walker{
    fun swim()
}

class Penguin(): WalkAndSwim{
    override fun walk() {
        println("Walking")
    }

    override fun swim() {
        println("Swimming")
    }
}


class Dog(): Walker{
    override fun walk() {
        println("Walking")
    }
}
fun interfaceSegregationExample(){
    val penguin = Penguin()
    penguin.swim()
    penguin.walk()

    val dog = Dog()
    dog.walk()
}