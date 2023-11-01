open class Hero(val name:String, var healthPoints:Int) {

    open fun action(weaponName: String, damage: Int): Int {
        println("Der Angriff erfolgt $name greift mit seiner $weaponName an und verursacht $damage Schadenspunkte")
        return damage
    }
    open fun takeDamage(damage:Int){
        healthPoints -=damage
        if (healthPoints <= 0){
            println("Der Held ist tot")

        }else
            println("$name hat noch $healthPoints Lebenspunkte")
}

class Soldier(name: String,healthPoints: Int):Hero(name,healthPoints) {
    override fun action(weaponName: String, damage: Int): Int {
        return super.action(weaponName, damage)
    }

}

class Scientist(name: String,healthPoints: Int):Hero(name,healthPoints) {

    override fun action(weaponName: String, damage: Int): Int {
        return super.action(weaponName, damage)
    }
}

class Jaffa(name: String,healthPoints: Int):Hero(name,healthPoints) {
    override fun action(weaponName: String, damage: Int): Int {
        return super.action(weaponName, damage)
    }
}

class Archaeologists(name: String,healthPoints: Int):Hero(name,healthPoints) {
    override fun action( weaponName: String, damage: Int): Int {
        return super.action( weaponName, damage)
    }
}
