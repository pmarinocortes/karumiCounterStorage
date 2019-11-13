package com.example.karumicounter

class MagicCounter(val storage: CounterStorage, val random: Random) {
    fun increment(): Int {
        var counter = storage.getCounter() ?: 0
        val random = random.getRandom()

        val updatedCounter = if(random < 100) {
            counter + 1
        } else {
            counter + random
        }

        storage.save(updatedCounter as Int)
        return updatedCounter
    }

    fun decrement(): Int {
        val updatedCounter = (storage.getCounter() ?: 0) - 1
        storage.save(updatedCounter)
        return updatedCounter
    }
}

interface Random {
    fun getRandom(): Int
}

class SystemRandom: Random {
    override fun getRandom(): Int = Math.random().toInt()

}