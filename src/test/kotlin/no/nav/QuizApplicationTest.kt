package no.nav

import no.nav.rapid.Answer
import no.nav.rapid.Question
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class QuizApplicationTest {


    @Test
    fun `håndterer team-registration`() {
        val teamNavn = "mitt-team-navn"
        val qa = QuizApplication(teamNavn)
        qa.handle(Question(category = "team-registration", question =  "register new team..."))
        val messages = qa.messages()
        assertEquals(1, messages.size)
        assertEquals(teamNavn, (messages[0] as Answer).answer)
    }

    @Test
    fun `håndtere arithmetic`(){

        val qa = QuizApplication("too-fast-too-furious")
        qa.handle(Question(category = "arithmetic", question = "82 - 36"))
        val mes = qa.messages()
        assertEquals((82-36).toString(), (mes[0] as Answer).answer)



    }

}