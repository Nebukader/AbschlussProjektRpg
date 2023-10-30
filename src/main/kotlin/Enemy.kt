import jdk.jfr.Enabled

open class Enemy(name:String, healthPoints:Int, actions:Map<String,Int>) {

    val actions: Map<String, Int> = mapOf(
        action1 to 5,
        action2 to 10,
        action3 to 15,
        action4 to 20,
        action5 to 25,
        action to 30,
    )

    val baalActions:Map<String,Int> = mapOf(

    )

    val raActions:Map<String,Int> = mapOf(

    )

    val heruurActions:Map<String,Int> = mapOf(


    )

    val apophis:Enemy = Enemy("Apohis", 200,apohisActions)
    val baal:Enemy = Enemy("Baal",225,baalActions)
    val ra:Enemy = Enemy("Ra",300,raActions)
    val heruur:Enemy = Enemy("Heru´ur",220,heruurActions)


    class Boss(name: String, healthPoints: Int, actions: Map<String, Int>, specialAction): Enemy(name,healthPoints,actions)

    val anubisActions:Map<String,Int> = mapOf(
        action to 20,
        action to 30,

    )

    val apohisSpecial:Map<String, Int> = mapOf(

    )

    val anubis:Boss =Boss("Apohis",1500,anubisAction,apohisSpecial)

    class Minion(name: String, healthPoints: Int, actions: Map<String, Int>) : Enemy(name, healthPoints, actions)


    val footSoldierAction:Map<Strnig,Int> = mapOf(
        "Staff Weapon" to 15,

    )
    val jaffa:Minion = Minion("Jaffa foot Soldier",150,footSoldierActions)
}
