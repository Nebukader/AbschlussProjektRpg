fun gameplay(footSoldier: MutableList<FootSoldier>, heroes: MutableList<Hero>) {
    do {
        println("Lass uns ein Spiel spielen, mal sehen wer gewinnt, SG-1 oder die Goa´Uld")
        for (hero in heroes) {
            val selectedFootSoldier = footSoldiers.random()
            val damage = when (hero) {
                is Soldier -> actionsJack()
                is Scientist -> actionsSamantha()
                is Jaffa -> actionsTealC()
                else -> 0
            }
            selectedFootSoldier.takeDamage(damage)
            if (selectedFootSoldier.healthPoints <= 0)
                println("${selectedFootSoldier.name} wurde bezwungen")
            footSoldiers.remove(selectedFootSoldier)
        }
    }while (footSoldiers.isNotEmpty())
}
fun actionsJack(): Int {
    val jack = heroes[0]
    println("${jack.name} ist am Zug")
    println("Bitte wählen sie eine Aktion aus")
    println("1 = P90- Maschinenpistole (15) Schaden")
    println("2 = Beretta 9mm (5) Schaden")
    println("3 = Zat’nik’tel (25) Schaden")
    println("4 = M60 Maschinengewehr")
    println("5 = Granate (30) Schaden")
    val choice = readlnOrNull()?.toIntOrNull() ?: 0

    return when (choice) {
        1 -> {
            val weapon = "P90-Maschinenpistole"
            val damage = 15
            println("${jack.name} greift nach seiner $weapon und verursacht $damage Schadenspunkte")
            damage
        }

        2 -> {
            val weapon = "Beretta 9mm"
            val damage = 5
            println("${jack.name} greift nach seiner $weapon und verursacht $damage Schadenspunkte")
            damage
        }
        // Weitere Aktionen hier hinzufügen ...

        else -> {
            println("Ungültige Auswahl")
            0
        }
    }
}


fun actionsSamantha(): Int {
    val sam = heroes[1]
    println("${sam.name} ist am Zug")
    println("Bitte wählen sie eine Aktion aus")
    println("1 = P90- Maschinenpistole (15) Schaden")
    println("2 = G36 Maschinengewehr (25) Schaden")
    println("3 = Kull Disruptor (22) Schaden")
    println("4 = Goa`uld Handgerät (40) Schaden")
    println("5 = Granate (30) Schaden")
    val choice: Int? = readlnOrNull()?.toIntOrNull() ?: 0

    return when (choice) {
        1 -> {
            val weapon = "P90-Maschinenpistole"
            val damage = 15
            println("${sam.name} zielt mit ihrer $weapon auf den Feind und eröffnet das Feuer! Die Kugeln prasseln auf den Gegner nieder und verursachen $damage Schadenspunkte.")
            damage
        }

        2 -> {
            val weapon = "G36 Maschinengewehr"
            val damage = 25
            println("Samantha Carter reißt ihr $weapon hoch und beginnt, kontinuierlich Feuer auf den Feind aus dem G36 Maschinengewehr zu spucken! Jeder Treffer verursacht $damage Schadenspunkte.")
            damage
        }

        3 -> {
            val weapon = "Kull Disruptor"
            val damage = 22
            println("Samantha Carter aktiviert den $weapon und entfesselt einen zerstörerischen Energiestrahl auf den Feind! Die Energieentladung trifft und verursacht $damage Schadenspunkte.")
            damage
        }

        4 -> {
            val weapon = "Goa'uld Handgerät"
            val damage = 40
            println("Samantha Carter zieht das $weapon hervor und feuert einen vernichtenden Energiestrahl auf den Feind! Die mächtige Entladung verursacht $damage Schadenspunkte.")
            damage
        }

        5 -> {
            val weapon = "Granate"
            val damage = 30
            println("Samantha Carter schleudert eine $weapon in die Nähe des Feindes! Die Granate explodiert mit gewaltiger Wucht und verursacht einen massiven Schaden von $damage Punkten.")
            damage
        }

        else -> {
            println("Ungültige Auswahl")
            0
        }
    }

}


fun actionsTealC(): Int {
    val tealC = heroes[2]
    println("${tealC.name} ist am Zug")
    println("Bitte wählen sie eine Aktion aus")
    println("1 = Stabwaffe (35) Schaden")
    println("2 = M249 Maschinengewehr (15) Schaden")
    println("3 = Zat’nik’tel (25) Schaden")
    println("4 = Kampf Messer (40) Schaden")
    println("5 = Granate (AOE)")
    println("Bitte mach deine Eingabe:")
    val choice = readlnOrNull()?.toIntOrNull() ?: 0

    return when (choice) {
        1 -> {
            val weapon = "Stabwaffe"
            val damage = 35
            println("Mit einer beeindruckenden Geste zieht ${tealC.name} seine $weapon. Die Stabwaffe öffnet sich, und ein gleißender Energiestrahl entfesselt sich, verursacht dabei $damage Schadenspunkte.")
            damage
        }

        2 -> {
            val weapon = "M249 Maschinengewehr"
            val damage = 15
            println("${tealC.name} hält sein $weapon fest im Griff und drückt den Abzug. Das Maschinengewehr feuert auf die Feinde, verursacht dabei $damage Schadenspunkte.")
            damage
        }

        3 -> {
            val weapon = "Zat’nik’tel"
            val damage = 25
            println("Mit fester Entschlossenheit zielt ${tealC.name} mit der $weapon auf seine Ziele. Ein helles Energiesymbol erscheint und ein Energiestrahl wird abgefeuert, verursacht dabei $damage Schadenspunkte.")
            damage
        }

        4 -> {
            val weapon = "Kampfmesser"
            val damage = 40
            println("${tealC.name} zieht sein $weapon mit schneller Bewegung. Er stürzt sich in den Nahkampf und fügt seinen Feinden $damage Schadenspunkte zu.")
            damage
        }

        5 -> {
            val weapon = "Granate"
            val damage = 40
            println("${tealC.name} wirft eine $weapon mit präziser Bewegung. Die Granate explodiert und verursacht dabei $damage Schadenspunkte im Bereich der Explosion.")
            damage
        }

        else -> {
            println("Ungültige Auswahl")
            0
        }
    }
// wenn alles funktioniert noch Daniel mit einbauen
}