open class Hero(var name:String,healthPoints:Int) {

    open fun action(name: String, weaponName: String, damage: Int): Int {
        println("Der Angriff erfolgt $name greift mit seiner $weaponName an und verursacht $damage Schadenspunkte")
        return damage
    }
}

class Soldier(name: String,healthPoints: Int):Hero(name,healthPoints) {
    override fun action(name: String, weaponName: String, damage: Int): Int {
        return super.action(name, weaponName, damage)
    }

}

class Scientist(name: String,healthPoints: Int):Hero(name,healthPoints) {

    override fun action(name: String, weaponName: String, damage: Int): Int {
        return super.action(name, weaponName, damage)
    }

    /*val samanthaActions: Map<String, Int> = mapOf(
        "Pistol" to 5,
        "Zetnitikal" to 10,
        "G36" to 18,
        "TokraPlaceHolderWeapon" to 23,
        "GoaUldHandgerät" to 35
    )*/
}
class Jaffa(name: String,healthPoints: Int):Hero(name,healthPoints) {
    override fun action(name: String, weaponName: String, damage: Int): Int {
        return super.action(name, weaponName, damage)
    }
}


/*val tealCactions:Map<String,Int> = mapOf(
    "Pistol" to 5,
    "Zenitikal" to 10,
    "M249" to 20,
    "StaffWeapon" to 30,
    "SmashStaffWeapon" to 45

)*/
class Archaeologists(name: String,healthPoints: Int):Hero(name,healthPoints) {
    override fun action(name: String, weaponName: String, damage: Int): Int {
        return super.action(name, weaponName, damage)
    }
}
