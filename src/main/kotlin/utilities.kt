/**
 * Die Funktion `gameplay` steuert den Ablauf des Spiels zwischen Fußsoldaten, Helden und Bossen.
 * Sie läuft solange, wie noch Fußsoldaten vorhanden sind und es noch Runden übrig sind.
 * In jeder Runde werden die Helden und Fußsoldaten abwechselnd Schaden zufügen.
 * Wenn keine Fußsoldaten mehr übrig sind, endet das Spiel.
 * Wenn keine Helden mehr übrig sind, ist das Spiel verloren.
 * Ansonsten werden die verbliebenen Fußsoldaten besiegt und es kommt zum Bosskampf.
 */
fun gameplay(footSoldiers: MutableList<FootSoldier>, heroes: MutableList<Hero>, bosses: MutableList<Boss>) {
    // Die Schleife läuft so lange, wie noch Runden übrig sind und Fußsoldaten vorhanden sind
    try {


        while (footSoldiers.isNotEmpty()) {
            println("Die Runde beginnt Runde")
            println()

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
                println("Der Jaffa ${selectedFootSoldier.name} erleidet $damage Schadenspunkte und hat noch ${selectedFootSoldier.healthPoints} HP")
                println()

                // Wenn der Fußsoldat keine Lebenspunkte mehr hat, wird er entfernt
                if (selectedFootSoldier.healthPoints <= 0) {
                    footSoldiers.remove(selectedFootSoldier)
                }
            }

            // Schleife für die Fußsoldaten
            for (soldier in footSoldiers) {
                // Zufällige Aktion des Fußsoldaten
                val damageHero = soldier.randomAction(footSoldierActions)


                // Schleife für die Helden
                val survivingHeroes: MutableList<Hero> = mutableListOf()

                // Ein zufälliger Held erleidet Schaden
                heroes.random().takeDamage(damageHero)
                println("--------------------------------------")

                for (hero in heroes) {
                    if (hero.healthPoints > 0) {
                        survivingHeroes.add(hero)
                    } else {
                        println("${hero.name} ist im Kampf gefallen")
                    }
                }

                // Überlebende Helden werden aktualisiert
                // Globale Variable wird zurück gesetzt damit die Helden nach der Runde die Heilung wieder nutzen können
                heroes.clear()
                heroes.addAll(survivingHeroes)
                ItemUsed = false
            }
        }
    } catch (_: IndexOutOfBoundsException) {

    }

    // Wenn keine Helden mehr übrig sind, ist das Spiel verloren
    if (heroes.isEmpty()) {
        println("Game Over! Alle Helden wurden besiegt!")
    } else {
        // Ansonsten sind noch Fußsoldaten übrig, die fliehen
        println("SG-1 hat die Gegner in die Flucht geschlagen, doch der Frieden hält nicht lange an...")
        println()
        bossFight(bosses, heroes)
    }
}

/**
 * Funktion, die den Bosskampf zwischen Bossen und Helden durchführt.
 *
 * @param bosses Eine Liste von Bossen
 * @param heroes Eine Liste von Helden
 */

