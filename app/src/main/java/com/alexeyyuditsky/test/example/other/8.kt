package com.alexeyyuditsky.test.example.other

interface BundleWrapper {

    interface Save : BundleWrapper {
        fun save()
    }

    interface Get : BundleWrapper {
        fun get()
    }

    interface Mutable : Save, Get

    class Base(
        private val bundle: Bundle
    ) : Mutable {
        override fun save() {
            bundle.save()
        }

        override fun get() {
            bundle.get()
        }
    }

}

class Bundle {
    fun save() = Unit
    fun get() = Unit
}

fun main() {
    val bundleWrapper: BundleWrapper.Mutable = BundleWrapper.Base(Bundle())
    Test1(bundleWrapper)
    Test2(bundleWrapper)
}

class Test1(
    bundleWrapper: BundleWrapper.Save
) {
    init {
        bundleWrapper.save()
    }
}

class Test2(
    bundleWrapper: BundleWrapper.Get
) {
    init {
        bundleWrapper.get()
    }
}