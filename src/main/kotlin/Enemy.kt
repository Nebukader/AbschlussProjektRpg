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

class Debuff(private var target: Hero, name: String, damage: Int) : EnemyAction(name, damage) {
    init {
        fun debuffHealth(target: Hero) {
            val originalHealthPoints = target.healthPoints
            val debuffHealthPoints: Int = originalHealthPoints / 100 * 10
            if (target.debuff == true) {
                println(" Du wurdest mit Naniten infiziert und verlierst jede Runde 10% Lebenspunkte")
                if (target.healthPoints < originalHealthPoints * 0.2)
                    target.debuff = false
                print("Du bist nicht mehr infiziert deine Lebenspuntke betragen aber nur noch :${target.healthPoints} Lebenspunkte")
            } else
                target.healthPoints -= debuffHealthPoints
            println("Du wirst schwächer du verlierst $debuffHealthPoints Lebenspunkte")
            target.debuff = true
        }
    }
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
        healthPoints -= damage
        if (damage == 0) {
            println()
        } else
            if (healthPoints <= 0) {
                println("Der Feind ist tot")

            } else
                println("Der $name hat noch $healthPoints Lebenspunkte")
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
        println("$name macht seinen Angriff")
        return randomAction(bossActions)
    }

    open fun summonLowHealth() {

        bossPlusMinion.add(kullWarrior)
        BossBaal.summonend = true

        println("Hahaha du dachtest schon du hast gewonnen, aber hier kommt mein Kull Krieger")

    }
}

open class Minion(name: String, healthPoints: Int, summonend: Boolean) : Boss(name, healthPoints,summonend) {
    fun minionRandomAction(): Int {
        println("Der $name macht seinen Angriff")
        return randomAction(minionActions)
    }
}
