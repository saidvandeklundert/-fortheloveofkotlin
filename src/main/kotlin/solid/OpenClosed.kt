package solid

/**
 *  Next example is not good. This is because adding another storage,
 *  type, like DynamoDB, will require us to change the code in this class.
 *
 *  When we start adding the new types of databases, the class will clutter up.
 *
 *  Open Closed means that we should be able to add new functionality without
 *  changing the existing code. It should be
 *
 *  'Open for extension, closed for modification.'
 * */
class BadRepository(val password: String, val hostname: String)    {

    fun storeInPostgres(human: Human){
        println("Storing ${human.name} in Postgres $hostname using password $password")
    }

}

/**
 *  This is better. We have an abstract class that defines the interface
 *  for the repository. We can then create subclasses that implement the
 *  interface for the specific database type.
 *
 *  This is better because we can add new types of databases without
 *  changing the existing code.
 *
 *  Open Closed means that we should be able to add new functionality without
 *  changing the existing code. It should be
 *
 *  'Open for extension, closed for modification.'
 * */

abstract class Repository(){
    abstract fun getHuman(human:Human):Human

    abstract fun putHuman(human:Human):Human

    abstract fun deleteHuman(human:Human)

}

class PostGresRepository(val password:String, val hostname:String):Repository(){
    override fun getHuman(human: Human): Human {
        println("Getting ${human.name} from Postgres $hostname using password $password")
        return human
    }

    override fun putHuman(human: Human): Human {
        println("Putting ${human.name} in Postgres $hostname using password $password")
        return human
    }

    override fun deleteHuman(human: Human) {
        println("Deleting ${human.name} from Postgres $hostname using password $password")
    }

}

class DynamoDBRepository(val tableName:String, val arn:String):Repository(){
    override fun getHuman(human: Human): Human {
        println("Getting ${human.name} from DynamoDB $tableName using arn $arn")
        return human
    }

    override fun putHuman(human: Human): Human {
        println("Putting ${human.name} in DynamoDB $tableName using arn $arn")
        return human
    }

    override fun deleteHuman(human: Human) {
        println("Deleting ${human.name} from DynamoDB $tableName using arn $arn")
    }
}

class RedisRepository(val password:String, val hostname:String):Repository(){
    override fun getHuman(human: Human): Human {
        println("Getting ${human.name} from Redis $hostname using password $password")
        return human
    }

    override fun putHuman(human: Human): Human {
        println("Putting ${human.name} in Redis $hostname using password $password")
        return human
    }

    override fun deleteHuman(human: Human) {
        println("Deleting ${human.name} from Redis $hostname using password $password")
    }

}

fun openClosedExample() {
    println("example for the open closed principle")
    val jan = Human("Jan", 7)
    val badRepo = BadRepository("secret", "postgres01")
    badRepo.storeInPostgres(jan)

    val postgresRepo = PostGresRepository("secret", "postgres01")
    postgresRepo.putHuman(jan)
    postgresRepo.getHuman(jan)

    val ddbRepo = DynamoDBRepository("human-table", "us-east-1:123456789012")
    ddbRepo.putHuman(jan)
    ddbRepo.getHuman(jan)

    val redisRepo = RedisRepository("secret", "redis01")
    redisRepo.putHuman(jan)
    redisRepo.getHuman(jan)
}