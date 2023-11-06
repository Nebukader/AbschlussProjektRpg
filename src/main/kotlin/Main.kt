//Heros
val heroes:MutableList<Hero> = mutableListOf(
    Soldier("Jack O Neil", 250,),
    Scientist("Samantha Carter",250),
    Jaffa("Teal C",250))

//Eventuel später zum selber aussuchen der Heldentruppe
val daniel:Hero = Hero("Daniel Jackson",10)
val bratak:Hero = Hero("Bratak",10)
val cameron:Hero = Hero("Cameron Mitchell", 10)
val jonas:Hero = Hero("Jonnas Quinn",10)

//Villains

val footSoldiers:MutableList<FootSoldier> = mutableListOf(
    FootSoldier("Jaffa Jotavod",50),
    FootSoldier("Jaffa Ak'noan",50),
    FootSoldier("Jaffa Halvod",50),
    FootSoldier("Jaffa Saba",50))

//Rucksack
val Bandages:MutableList<Heal> = mutableListOf(
    Heal("Verband-1",50),
    Heal("Verband-2",50),
    Heal("Verband-3",50)
)

val footSoldierActions = listOf(StabwaffenSchuss(), TacTac(), Cannon(), Schlag(), HandGerät(), Zetnitika())
val bossActions = listOf(StabwaffenSchuss(),TacTac(), Schlag(), HandGerät(),AlkeshBomber(),Todesgleiter())



//Boss
val BossBaal:Boss = Boss("Ba'al",800)
val bossPlusMinion:MutableList<Enemy> = mutableListOf(
    BossBaal)
fun main() {

}