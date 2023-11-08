open class Hero(val name: String, var healthPoints: Int, var debuff: Boolean = false) {

    // **Methode um eine Aktion mit einer Waffe auszuführen**
    open fun action(weaponName: String, damage: Int): Int {
        // Gibt den Schaden zurück, der durch die Aktion verursacht wird
        println("Name:$name")
        println("HP:$healthPoints")
        println()
        return damage
    }

    // **Methode um Schaden zu nehmen**
    open fun takeDamage(damage: Int) {
        // Verringert die Gesundheitspunkte des Helden um den angegebenen Wert
        healthPoints -= damage

        // Gibt eine Nachricht aus, wenn der Held Schaden nimmt
        if (damage > 0) {
            println("$name hat $damage Schaden genommen.")
        }

        // Gibt eine Nachricht aus, wenn der Held stirbt
        if (healthPoints <= 0) {
            println("$name ist gestorben.")
        }
    }

    // **Methode um einen Schrei auszuführen, der die Gesundheitspunkte erhöht**
    open fun shout(buffHealth: Int) {
        // Erhöht die Gesundheitspunkte des Helden um den angegebenen Wert
        healthPoints += buffHealth

        // Gibt eine Nachricht aus, wenn der Held geheilt wurde
        if (buffHealth > 0) {
            println("$name wurde um $buffHealth geheilt.")
        }
    }
}

class Soldier(name: String, healthPoints: Int, debuff: Boolean) : Hero(name, healthPoints, debuff) {

    override fun action(weaponName: String, damage: Int): Int {
        // Gibt den Schaden zurück, der durch den Angriff des Soldaten verursacht wird
        return damage * 2
    }
}


class Scientist(name: String, healthPoints: Int, debuff: Boolean) : Hero(name, healthPoints, debuff) {

    override fun action(weaponName: String, damage: Int): Int {
        // Gibt den Schaden zurück, der durch den Angriff des Wissenschaftlers verursacht wird
        return damage
    }
}

class Jaffa(name: String, healthPoints: Int, debuff: Boolean) : Hero(name, healthPoints, debuff) {

    override fun action(weaponName: String, damage: Int): Int {
        // Gibt den Schaden zurück, der durch den Angriff des Jaffas verursacht wird
        return damage + 10
    }
}


