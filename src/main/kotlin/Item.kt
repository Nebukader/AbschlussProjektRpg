open class Item(val name: String) {

    //Hier wird als Parameter die Klasse Hero genutzt, um an den Namen des Helden zu kommen
    open fun use(user:Hero) {
        println("${user.name} benutzt das Item $name.")
    }
}

open class Heal(name:String, private var healingAmount: Int):Item(name){
    override fun use(user: Hero) {
        super.use(user)
        if (Bandages.isNotEmpty()) {
            heal(user)
            Bandages.removeAt(0)
        }
        else
            println("Der Rucksack ist leer, wir haben bereits alles Verbände genutzt, am besten such einen Sarkophag oder brich die Mission ab")
    }

    //Damit von außen die funktion nicht verändert werden kann ist diese auf Private da sie nur innerhalb der Klasse genutzt werden soll
    private fun heal(user:Hero){
        user.healthPoints += healingAmount
        println("${user.name} heilt sich um $healingAmount Gesundheitspunkte. Deine aktuellen gesundheitspunkte sind: ${user.healthPoints}\"")
    }


}


class Grenade(name:String):Item(name){
    val damage = 30
    override fun use(user: Hero) {
        super.use(user)
    }
    // Wichtig noch Ziel mit Enemy List updaten, das alle aus der Liste schaden, bekommen AOE
    // hier wird der schaden auf das Ziel angewandt
    fun throwAt(targetEnemy:Enemy){
        targetEnemy.takeDamage(damage)
    }
}

val bandage: Heal =Heal("Verband",20)
val bandage1:Heal =Heal("Verband",20)
val bandage2:Heal =Heal("Verband",20)

