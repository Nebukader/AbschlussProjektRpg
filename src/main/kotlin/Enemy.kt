
open class EnemyAction(val name: String, val damage: Int)
// **Definiert die verschiedenen Angriffe der Feinde**
class StabwaffenSchuss : EnemyAction("Stabwaffen Schuss", 25)
class TacTac : EnemyAction("Tacluchnatagamuntoron", 55)
class Cannon : EnemyAction("Goa'uld Cannon", 40)

class Schlag : EnemyAction("Schlag", 15)
class HandGeraet : EnemyAction("Kara'Kesh", 60)
class Zetnitika : EnemyAction("Zat'ni katel", 25)
class AlkeshBomber : EnemyAction("Alkesh Bomber", 100)

class Todesgleiter : EnemyAction("Todesgleiter", 80)
class PlasmaRepeater : EnemyAction("Plasma-Repeater", 30)

class Debuff( name: String, damage: Int) : EnemyAction(name, damage)


// Die möglichen Aktionen, die der Feind ausführen kann, werden in einer Liste gespeichert.
// Diese Liste enthält Aktionen wie "Schlag" und "Stabwaffe" als vordefinierte Instanzen.
// **Basisklasse für alle Feinde**
open class Enemy(var name: String, var healthPoints: Int) {

    // **Speichert den Namen des Feindes**
    private val enemyName = name

    // **Wählt einen zufälligen Angriff aus der Liste der möglichen Angriffe**
    fun randomAction(attacks: List<EnemyAction>): Int {
        val randomAttacks = attacks.random()
        val actionName = randomAttacks.name
        println("Der Feind $enemyName greift mit $actionName an und verursacht ${randomAttacks.damage} Schadenspunkte")

        return randomAttacks.damage
    }

    // **Verringert die Gesundheitspunkte des Feindes um den angegebenen Wert**
    open fun takeDamage(damage: Int) {
        if (healthPoints <= 0) {
            return
        }

        healthPoints -= damage

        if (healthPoints <= 0) {
            println("Der gegner $name ist besiegt!")
        }
    }
}

// **Erbt von der Klasse Enemy**
open class FootSoldier(name: String, healthPoints: Int) : Enemy(name, healthPoints){
    override fun takeDamage(damage: Int) {

        super.takeDamage(damage)
    }
}

// **Erbt von der Klasse Enemy**
open class Boss(name: String, healthPoints: Int,var summonend: Boolean) : Enemy(name, healthPoints) {

    // **Gibt den Namen und die Gesundheitspunkte des Bosses aus**
    open fun bossRandomAction(): Int {
        println()
        println("Name:$name")
        println("HP:$healthPoints")
        println()
        println("$name macht seinen Angriff")
        println()
        return randomAction(bossActions)
    }

    // **Ruft die Methode summonLowHealth auf**
    open fun summonLowHealth() {

        bossPlusMinion.add(kullWarrior)
        BossBaal.summonend = true

        println("Hahaha du dachtest schon du hast gewonnen, aber hier kommt mein Kull Krieger")

    }

}

// **Erbt von der Klasse Boss**
open class Minion(name: String, healthPoints: Int, summonend: Boolean) : Boss(name, healthPoints,summonend) {

    // **Verringert die Gesundheitspunkte des Minions um den angegebenen Wert**
    override fun takeDamage(damage: Int) {
        if (healthPoints <= 0) {
            return
        }

        healthPoints -= damage

        if (healthPoints <= 0) {
            println("Der MiniBoss ist besiegt!")
        }
    }

    override fun bossRandomAction(): Int {
        println()
        println("Name:$name")
        println("HP:$healthPoints")
        println()
        println("$name macht seinen Angriff")
        println()
        return randomAction(minionActions)
        return super.bossRandomAction()
    }

}
