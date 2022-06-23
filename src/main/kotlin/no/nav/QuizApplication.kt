package no.nav

import no.nav.db.Database
import no.nav.quizrapid.*
import no.nav.rapid.Assessment
import no.nav.rapid.Question


/**
 * QuizApplication
 *
 * Her skal teamet bygge ut funksjonalitet for å løse oppgavene i leesah-game.
 */
class QuizApplication(private val teamName: String, database: Database? = null): QuizParticipant(teamName) {

    override fun handle(question: Question) {
        logger.log(question)
        if (question.category == "team-registration") handleRegisterTeam(question)

        if (question.category == "arithmetic") handleArithmetic(question)

        if (question.category == "make-ingress") makeIngress(question)

        if (question.category == "NAV") returnNAV(question)



    }


    override fun handle(assessment: Assessment) {
        logger.log(assessment)
    }

    /**
     * Spørsmål handlers
     */

    private fun handleRegisterTeam(question: Question) {
        answer(question.category, question.id(), teamName)
    }

    private fun handleArithmetic(question: Question){


        val q = question.question
        val del = " "
        val list = q.split(del)
        var final_val = 0
        println(list)
        if (list[1].equals("+")) {
            final_val = list[0].toInt() + list[2].toInt()
        }
        else if (list[1].equals("-")) {
            final_val = list[0].toInt() - list[2].toInt()
        }
        else if (list[1].equals("*")) {
            final_val = list[0].toInt() * list[2].toInt()
        }
        else if (list[1].equals("/")) {
            final_val = (list[0].toInt() / list[2].toInt()).toInt()
        }
        println(final_val)
        answer(question.category, question.messageId, final_val.toString())

    }
    private fun makeIngress(question: Question) {
        answer(question.category, question.messageId, "https://too-fast-too-furious.dev.intern.nav.no")
    }

    private fun returnNAV(question: Question){
        val q = question.question

        if (q.contains("applikasjonsplatformen")){
            answer(question.category, question.messageId, "NAIS")
        }
        else if (q.contains("nettside")){
            answer(question.category, question.messageId, "detsombetyrnoe.no")
        }
    }

}