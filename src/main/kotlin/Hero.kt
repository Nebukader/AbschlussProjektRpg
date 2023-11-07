open class Hero(val name:String, var healthPoints:Int, var debuff:Boolean = false) {

    open fun action(weaponName: String, damage: Int): Int {
        println("Der Angriff erfolgt $name greift mit seiner $weaponName an und verursacht $damage Schadenspunkte")
        return damage
    }

    open fun takeDamage(damage: Int) {
        healthPoints -= damage
        if (damage == 0) {
            println()
        }else
            if (healthPoints <= 0) {
                println("Der Feind ist tot")

            } else
                println("Der $name hat noch $healthPoints Lebenspunkte")
    }
    open fun shout(buffHealth:Int){
        val buff = healthPoints / 100 * 20
        healthPoints + buff
    }
    fun debuffHealth(target:Hero){
        val originalHealthPoints = target.healthPoints
        val debuffHealthPoints:Int = originalHealthPoints /100 * 10
        if (target.debuff == true){
            println(" Du wurdest mit Naniten infiziert und verlierst jede Runde 10% Lebenspunkte")
            if (target.healthPoints < originalHealthPoints * 0.2)
                debuff = false
            print("Du bist nicht mehr infiziert deine Lebenspuntke betragen aber nur noch :${target.healthPoints} Lebenspunkte")
        }else
            target.healthPoints -= debuffHealthPoints
        println("Du wirst schwächer du verlierst $debuffHealthPoints Lebenspunkte")
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


