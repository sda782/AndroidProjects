package com.example.collectperson

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel() {
    private var _nextId = 1
    private var _personListData = mutableListOf<Person>(
        Person(_nextId++,"andy", 20, "road", 42),
        Person(_nextId++,"freddy", 21, "road1", 44),
        Person(_nextId++,"danny", 22, "road2", 43),
    )
    private var _personList = MutableLiveData<List<Person>>(_personListData)
    var personList : LiveData<List<Person>> = _personList
    fun addPerson(person: Person):Number{
        person.id = _nextId++
        _personListData.add(person)
        return person.id
    }

    fun UndoLast(id:Number) {
        _personListData.removeLast()
    }
}