package com.example.karumicounter

import androidx.test.core.app.ApplicationProvider
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class CounterStorageTest {
    val counterStorage = CounterStorage(ApplicationProvider.getApplicationContext())

    @Before
    fun before() {
        counterStorage.clear()
    }

    @After
    fun after() {
        counterStorage.clear()
    }

    @Test
    fun saveAValueAndGet() {
        counterStorage.save(12)
        val counter = counterStorage.getCounter()
        assertEquals(12, counter)
    }

    @Test
    fun ifThereIsNoValueTheResultIsNull() {
        val counter = counterStorage.getCounter()
        assertEquals(0, counter)
    }
}