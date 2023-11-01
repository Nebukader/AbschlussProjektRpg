open class Item(val name: String) {

    //Hier wird als Parameter die Klasse Hero genutzt um an den Namen des Helden zu kommen
    open fun use(user:Hero) {
        println("${user.name} benutzt das Item $name.")
    }
}
class Heal(name:String, private var healingAmount: Int):Item(name){
    override fun use(user: Hero) {
        super.use(user)
        heal(user)

    }
    //Damit von außen die funktion nicht verändert werden kann ist diese auf Private da sie nur innerhalb der Klasse genutzt werden soll
    private fun heal(user:Hero){
        user.healthPoints += healingAmount
        println("${user.name} wurde um $healingAmount Gesundheitspunkte geheilt. Neue Gesundheitspunkte: ${user.healthPoints}\"")
    }


}
class Grenade(name:String):Item(name){

}

val bandage: Heal =Heal("Verband",20)
val bandage1:Heal =Heal("Verband",20)
val bandage2:Heal =Heal("Verband",20)

