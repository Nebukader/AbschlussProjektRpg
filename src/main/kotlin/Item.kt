//Die Klasse Item ist eine abstrakte Klasse, die die Basisklasse für alle Items darstellt.
open class Item(val name: String) {

    //Hier wird als Parameter die Klasse Hero genutzt, um an den Namen des Helden zu kommen
    open fun use(user:Hero) {
        println("${user.name} benutzt das Item $name.")
    }
}

//Die Klasse Heal erbt von der Klasse Item und erweitert die Methode use().
open class Heal(name:String, private var healingAmount: Int):Item(name){
    override fun use(user: Hero) {
        super.use(user)
        if (Bandages.isNotEmpty()) {
            heal(user)
            Bandages.removeAt(0)
        }
    }

    //Diese Methode wird verwendet, um den Helden zu heilen.
    private fun heal(user:Hero){
        user.healthPoints += healingAmount
        println("${user.name} heilt sich um $healingAmount Gesundheitspunkte. Deine aktuellen gesundheitspunkte sind: ${user.healthPoints}\"")
    }


}

//Die Klasse Grenade erbt von der Klasse Item und erweitert die Methode use().
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
