//Heros
val heroes:MutableList<Hero> = mutableListOf(
    Soldier("Jack O Neil", 500,),
    Scientist("Samantha Carter",500),
    Jaffa("Teal C",500))

//Eventuel später zum selber aussuchen der Heldentruppe
val daniel:Hero = Hero("Daniel Jackson",10)
val bratak:Hero = Hero("Bratak",10)
val cameron:Hero = Hero("Cameron Mitchell", 10)
val jonas:Hero = Hero("Jonnas Quinn",10)

//Villains

val footSoldiers:MutableList<FootSoldier> = mutableListOf(
    FootSoldier("Jaffa Jotavod",10),
    FootSoldier("Jaffa Ak'noan",10),
    FootSoldier("Jaffa Halvod",10),
    FootSoldier("Jaffa Saba",10))

val footSoldierActions = listOf(StabwaffenSchuss(), TacTac(), Cannon(), Schlag(), HandGerät(), Zetnitika())
val bossActions = listOf(StabwaffenSchuss(),TacTac(), Schlag(), HandGerät(),AlkeshBomber(),Todesgleiter())



//Boss
val BossBaal:Boss = Boss("Ba'al",500)
val bossPlusMinion:MutableList<Enemy> = mutableListOf(
    BossBaal)
fun main() {

}