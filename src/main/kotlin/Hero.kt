open class Hero(val name:String, var healthPoints:Int) {

    open fun action(weaponName: String, damage: Int): Int {
        println("Der Angriff erfolgt $name greift mit seiner $weaponName an und verursacht $damage Schadenspunkte")
        return damage
    }

    open fun takeDamage(damage: Int) {
        healthPoints -= damage
        if (healthPoints <= 0) {

        } else
            println("$name hat noch $healthPoints Lebenspunkte")
    }
}

fun printInfoList(hero:MutableList<Hero>) {
    for (hero in heroes) {
        println("${hero.name}: Health Points = ${hero.healthPoints}")
    }
}
class Soldier(name: String,healthPoints: Int):Hero(name,healthPoints) {
    override fun action(weaponName: String, damage: Int): Int {
        return damage
    }
}

class Scientist(name: String,healthPoints: Int):Hero(name,healthPoints) {
    override fun action(weaponName: String, damage: Int): Int {
        return damage
    }
}

class Jaffa(name: String,healthPoints: Int):Hero(name,healthPoints) {
    override fun action(weaponName: String, damage: Int): Int {
        return damage
    }
}

class Archaeologists(name: String,healthPoints: Int):Hero(name,healthPoints) {
    override fun action( weaponName: String, damage: Int): Int {
        return damage
    }
}
