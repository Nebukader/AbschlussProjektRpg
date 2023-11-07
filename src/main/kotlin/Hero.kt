open class Hero(val name:String, var healthPoints:Int, var debuff:Boolean = false) {

    open fun action(weaponName: String, damage: Int): Int {
        println("Der Angriff erfolgt $name greift mit seiner $weaponName an und verursacht $damage Schadenspunkte")
        return damage
    }

    open fun takeDamage(damage: Int) {
        healthPoints -= damage
        if (damage == 0) {
            println()
        } else
            if (healthPoints <= 0) {
                println("Der Feind ist tot")

            } else
                println("$name hat noch $healthPoints Lebenspunkte")
    }

    open fun shout(buffHealth: Int) {
        val buff = healthPoints / 100 * 20
        healthPoints + buff
    }
}

// Methode nur zum Testen anfanges gebraucht !
fun printInfoList(hero:MutableList<Hero>) {
    for (hero in heroes) {
        println("${hero.name}: Health Points = ${hero.healthPoints}")
    }
}
class Soldier(name: String,healthPoints: Int,debuff: Boolean):Hero(name,healthPoints,debuff) {
    override fun action(weaponName: String, damage: Int): Int {
        return damage
    }
}

class Scientist(name: String,healthPoints: Int,debuff: Boolean):Hero(name,healthPoints,debuff) {
    override fun action(weaponName: String, damage: Int): Int {
        return damage
    }
}

class Jaffa(name: String,healthPoints: Int,debuff: Boolean):Hero(name,healthPoints,debuff) {
    override fun action(weaponName: String, damage: Int): Int {
        return damage
    }
}


