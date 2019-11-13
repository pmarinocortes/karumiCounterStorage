package com.example.karumicounter

import androidx.test.core.app.ApplicationProvider
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class MagicCounterTest {
    private val counterStorage = CounterStorage(ApplicationProvider.getApplicationContext())
    private var fixedRandom = FixedRandom()
    val magicCounter = MagicCounter(
        counterStorage,fixedRandom
    )

    @Before
    fun before() {
        counterStorage.clear()
    }

    @After
    fun after() {
        counterStorage.clear()
    }

    @Test
    fun whenRandomIsUnder100ThenCounterIncrementsInOne() {
        counterStorage.save(2)
        fixedRandom.number = 9
        val increment = magicCounter.increment()

        assertEquals(3, increment)
    }

    @Test
    fun whenRandomIsOver100ThenCounterIncrementsWithRandomValue() {
        counterStorage.save(2)
        fixedRandom.number = 130
        val increment = magicCounter.increment()

        assertEquals(132, increment)
    }

    @Test
    fun whenDecrementMethodIsFiredThenCounterDecrementsInOne() {
        counterStorage.save(3)
        val decrement = magicCounter.decrement()

        assertEquals(2, decrement)
    }

}

class FixedRandom : Random {

    var number = 0
    override fun getRandom(): Int = number

}