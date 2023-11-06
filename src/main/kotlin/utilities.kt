fun gameplay(footSoldiers: MutableList<FootSoldier>, heroes: MutableList<Hero>,bosses: MutableList<Boss>) {
    var countRounds: Int = 1



    // Die Schleife läuft so lange, wie noch Runden übrig sind und Fußsoldaten vorhanden sind
    while (footSoldiers.isNotEmpty()) {
        println("Die Runde beginnt Runde $countRounds")

        // Schleife für die Helden
        for (hero in heroes) {
            // Die Schleife wird beendet, wenn keine Fußsoldaten mehr übrig sind
            if (footSoldiers.isEmpty()) {
                break
            }

            // Zufällige Auswahl eines Fußsoldaten
            val selectedFootSoldier = footSoldiers.random()

            // Schaden wird abhängig vom Heldentyp berechnet
            val damage = when (hero) {
                is Soldier -> actionsJack()
                is Scientist -> actionsSamantha()
                is Jaffa -> actionsTealC()
                else -> 0
            }

            // Fußsoldat erleidet Schaden
            selectedFootSoldier.takeDamage(damage)

            // Wenn der Fußsoldat keine Lebenspunkte mehr hat, wird er entfernt
            if (selectedFootSoldier.healthPoints <= 0) {
                println("${selectedFootSoldier.name} wurde bezwungen")
                footSoldiers.remove(selectedFootSoldier)
            }
        }

        // Schleife für die Fußsoldaten
        for (soldier in footSoldiers) {
            // Zufällige Aktion des Fußsoldaten
            var damageHero = soldier.randomAction(footSoldierActions)
            val survivingHeroes: MutableList<Hero> = mutableListOf()

            // Schleife für die Helden
            for (hero in heroes) {
                // Ein zufälliger Held erleidet Schaden
                heroes.random().takeDamage(damageHero)
                if (hero.healthPoints > 0) {
                    survivingHeroes.add(hero)
                } else {
                    println("${hero.name} ist im Kampf gefallen")
                }
            }

            // Überlebende Helden werden aktualisiert
            // Globale Variable wird zurück gesetzt damit die Helden nach der runde die Heilung wieder nutzen können
            heroes.clear()
            heroes.addAll(survivingHeroes)
            ItemUsed = false
            countRounds++
        }
    }

    // Wenn keine Helden mehr übrig sind, ist das Spiel verloren
    if (heroes.isEmpty()) {
        println("Game Over! Alle Helden wurden besiegt!")
    } else {
        // Ansonsten sind noch Fußsoldaten übrig, die fliehen
        println("SG-1 hat die Gegner in die flucht geschlagen doch der Frieden hält nicht lange an...")
        bossFight(bosses,heroes)
    }
}


fun bossFight(bosses: MutableList<Boss>, heroes: MutableList<Hero>) {
    println("Baal (Bosskampf) erscheint nachdem die Jaffa Krieger nutzlos gewesen sind")
//Hilfe von ChatGPT geholt
    while (heroes.isNotEmpty() && bosses.any { it.healthPoints > 0 }) {
        var countRounds: Int = 1

        // Die Schleife läuft, solange, wie noch Runden übrig sind.
        for (boss in bosses) {
            if (boss.healthPoints >= 0) {
                continue
            }
            println("Der Bosskampf beginnt Runde $countRounds")

            // Schleife für die Helden
            for (hero in heroes) {

                if (heroes.isEmpty()) {
                    break
                }

                // Schaden wird abhängig vom Heldentyp berechnet CHATGPT als hilfe genutzt wie ich mein Actions Menue einbaue
                val damage = when (hero) {
                    is Soldier -> actionsJack()
                    is Scientist -> actionsSamantha()
                    is Jaffa -> actionsTealC()
                    else -> 0
                }

                // Boss erleidet Schaden
                boss.takeDamage(damage)

                if (boss.healthPoints <= 0) {
                    println("SG-1 hat den Systemlord ${boss.name} bezwungen")
                    break
                }
            }

            val damageHero = bossActions.random().damage
            val survivingHeroes: MutableList<Hero> = mutableListOf()

            // Schleife für die Helden
            val randomHero = heroes.random()
            randomHero.takeDamage(damageHero)

            if (randomHero.healthPoints > 0) {
                survivingHeroes.add(randomHero)
            } else {
                println("${randomHero.name} ist im Kampf gefallen")
            }

            // Überlebende Helden werden aktualisiert
            heroes.clear()
            heroes.addAll(survivingHeroes)
            // Globale Variable wird zurück, gesetzt damit die Helden nach der runde die Heilung wieder nutzen können
            ItemUsed = false
            countRounds++

            if (boss.healthPoints < boss.originalHealthPoints / 2) {
                boss.summonLowHealth()
            }

        }

    }
    if (heroes.isEmpty()){
        println("Game Over! Alle Helden wurden besiegt!")
    }
}


