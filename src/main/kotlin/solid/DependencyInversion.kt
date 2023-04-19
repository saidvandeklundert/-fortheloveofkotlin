package solid

/**
 * Do not depend on low-level implementations, rather,  rely on high-level abstractions.
 *
 * Goes hand in hand with dependancy injection, where components that have other components
 * 'injected' into them do not have to worry about constructing them.
 */


/**
 * In the following example, the Badrobot depends on a concretion.
 *
 * Instead of depending on a concretion, we should depend on an abstraction.
 *
 * Problem here is we cannot swap out the weapon for another type.
 */
class BadLaser(val damage:Int=100){
    fun fire(){
        println("Firing laser for $damage damage")
    }
}

class BadRobot(val name:String){
    val laser = BadLaser()
    fun fireLaser(){
        laser.fire()
    }
}


/**
 * The proper way would be to have the robot use an abstraction. For instance, make it use something
 * of the type Weapon, which is an Interface.
 *
 * Then, all the different weapons can implement the Weapon interface.
 *
 * We can also use dependency injection, by constructing the weapon outside the robot and
 * 'inject' it as a parameter.
 */

interface Weapon{
    fun fire()
}

class Laser(val damage:Int=100):Weapon{
    override fun fire() {
        println("Firing laser for $damage damage")
    }
}

class Shotgun(val damage:Int=10):Weapon{
    override fun fire() {
        println("Firing shotgun for $damage damage")
    }
}

class Robot(val name:String, val weapon:Weapon){
    fun fireWeapon(){
        weapon.fire()
    }
}

fun dependancyInversionExample(){

    val robot = BadRobot("R2D2")
    robot.fireLaser()


    val shotgun = Shotgun()
    val shotgunRobot = Robot("R2D2", shotgun)
    shotgunRobot.fireWeapon()
    val laser = Laser()
    val laserRobot = Robot("R2D2", laser)
    laserRobot.fireWeapon()
}