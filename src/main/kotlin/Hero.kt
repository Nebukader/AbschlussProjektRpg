open class Hero(var name:String,healthPoints:Int) {

    open fun action(weaponName: String, damage: Int): Int {
        println("Der Angriff erfolgt $name greift mit seiner $weaponName an und verursacht $damage Schadenspunkte")
        return damage
    }
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