fun actionsJack(): Int {
    val jack = heroes[0]
    println("${jack.name} ist am Zug")
    println("Bitte wählen sie eine Aktion aus")
    println("1 = P90- Maschinenpistole (15) Schaden")
    println("2 = Anfeuern (20% Health Buff)")
    println("3 = Zat’nik’tel (25) Schaden")
    println("4 = Granate (30 AOE)")
    println("5 = Verband zum Heilen (50)")
    val choice = readlnOrNull()?.toIntOrNull() ?: 0

    return when (choice) {
        1 -> {
            val weapon = "P90-Maschinenpistole"
            val damage = 15
            println("${jack.name} greift nach seiner $weapon und verursacht $damage Schadenspunkte")
            damage
        }

        2 -> {
            jack.shout(jack.healthPoints)
            println("Das Adrenalin schießt ${jack.name} in die Blutbanen angetrieben von der brenzligen Situation, stärkt es ${jack.name} der daraufhin laut aufschreit.")
            0
        }

        3 -> {
            //Wenn zeit ist 1 Schuss betäubt der feind kann keine Aktion ausführen / 2 Schuss macht schaden / 3 Schuss Kritisch
            val weapon = "Zat’nik’tel"
            val damage = 25
            jack.action(weapon, damage)
            println(
                "Jack hat seit dem er das erste mal die $weapon in den Händen hielt, direkt ihren wert erkannt..der erste Schuss betäubt, der zweite schuss Tötet und der Dritte lässt die leiche verschwinden." +
                        "Jack schießt auf den Feind und verursacht $damage Schadenspunkte"
            )
            println("${jack.name} greift nach seiner $weapon und verursacht $damage Schadenspunkte")
            damage
        }

        4 -> {
            val weapon = "Granate"
            val damage = 30
            Grenade("M67",footSoldiers).use(jack)
            damage
        }
// Bei der Try Catch habe ich mir hilfe von ChatGPT geholt, um den fehler zu lösen, da ich mich nicht mehr genaur daran erinnerte,
// wie das ganze nochmal funktioniert.
        5 -> {
            if (ItemUsed == true){
                print("Die Heilung wurde bereits genutzt warte bis zur nächsten Runde")
                actionsJack()

            }else

            try {
                Bandages[0].use(jack)
                ItemUsed = true
            } catch (e: IndexOutOfBoundsException) {
                println("Es gibt keine Verbände mehr im Rucksack.")
                actionsJack()
            }
            0
        }

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
    println("5 = Verband zum Heilen (50)")
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
            if (ItemUsed == true){
                print("Die Heilung wurde bereits genutzt warte bis zur nächsten Runde")
                actionsSamantha()

            }else

                try {
                    Bandages[0].use(sam)
                    ItemUsed = true
            } catch (e: IndexOutOfBoundsException) {
                println("Es gibt keine Verbände mehr im Rucksack.")
                actionsSamantha()
            }
            0
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
    println("5 = Granate (30 AOE)")
    println("5 = Verband zum Heilen (50)")
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
            val weapon = "Granate"
            val damage = 30
            Grenade("M67",footSoldiers).use(tealC)
            damage
        }

        5 -> {
            if (ItemUsed == true){
                print("Die Heilung wurde bereits genutzt warte bis zur nächsten Runde")
                actionsTealC()

            }else

                try {
                    Bandages[0].use(tealC)
                    ItemUsed = true
            } catch (e: IndexOutOfBoundsException) {
                println("Es gibt keine Verbände mehr im Rucksack.")
                actionsTealC()
            }
            0
        }


        else -> {
            println("Ungültige Auswahl")
            0
        }
    }

}