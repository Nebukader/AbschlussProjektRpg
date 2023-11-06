open class EnemyAction(val name:String,val damage:Int)
class StabwaffenSchuss : EnemyAction ("Stabwaffen Schuss",25)
class TacTac : EnemyAction("Tacluchnatagamuntoron",55)
class Cannon : EnemyAction("Goa'uld Cannon",40)

class Schlag : EnemyAction ("Schlag",15)
class HandGerät : EnemyAction ("Kara'Kesh", 60)
class Zetnitika : EnemyAction ("Zat'ni katel",25)
class AlkeshBomber : EnemyAction ("Alkesh Bomber", 100)

class Todesgleiter : EnemyAction ("Todesgleiter", 80)

// Die möglichen Aktionen, die der Feind ausführen kann, werden in einer Liste gespeichert.
// Diese Liste enthält Aktionen wie "Schlag" und "Stabwaffe" als vordefinierte Instanzen.
open class Enemy(var name: String, var healthPoints: Int) {

    private val enemyName = name


    fun randomAction(attacks:List<EnemyAction>): Int {
        val randomAttacks = attacks.random()
        val actionName = randomAttacks.name
        println("Der Feind greift mit $actionName an und verursacht ${randomAttacks.damage} Schadenspunkte")
        return randomAttacks.damage
    }


    open fun takeDamage(damage: Int) {
        healthPoints -= damage
        if (healthPoints <= 0) {
            println("Der Feind ist tot")

        } else
            println("Der $name hat noch $healthPoints Lebenspunkte")
    }
}

open class FootSoldier(name:String, healthPoints: Int) : Enemy(name,healthPoints) {
}

fun printInfoList(footSoldiers:MutableList<FootSoldier>) {
    for (footSoldier in footSoldiers) {
        println("${footSoldier.name}: Health Points = ${footSoldier.healthPoints}")
    }
}

open class Boss(name: String, healthPoints: Int) : Enemy(name, healthPoints){
    val originalHealthPoints:Int = healthPoints
    fun bossRandomAction(): Int {
        println("$name macht seinen Angriff")
        return randomAction(bossActions)
    }
    fun summonLowHealth(){
        if (healthPoints <-  originalHealthPoints / 2){
            bossPlusMinion.add(Minion("Kull Krieger",300))
            println("Hahaha du dachtest schon du hast gewonnen, aber hier kommt mein Kull Krieger")
        }
    }
}

class Minion(name: String, healthPoints: Int) : Boss(name, healthPoints){

}




/*val jaffa: Minion = Minion("Jaffa foot Soldier", 150)

val apophis: Enemy = Enemy("Apohis", 200)
val baal: Enemy = Enemy("Baal", 225)
val ra: Enemy = Enemy("Ra", 300)
val heruur: Enemy = Enemy("Heru´ur", 220)*/