//Heros
val testJack = Soldier("Jack O Neil", 150,)
val heroes:MutableList<Hero> = mutableListOf(
    Soldier("Jack O Neil", 150,),
    Scientist("Samantha Carter",125),
    Jaffa("Teal C",200))

//Eventuel später zum selber aussuchen der Heldentruppe
val daniel:Hero = Hero("Daniel Jackson",125)
val bratak:Hero = Hero("Bratak",250)
val cameron:Hero = Hero("Cameron Mitchell", 175)
val jonas:Hero = Hero("Jonnas Quinn",125)

//Villains

val footSoldiers:MutableList<FootSoldier> = mutableListOf(
    FootSoldier("Jaffa Jotavod",80),
    FootSoldier("Jaffa Ak'noan",75),
    FootSoldier("Jaffa Halvod",65),
    FootSoldier("Jaffa Saba",70))

val footSoldierActions = listOf(StabwaffenSchuss(), TacTac(), Cannon(), Schlag(), HandGerät(), Zetnitika())



//Boss
val BossBaal:Boss = Boss("Ba'al",500)
val bossPlusMinion:MutableList<Enemy> = mutableListOf(
    BossBaal)
fun main() {

}