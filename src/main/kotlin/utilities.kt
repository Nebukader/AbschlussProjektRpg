
fun actionsJack() {
    val jack = JackONeil
    println("${jack.name} ist am Zug")
    println("Bitte wählen sie eine Aktion aus")
    println("1 = P90- Maschinenpistole (15) Schaden")
    println("2 = Beretta 9mm (5) Schaden")
    println("3 = Zat’nik’tel (25) Schaden")
    println("4 = M60 Maschinengewehr")
    println("5 = Granate (30) Schaden")
    val choice = readlnOrNull()?.toIntOrNull()
    when (choice) {
        1 -> {
            val weapon = "P90-Maschinenpistole"
            val damage:Int = 15
            jack.action(weapon, damage)
            println("${jack.name} greift nach seiner $weapon , und Feuert auf den Feind los. " +
                    "Jack hört nicht auf bis das Magazin leer ist...er verursacht am Feind $damage Schadenspunkte")
        }
        2 -> {
            val weapon = "Beretta 9mm"
            val damage = 5
            jack.action(weapon,damage)
            println("Jack muss schnell reagieren, er greift nach seiner $weapon und feuert ohne zu Zögern auf den Feind..und verursacht $damage Schadenspunkte")
        }

        3 -> {
            //Wenn zeit ist 1 Schuss betäubt der feind kann keine Aktion ausführen / 2 Schuss macht schaden / 3 Schuss Kritisch
            val weapon = "Zat’nik’tel"
            val damage = 25
            jack.action(weapon,damage)
            println("Jack hat seit dem er das erste mal die $weapon in den Händen hielt, direkt ihren wert erkannt..der erste Schuss betäubt, der zweite schuss Tötet und der Dritte lässt die leiche verschwinden." +
                    "Jack schießt auf den Feind und verursacht $damage Schadenspunkte")
        }

        4 -> {
            val weapon = "M60 Maschinengewehr"
            val damage = 12
            jack.action(weapon,damage)
            println("Jack greift nach seiner $weapon, das M60 Maschinengewehr, und eröffnet das Feuer auf den Feind." +
                    "Das Maschinengewehr rattert, und Jack verursacht $damage Schadenspunkte.")
        }
        //Granate noch mit AOE funktion erweitern !!!
        5 -> {
            val weapon = "Granate"
            val damage = 30
            jack.action(weapon,damage)
            println("Jack zieht eine $weapon aus seinem Gürtel und wirft sie in Richtung des Feindes." +
                    "Die Granate explodiert mit einem lauten Knall und verursacht einen massiven Schaden von $damage Punkten.")
        }
        else -> println("Ungültige Auswahl")
    }
}
fun actionsSamantha() {
    val sam = samanthaCarter
    println("${sam.name} ist am Zug")
    println("Bitte wählen sie eine Aktion aus")
    println("1 = P90- Maschinenpistole (15) Schaden")
    println("2 = G36 Maschinengewehr (25) Schaden")
    println("3 = Kull Disruptor (22) Schaden")
    println("4 = Goa`uld Handgerät (40) Schaden")
    println("5 = Granate (30) Schaden")
    val choice = readlnOrNull()?.toIntOrNull()
    when (choice) {
        1 -> {
            val weapon = "P90-Maschinenpistole"
            val damage = 15
            sam.action(weapon, damage)
            println("Samantha Carter zielt mit ihrer $weapon auf den Feind und eröffnet das Feuer! Die Kugeln prasseln auf den Gegner nieder und verursachen $damage Schadenspunkte.")
        }
        2 -> {
            val weapon = "G36 Maschinengewehr"
            val damage = 25
            sam.action(weapon, damage)
            println("Samantha Carter reißt ihr $weapon hoch und beginnt, kontinuierlich Feuer auf den Feind aus dem G36 Maschinengewehr zu spucken! Jeder Treffer verursacht $damage Schadenspunkte.")
        }
        3 -> {
            val weapon = "Kull Disruptor"
            val damage = 22
            sam.action(weapon, damage)
            println("Samantha Carter aktiviert den $weapon und entfesselt einen zerstörerischen Energiestrahl auf den Feind! Die Energieentladung trifft und verursacht $damage Schadenspunkte.")
        }
        4 -> {
            val weapon = "Goa'uld Handgerät"
            val damage = 40
            sam.action(weapon, damage)
            println("Samantha Carter zieht das $weapon hervor und feuert einen vernichtenden Energiestrahl auf den Feind! Die mächtige Entladung verursacht $damage Schadenspunkte.")
        }
        5 -> {
            val weapon = "Granate"
            val damage = 30
            sam.action(weapon, damage)
            println("Samantha Carter schleudert eine $weapon in die Nähe des Feindes! Die Granate explodiert mit gewaltiger Wucht und verursacht einen massiven Schaden von $damage Punkten.")
        }
        else -> println("Ungültige Auswahl")
    }
}
fun actionsTealC() {
    val tealC = tealC
    println("${tealC.name} ist am Zug")
    println("Bitte wählen sie eine Aktion aus")
    println("1 = Stabwaffe (35) Schaden")
    println("2 = M249 Maschinengewehr (15) Schaden")
    println("3 = Zat’nik’tel (25) Schaden")
    println("4 = Kampf Messer (40) Schaden")
    println("5 = Granate (AOE)")
    println("Bitte mach deine Eingabe:")
    val choice = readlnOrNull()?.toIntOrNull()
    when (choice) {
        1 -> {
            val weapon = "Stabwaffe"
            val damage = 35
            println("Mit einer beeindruckenden Geste zieht ${tealC.name} seine $weapon. Die Stabwaffe öffnet sich, und ein gleißender Energiestrahl entfesselt sich, verursacht dabei $damage Schadenspunkte.")
        }
        2 -> {
            val weapon = "M249 Maschinengewehr"
            val damage = 15
            println("${tealC.name} hält sein $weapon fest im Griff und drückt den Abzug. Das Maschinengewehr feuert auf die Feinde, verursacht dabei $damage Schadenspunkte.")
        }
        3 -> {
            val weapon = "Zat’nik’tel"
            val damage = 25
            println("Mit fester Entschlossenheit zielt ${tealC.name} mit der $weapon auf seine Ziele. Ein helles Energiesymbol erscheint und ein Energiestrahl wird abgefeuert, verursacht dabei $damage Schadenspunkte.")
        }
        4 -> {
            val weapon = "Kampfmesser"
            val damage = 40
            println("${tealC.name} zieht sein $weapon mit schneller Bewegung. Er stürzt sich in den Nahkampf und fügt seinen Feinden $damage Schadenspunkte zu.")
        }
        5 -> {
            val weapon = "Granate"
            val damage = 40
            println("${tealC.name} wirft eine $weapon mit präziser Bewegung. Die Granate explodiert und verursacht dabei $damage Schadenspunkte im Bereich der Explosion.")
        }
        else -> {
            println("Ungültige Auswahl")
        }
    }
// wenn alles funktioniert noch Daniel mit einbauen
}