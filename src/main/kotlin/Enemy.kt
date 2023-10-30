import jdk.jfr.Enabled

open class Enemy(name:String, healthPoints:Int) {


    val baalActions:Map<String,Int> = mapOf(

    )

    val raActions:Map<String,Int> = mapOf(

    )

    val heruurActions:Map<String,Int> = mapOf(


    )

    val apophis:Enemy = Enemy("Apohis", 200)
    val baal:Enemy = Enemy("Baal",225)
    val ra:Enemy = Enemy("Ra",300)
    val heruur:Enemy = Enemy("Heru´ur",220)


    class Boss(name: String, healthPoints: Int): Enemy(name,healthPoints)



    val apohisSpecial:Map<String, Int> = mapOf(

    )

    val anubis:Boss =Boss("Apohis",1500)

    class Minion(name: String, healthPoints: Int) : Enemy(name, healthPoints)



    val jaffa:Minion = Minion("Jaffa foot Soldier",150)
}