fun bossFight(bosses: MutableList<Boss>, heroes: MutableList<Hero>) {
    println("Baal (Bosskampf) erscheint nachdem die Jaffa Krieger nutzlos gewesen sind")
    val originalHealthPoints = BossBaal.healthPoints

    if (heroes.isEmpty() && bosses.isEmpty()) {
        // Überprüfe, ob entweder Helden oder Bosse leer sind, und beende den Bosskampf
        println("Bosskampf beendet")
        return
    }

    /**
     * Dieser Code simuliert einen Bosskampf zwischen Helden und Bossen.
     * Jeder Held führt Aktionen aus, die abhängig von ihrem Heldentyp sind, um Schaden am Boss zu verursachen.
     * Der Boss fügt dann einem zufälligen Helden Schaden zu. Wenn ein Boss besiegt ist, wird die Schleife beendet.
     */

    // Initialisiere die Anzahl der Runden außerhalb der Schleife
    var countRounds: Int = 1

    while (heroes.isNotEmpty() && bosses.isNotEmpty()) {
        println("Der Bosskampf beginnt Runde $countRounds")

        // Kopie der Heldenliste erstellen, um Probleme bei der Iteration zu vermeiden
        val heroesCopy = heroes.toList()

        for (hero in heroesCopy) {
            if (bosses.isEmpty()) {
                break
            }

            // Schaden wird abhängig vom Heldentyp berechnet
            val damage = when (hero) {
                is Soldier -> actionsJack()
                is Scientist -> actionsSamantha()
                is Jaffa -> actionsTealC()
                else -> 0
            }

            if (kullWarrior.healthPoints <= 0) {
                bosses.remove(kullWarrior)
                println("Der Kull Krieger wurde bezwungen, nun kann sich SG-1 wieder auf den Systemlord konzentrieren")
            }
            // Zufälligen Boss auswählen und Schaden zufügen
            if (bosses.contains(kullWarrior)) {
                println("SG-1 erkennt die Gefahr und nimmer den Kull Krieger als erstes ins Visier !")
                kullWarrior.takeDamage(damage)
            } else {
                bosses[0].takeDamage(damage)
            }
            if (BossBaal.healthPoints < originalHealthPoints / 2) {
                if (BossBaal.summonend == false) {
                    BossBaal.summonLowHealth()
                } else
                    println()
            }

            if (bosses[0].healthPoints <= 0) {
                println("SG-1 hat den Systemlord ${bosses[0].name} bezwungen")
                break
            }

            // Angriff des Bosses auf einen zufälligen Helden
            for (boss in bosses) {
                val randomBoss = bosses.random()
                val randomHero = heroes.random()
                val bossActionDamage = randomBoss.bossRandomAction()
                if (bossActionDamage == 10) {
                    randomHero.debuff = true
                }
                randomHero.takeDamage(bossActionDamage)
                print("-------------------------------")
            }
            // Überprüfen, ob ein Boss-Gegner besiegt wurde
            bosses.removeAll { it.healthPoints <= 0 }
            if (bosses.isEmpty()) {
                println("SG-1 hat alle Boss-Gegner besiegt.")
                break
            }
        }
        /**
         * Dieser Code filtert die überlebenden Helden und setzt die Liste der Helden zurück.
         * Die globale Variable "ItemUsed" wird zurückgesetzt und die Anzahl der Runden wird erhöht.
         * Wenn alle Bosse besiegt wurden, wird eine entsprechende Meldung ausgegeben und die Schleife beendet.
         * Wenn alle Helden besiegt wurden, wird eine Game Over-Meldung ausgegeben.
         */


        val survivingHeroes: MutableList<Hero> = heroes.filter { it.healthPoints > 0 }.toMutableList()
        heroes.clear()
        heroes.addAll(survivingHeroes)

        // Setze globale Variable zurück, damit die Helden nach der Runde die Heilung wieder nutzen können
        ItemUsed = false
        countRounds++

        if (bosses.isEmpty()) {
            println("Alle Bosse wurden besiegt. Der Bosskampf ist beendet.")
            break
        }
    }

    if (heroes.isEmpty()) {
        println("Game Over! Alle Helden wurden besiegt!")
    }
}


/**
 * Diese Funktion enthält die verschiedenen Aktionen, die Jack ausführen kann.
 * Je nach Auswahl des Spielers wird eine bestimmte Aktion ausgeführt und der entsprechende Schaden oder Effekt zurückgegeben.
 * Die Auswahlmöglichkeiten umfassen den Einsatz verschiedener Waffen, Heilung und Buffs.
 * Der Code enthält auch Fehlerbehandlung für den Fall, dass bestimmte Aktionen nicht möglich sind.
 */

fun actionsJack(): Int {
    val index = heroes.filter { it.name == "Jack O Neil" }
    val jack = index[0]

    //Logik für die Debuff überprüfung
    println("${jack.name} ist am Zug")
    val originalHealthPoints = jack.healthPoints
    val debuffHealthPoints: Int = originalHealthPoints / 100 * 10
    if (jack.debuff == true) {
        println("Du wurdest mit Naniten infiziert und verlierst jede Runde 10% Lebenspunkte")
        jack.healthPoints -= debuffHealthPoints
        println("Du wirst schwächer und verlierst $debuffHealthPoints Lebenspunkte")
    }

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
            val weapon = "M67"
            val damage = 30
            Grenade(weapon, footSoldiers).use(jack)
            damage
        }
