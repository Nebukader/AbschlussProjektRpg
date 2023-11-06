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
    }

    //Damit von außen die funktion nicht verändert werden kann ist diese auf Private da sie nur innerhalb der Klasse genutzt werden soll
    private fun heal(user:Hero){
        user.healthPoints += healingAmount
        println("${user.name} heilt sich um $healingAmount Gesundheitspunkte. Deine aktuellen gesundheitspunkte sind: ${user.healthPoints}\"")
    }


}


open class Grenade(name:String, private val enemys: MutableList<FootSoldier>):Item(name) {
    val damage = 30

    override fun use(user: Hero) {
        super.use(user)
        for (enemy in enemys) {
            enemy.takeDamage(damage)
        }
        println("${user.name} wirft eine Granate, die allen Gegnern in der Nähe $damage Schadenspunkte zufügt.")

    }
}

val bandage: Heal =Heal("Verband",20)
val bandage1:Heal =Heal("Verband",20)
val bandage2:Heal =Heal("Verband",20)

