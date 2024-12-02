package com.alexeyyuditsky.test.example.other

class TestModeSet(
    testModeProvider: TestModeProvider.Set
) {
    init {
        testModeProvider.setTestMode(true)
    }
}

class TestModeFetch(
    testModeProvider: TestModeProvider.Fetch
) {
    init {
        testModeProvider.fetchTestMode()
    }
}

interface TestModeProvider {

    interface Set : TestModeProvider {
        fun setTestMode(mode: Boolean)
    }

    interface Fetch : TestModeProvider {
        fun fetchTestMode(): Boolean
    }

    class Base(
        private val prefHelper: PrefHelper
    ) : Set, Fetch {
        override fun setTestMode(mode: Boolean) {
            TODO("Not yet implemented")
        }

        override fun fetchTestMode(): Boolean {
            TODO("Not yet implemented")
        }
    }

}

class PrefHelper