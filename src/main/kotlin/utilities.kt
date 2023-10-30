fun actionsJack() {
    val hero: Hero = JackONeil
    println("Bitte wählen sie eine Aktion aus")
    println("1 = P90- Maschinenpistole (15) Schaden")
    println("2 = Beretta 9mm (5) Schaden")
    println("3 = Zat’nik’tel (25) Schaden")
    println("4 = M60 Maschinengewehr")
    println("5 = Granate (AOE)")
    println("Bitte mach deine Eingabe:")

    val choice = readlnOrNull()?.toIntOrNull()

    when (choice) {
        1 -> hero.action(hero.name, "P90-Maschinenpistole", 15)

        2 -> hero.action(hero.name, "Beretta 9mm", 5)

        3 -> hero.action(hero.name, "Zat’nik’tel", 25)

        4 -> hero.action(hero.name, "M60 Maschinengewehr", 12)

        //Granate noch mit AOE funktion erweitern

        5 -> hero.action(hero.name, "Granate", 30)

        else -> println("Ungültige Auswahl")
    }
}
fun actionsSamantha() {
    val hero: Hero = samanthaCarter
    println("Bitte wählen sie eine Aktion aus")
    println("1 = P90- Maschinenpistole (15) Schaden")
    println("2 = G36 Maschinengewehr (25) Schaden")
    println("3 = Kull Disruptor (22) Schaden")
    println("4 = Goa`Uld Handgerät (40) Schaden")
    println("5 = Granate (AOE)")
    println("Bitte mach deine Eingabe:")

    val choice = readlnOrNull()?.toIntOrNull()

    when (choice) {
        1 -> hero.action(hero.name, "P90-Maschinenpistole", 15)

        2 -> hero.action(hero.name, "G36 Maschinengewehr", 25)

        3 -> hero.action(hero.name, "Kull Disruptor", 22)

        4 -> hero.action(hero.name, "Goa`Uld Handgerät", 40)

        //Granate noch mit AOE funktion erweitern

        5 -> hero.action(hero.name, "Granate", 30)

        else -> println("Ungültige Auswahl")
    }

}