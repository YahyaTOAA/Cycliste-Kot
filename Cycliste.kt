package tps3

//Exercice 2 Question 1
data class Etape(var nom: String, var dateDebut: String, var dateFin: String, var distance: Int, var difficulte: Difficulte)
enum class Difficulte{
    FACILE,DIFFICILE
}
//Exercice 2 Question 2
//data class Resultat(val tempsEffectue: Int, val classement: Int)
//Exercice 2 Question 3
class Cycliste(var nom: String, var prenom: String, var nationalite: String, var age: Int) {
    val historiqueEtapes = hashMapOf<Etape, Resultat>()

    fun nouvelleEtape(etape: Etape, resultat: Resultat) {
        historiqueEtapes[etape] = resultat
    }

    override fun toString(): String {
        var infoCycliste = "Cycliste: $prenom $nom\n"
        for ((etape, resultat) in historiqueEtapes) {
            infoCycliste += "Etape: ${etape.nom}, Résultat: $resultat\n"
        }
        return infoCycliste
    }
}

fun main() {
    //Exercice 2 Question 4
    val cycliste = Cycliste("John", "Doe", "France", 25)

    val etape1 = Etape("Etape 1", "01/01/2022", "02/01/2022", 100, Difficulte.FACILE)
    val etape2 = Etape("Etape 2", "03/01/2022", "04/01/2022", 150, Difficulte.DIFFICILE)
    val etape3 = Etape("Etape 3", "05/01/2022", "06/01/2022", 120, Difficulte.FACILE)

//    val resultat1 = Resultat(120, 1)
//    val resultat2 = Resultat(150, 2)
//    val resultat3 = Resultat(130, 3)
//
//    cycliste.nouvelleEtape(etape1, resultat1)
//    cycliste.nouvelleEtape(etape2, resultat2)
//    cycliste.nouvelleEtape(etape3, resultat3)

    //Exercice 2 Question 7
    cycliste.nouvelleEtape(etape1, Resultat.Termine(3600, 1))
    cycliste.nouvelleEtape(etape2, Resultat.Abandonne(80, "Problème mécanique"))
    cycliste.nouvelleEtape(etape3, Resultat.Termine(4200, 2))

    println(cycliste)


}
//Exercice 2 Question 5/6
sealed class Resultat {
    data class Termine(var tempsEffectue: Int, var classement: Int) : Resultat()
    data class Abandonne(var distanceParcourue: Int, var raison: String) : Resultat()
}


