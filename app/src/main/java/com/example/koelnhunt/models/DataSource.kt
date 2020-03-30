package com.example.koelnhunt.models

class DataSource {

// In a real app you don't do this. You don't hardcode in data into your App. You get it from somewhere in the Internet
    
    companion object{
        fun createDataSet(): ArrayList<CardStructure> {
            val list = ArrayList<CardStructure>()
            list.add(
                CardStructure("Station", 1)
            )
            list.add(
                CardStructure("Station", 2)
            )
            list.add(
                CardStructure("Station", 3)
            )
            list.add(
                CardStructure("Station", 4)
            )
            list.add(
                CardStructure("Station", 5)
            )
            list.add(
                CardStructure("Station", 6)
            )
            list.add(
                CardStructure("Station", 7)
            )
            list.add(
                CardStructure("Station", 8)
            )
            list.add(
                CardStructure("Station", 9)
            )
            list.add(
                CardStructure("Station", 10)
            )
            return list
        }
    }
}