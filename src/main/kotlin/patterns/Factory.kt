package patterns

abstract class Golem {
    open var hitPoints: Int = 100
    open var attackPower: Int = 10

    abstract fun attack()

    fun takeDamage(damage: Int) {
        this.hitPoints -= damage
        println("Golem took $damage damage, has ${this.hitPoints} hitpoints left")
    }


}

class ClayGolem:Golem(){

    override fun attack() {
        println("Clay Golem attacks for ${this.attackPower} damage")
    }
}

class FireGolem:Golem(){
    override var hitPoints: Int = 200
    override var attackPower: Int = 20

    override fun attack() {
        println("Fire Golem attacks for ${this.attackPower} damage")
    }
}

/**
 * The functional implementation of the factory pattern.
 *
 * Instead of instantiating a factory object, a function is used
 *  to create something of the type Golem.
 */
fun functionalFactory(golemSelection:String):Golem{
    return when(golemSelection){
        "clay" -> ClayGolem()
        "fire" -> FireGolem()
        else -> throw RuntimeException("Golem not found")
    }
}

/**
 * The object oriented implementation of the factory pattern:
 */

interface GolemFactory {
    fun createGolem(): Golem
}

class ClayGolemFactory : GolemFactory {
    override fun createGolem(): ClayGolem {
        return ClayGolem()
    }
}

class FireGolemFactory : GolemFactory {
    override fun createGolem(): FireGolem {
        return FireGolem()
    }
}

fun selectGolemFactory(golemType:String):GolemFactory{
    return when(golemType){
        "clay" -> ClayGolemFactory()
        "fire" -> FireGolemFactory()
        else -> throw RuntimeException("Golem not found")
    }
}

fun factoryExample(){
    var fireGolem = functionalFactory("fire")
    fireGolem.attack()
    fireGolem.takeDamage(40)

    val clayGolemFactory = selectGolemFactory("clay")
    val clayGolem = clayGolemFactory.createGolem()
    clayGolem.attack()
}