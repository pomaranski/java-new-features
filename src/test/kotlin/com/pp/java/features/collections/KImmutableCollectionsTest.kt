package com.pp.java.features.collections

import org.junit.jupiter.api.Test

class KImmutableCollectionsTest {

    @Test
    fun shouldPresentBetterDesignedInterfaces() {
        val list = listOf(1, 2, 3)

        /*
        will not compile because List and other collections in Kotlin are immutable
        only MutableList which extends interface can modify list

        list.add(1)
        */

        val mutableList = list.toMutableList()

        mutableList.add(4)
    }
}