// Bei der Try Catch habe ich mir hilfe von ChatGPT geholt, um den fehler zu lösen, da ich mich nicht mehr genaur daran erinnerte,
// wie das ganze nochmal funktioniert.
        5 -> {
            if (ItemUsed == true) {
                print("Die Heilung wurde bereits genutzt warte bis zur nächsten Runde")
                actionsJack()

            } else

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


/**
 * Diese Funktion definiert die Aktionen für den Charakter "Samantha".
 * Der Benutzer kann aus einer Liste von Aktionen auswählen, die verschiedene Waffen und einen Heilungsverband umfassen.
 * Die Funktion gibt den verursachten Schaden zurück.
 */
fun actionsSamantha(): Int {
    val index = heroes.filter { it.name == "Samantha Carter" }
    val sam = index[0]

    //Logik für die Debuff überprüfung
    val originalHealthPoints = sam.healthPoints
    val debuffHealthPoints: Int = originalHealthPoints / 100 * 10
    if (sam.debuff == true) {
        println("Du wurdest mit Naniten infiziert und verlierst jede Runde 10% Lebenspunkte")
        sam.healthPoints -= debuffHealthPoints
        println("Du wirst schwächer und verlierst $debuffHealthPoints Lebenspunkte")
    }

    println("${sam.name} ist am Zug")
    println("Bitte wählen sie eine Aktion aus")
    println("1 = P90- Maschinenpistole (15) Schaden")
    println("2 = G36 Maschinengewehr (25) Schaden")
    println("3 = Kull Disruptor (22) Schaden")
    println("4 = Granate (30 AOE)")
    println("5 = Verband zum Heilen (50)")
    val choice: Int = readlnOrNull()?.toIntOrNull() ?: 0

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

            // Die Aktion und der verursachte Schaden werden ausgegeben
            println("Samantha Carter zieht das $weapon hervor und feuert einen vernichtenden Energiestrahl auf den Feind! Die mächtige Entladung verursacht $damage Schadenspunkte.")
            damage
        }

        5 -> {
            if (ItemUsed == true) {
                // Die Meldung wird ausgegeben, dass die Heilung bereits genutzt wurde
                print("Die Heilung wurde bereits genutzt warte bis zur nächsten Runde")

                // Die Funktion wird erneut aufgerufen, um eine neue Aktion auszuwählen
                actionsSamantha()
            } else {
                try {
                    // Ein Verband wird genutzt und der Zustand "ItemUsed" wird auf true gesetzt
                    Bandages[0].use(sam)
                    ItemUsed = true
                } catch (e: IndexOutOfBoundsException) {
                    // Die Meldung wird ausgegeben, dass keine Verbände mehr vorhanden sind
                    println("Es gibt keine Verbände mehr im Rucksack.")

                    // Die Funktion wird erneut aufgerufen, um eine neue Aktion auszuwählen
                    actionsSamantha()
                }
            }
            0
        }

        else -> {
            // Die Meldung wird ausgegeben, dass die Auswahl ungültig ist
            println("Ungültige Auswahl")
            0
        }
    }
}


/**
 * Dieser Code ermöglicht es dem Charakter "TealC" verschiedene Aktionen auszuführen,
 * wie z.B. den Einsatz von Waffen oder Heilung.
 * Je nach Auswahl wird der entsprechende Schaden verursacht oder eine Aktion ausgeführt.
 */

fun actionsTealC(): Int {
    val index = heroes.filter { it.name == "Teal C" }
    val tealC = index[0]

    //Logik für die Debuff überprüfung
    val originalHealthPoints = tealC.healthPoints
    val debuffHealthPoints: Int = originalHealthPoints / 100 * 10
    if (tealC.debuff == true) {
        println("Du wurdest mit Naniten infiziert und verlierst jede Runde 10% Lebenspunkte")
        tealC.healthPoints -= debuffHealthPoints
        println("Du wirst schwächer und verlierst $debuffHealthPoints Lebenspunkte")
    }

    println("${tealC.name} ist am Zug")
    println("Bitte wählen sie eine Aktion aus")
    println("1 = Stabwaffe (35) Schaden")
    println("2 = M249 Maschinengewehr (15) Schaden")
    println("3 = Zat’nik’tel (25) Schaden")
    println("4 = Granate (30 AOE)")
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
            val weapon = "M67"
            val damage = 30
            Grenade(weapon, footSoldiers).use(tealC)
            damage
        }

        5 -> {
            if (ItemUsed == true) {
                print("Die Heilung wurde bereits genutzt warte bis zur nächsten Runde")
                actionsTealC()
            } else {
                try {
                    Bandages[0].use(tealC)
                    ItemUsed = true
                } catch (e: IndexOutOfBoundsException) {
                    println("Es gibt keine Verbände mehr im Rucksack.")
                    actionsTealC()
                }
            }
            0
        }


        else -> {
            println("Ungültige Auswahl")
            0
        }
    }

}

fun applyDebuff(targetHero: Hero) {
    val originalHealthPoints = targetHero.healthPoints
    val debuffHealthPoints: Int = originalHealthPoints / 100 * 10
    targetHero.debuff = true

    if (targetHero.debuff) {
        println("Du wurdest mit Naniten infiziert und verlierst jede Runde 10% Lebenspunkte")
        targetHero.healthPoints -= debuffHealthPoints
        println("Du wirst schwächer und verlierst $debuffHealthPoints Lebenspunkte")

        if (targetHero.healthPoints < originalHealthPoints * 0.2) {
            targetHero.debuff = false
        }
        println("Du bist nicht mehr infiziert, deine Lebenspunkte betragen aber nur noch: ${targetHero.healthPoints} Lebenspunkte")
    }
}

