open class EnemyAction(val name:String,val damage:Int)
class StabwaffenSchuss : EnemyAction ("Stabwaffen Schuss",25)
class TacTac : EnemyAction("Tacluchnatagamuntoron",55)
class Cannon : EnemyAction("Goa'uld Cannon",40)

class Schlag : EnemyAction ("Schlag",15)
class HandGerät : EnemyAction ("Kara'Kesh", 60)
class Zetnitika : EnemyAction ("Zat'ni katel",25)


// Die möglichen Aktionen, die der Feind ausführen kann, werden in einer Liste gespeichert.
// Diese Liste enthält Aktionen wie "Schlag" und "Stabwaffe" als vordefinierte Instanzen.
open class Enemy(var name: String,var healthPoints: Int){
    private val actions = listOf(StabwaffenSchuss(),TacTac(),Cannon(),Schlag(),HandGerät(),Zetnitika())
    private val enemyName = name

    fun randomAction(): Int{
        val randomAttacks = actions.random()
        val actionName = randomAttacks.name
        println("Der Feind greift mit $actionName an ")
        return randomAttacks.damage
    }

    open fun attackInfo(){
        println("${name} holt zum Anrgriff aus")
        println("${randomAction()}")
    }
}

class FootSoldier(name:String,healthPoints: Int) : Enemy(name,healthPoints){
    override fun attackInfo() {
        super.attackInfo()
    }
}

open class Boss(name: String, healthPoints: Int) : Enemy(name, healthPoints){
    override fun attackInfo() {
        super.attackInfo()
    }
}

class Minion(name: String, healthPoints: Int) : Boss(name, healthPoints){
    override fun attackInfo() {
        super.attackInfo()
    }
}


val jaffa: Minion = Minion("Jaffa foot Soldier", 150)

val apophis: Enemy = Enemy("Apohis", 200)
val baal: Enemy = Enemy("Baal", 225)
val ra: Enemy = Enemy("Ra", 300)
val heruur: Enemy = Enemy("Heru´ur", 220)