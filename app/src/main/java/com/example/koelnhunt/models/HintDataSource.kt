package com.example.koelnhunt.models

class HintDataSource {

// In a real app you don't do this. You don't hardcode in data into your App. You get it from somewhere in the Internet

    companion object{
        fun createHintSet(): ArrayList<String> {
            val list = ArrayList<String>()
            list.add("Hint 1")
            list.add("Hint 2")
            list.add("Hint 3")
            list.add("Hint 4")
            list.add("Hint 5")
            list.add("Hint 6")
            list.add("Hint 7")
            list.add("Hint 8")
            list.add("Hint 9")
            list.add("Hint 10")
            return list
        }
    }
}