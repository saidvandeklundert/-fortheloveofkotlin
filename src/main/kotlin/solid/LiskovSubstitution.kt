package solid

/**
 * Liskov Substitution Principle
 *
 * You should be able to replace objects in a program with
 * instances of their subtypes without altering the correctness of
 * the program.


 * Subtypes must be substitutable for their base types. To be substitutable,
 * the subtype must behave like its supertype.
 */

/**
 * This is a bad Interface since not all birds can fly.
 */
abstract class badBird{
    abstract fun fly()

    abstract fun layEggs()
}

class badOwl():badBird(){
    override fun fly() {
        println("Flying")
    }

    override fun layEggs() {
        println("Laying eggs")
    }

}

class badOstrich():badBird(){
    override fun fly() {
        throw UnsupportedOperationException("Ostriches can't fly")
    }

    override fun layEggs() {
        println("Laying eggs")
    }

}


/**
 * This is a good interface since all birds can lay eggs.
 *
 * We create another interface that extends the first one to be used for all flying birds.
 */
abstract class Bird(){
    abstract fun layEggs()
}

abstract class FlyingBird():Bird(){
    abstract fun fly()
}

class Owl():FlyingBird(){
    override fun fly() {
        println("Flying")
    }

    override fun layEggs() {
        println("Laying eggs")
    }

}

class Ostrich():Bird(){
    override fun layEggs() {
        println("Laying eggs")
    }

}


fun liskovSubstitutionExample() {
    val ostrich = Ostrich()
    ostrich.layEggs()

}