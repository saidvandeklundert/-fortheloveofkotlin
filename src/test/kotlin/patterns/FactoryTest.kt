package patterns


import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

internal class FactoryTest {

    @Test
    fun testFunctionalFactoryClayGolem() {
        val golem = functionalFactory("clay")
        assertEquals(100, golem.hitPoints)
        assertEquals(10, golem.attackPower)
        assertIs<ClayGolem>(golem)
    }
    @Test
    fun testFunctionalFactoryFireGolem() {
        val golem = functionalFactory("fire")
        assertEquals(200, golem.hitPoints)
        assertEquals(20, golem.attackPower)
        assertIs<FireGolem>(golem)
    }

    @Test
    fun testselectGolemFactory() {
        val factory = selectGolemFactory("clay")
        val golem = factory.createGolem()
        assertIs<ClayGolemFactory>(factory)
        assertIs<ClayGolem>(golem)

    }
}
