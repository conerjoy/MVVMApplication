package com.coner.mvvmapplication.ui.mainactivity

import com.coner.mvvmapplication.entity.Person

/**
 * @author coner
 */
class MainContract {
    interface ViewModel {
        fun getFirstPerson()
        fun getSecondPerson()
    }

    interface Model {
        fun getFirstPerson(callBack: (Person) -> Unit)
        fun getSecondPerson(callBack: (Person) -> Unit)
    }
}