package com.example.koelnhunt.models

class QuestionDataSource {

// In a real app you don't do this. You don't hardcode in data into your App. You get it from somewhere in the Internet

    companion object{
        fun createQuestionSet(): ArrayList<QuestionCardStructure> {
            val list = ArrayList<QuestionCardStructure>()
            list.add(
                QuestionCardStructure("Frage 1", "Antwort 1")
            )
            list.add(
                QuestionCardStructure("Frage 2", "Antwort 2")
            )
            list.add(
                QuestionCardStructure("Frage 3", "Antwort 3")
            )
            list.add(
                QuestionCardStructure("Frage 4", "Antwort 4")
            )
            list.add(
                QuestionCardStructure("Frage 5", "Antwort 5")
            )
            list.add(
                QuestionCardStructure("Frage 6", "Antwort 6")
            )
            list.add(
                QuestionCardStructure("Frage 7", "Antwort 7")
            )
            list.add(
                QuestionCardStructure("Frage 8", "Antwort 8")
            )
            list.add(
                QuestionCardStructure("Frage 9", "Antwort 9")
            )
            list.add(
                QuestionCardStructure("Frage 10", "Antwort 10")
            )
            return list
        }
    }
}