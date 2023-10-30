class Hero(name:String,healthPoints:Int,actions:Map<String,Int>) {

    val jackActions:Map<String,Int> = mapOf(
        "Pistol" to 5,
        "Zetnitika" to 10,
        "P90" to 15,
        "Schmerzstab" to 20,
        "StaffWeapon" to 25,
        "GoaUldHandGerät" to 30,
    )

    val samanthaActions:Map<String,Int> = mapOf(
        "Pistol" to 5,
        "Zetnitikal" to 10,
        "G36" to 18,
        "TokraPlaceHolderWeapon" to 23,
        "GoaUldHandgerät" to 35
    )

    val tealCactions:Map<String,Int> = mapOf(
        "Pistol" to 5,
        "Zenitikal" to 10,
        "M249" to 20,
        "StaffWeapon" to 30,
        "SmashStaffWeapon" to 45

    )
    val danielActions:Map<String,Int> = mapOf(


    )

    val bratakactions:Map<String,Int>(

    )

    val JackONeil:Hero = Hero("Jack O Neil",150,jackActions)
    val samanthaCarter:Hero = Hero("Samantha Carter",125,samanthaActions)
    val tealC:Hero = Hero("Teal C",200,tealCactions)
    val daniel:Hero = Hero("Daniel Jackson",125,danielActions)
    val bratak:Hero = Hero("Bratak",250,bratakactions)
    val cameron:Hero = Hero("Cameron Mitchell", 175,cameronactions)
    val jonas:Hero = Hero("Jonnas Quinn",125,jonasActions)

}