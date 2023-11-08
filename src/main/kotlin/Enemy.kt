
open class EnemyAction(val name: String, val damage: Int)
class StabwaffenSchuss : EnemyAction("Stabwaffen Schuss", 25)
class TacTac : EnemyAction("Tacluchnatagamuntoron", 55)
class Cannon : EnemyAction("Goa'uld Cannon", 40)

class Schlag : EnemyAction("Schlag", 15)
class HandGerät : EnemyAction("Kara'Kesh", 60)
class Zetnitika : EnemyAction("Zat'ni katel", 25)
class AlkeshBomber : EnemyAction("Alkesh Bomber", 100)

class Todesgleiter : EnemyAction("Todesgleiter", 80)
class PlasmaRepeater : EnemyAction("Plasma-Repeater", 30)

class Debuff( name: String, damage: Int) : EnemyAction(name, damage) {
   /* init {
        applyDebuff(target)
    }
    */

}


// Die möglichen Aktionen, die der Feind ausführen kann, werden in einer Liste gespeichert.
// Diese Liste enthält Aktionen wie "Schlag" und "Stabwaffe" als vordefinierte Instanzen.
open class Enemy(var name: String, var healthPoints: Int) {

    val enemyName = name


    fun randomAction(attacks: List<EnemyAction>): Int {
        val randomAttacks = attacks.random()
        val actionName = randomAttacks.name
        println("Der Feind ${enemyName} greift mit $actionName an und verursacht ${randomAttacks.damage} Schadenspunkte")
        return randomAttacks.damage
    }


    open fun takeDamage(damage: Int) {
            if (healthPoints <= 0) {
                return
            }

            healthPoints -= damage

            if (healthPoints <= 0) {
                println("Der Boss ist besiegt!")
            }
        }
}

open class FootSoldier(name: String, healthPoints: Int) : Enemy(name, healthPoints) {

}

//Nur zum Testen genutzt
fun printInfoList(footSoldiers: MutableList<FootSoldier>) {
    for (footSoldier in footSoldiers) {
        println(" Health Points = ${footSoldier.healthPoints}")
    }
}

open class Boss(name: String, healthPoints: Int,var summonend: Boolean) : Enemy(name, healthPoints) {

    fun bossRandomAction(): Int {
        println("Name:$name")
        println("HP:$healthPoints")
        println()
        println("$name macht seinen Angriff")
        println()
        return randomAction(bossActions)
    }

    open fun summonLowHealth() {

        bossPlusMinion.add(kullWarrior)
        BossBaal.summonend = true

        println("Hahaha du dachtest schon du hast gewonnen, aber hier kommt mein Kull Krieger")

    }
}

open class Minion(name: String, healthPoints: Int, summonend: Boolean) : Boss(name, healthPoints,summonend) {
    override fun takeDamage(damage: Int) {
        if (healthPoints <= 0) {
            return
        }

        healthPoints -= damage

        if (healthPoints <= 0) {
            println("Der MiniBoss ist besiegt!")
        }
    }

    fun minionRandomAction(): Int {
        println("Name:$name")
        println("HP:$healthPoints")
        println()
        println("$name macht seinen Angriff")
        println()
        return randomAction(minionActions)
    }
}
