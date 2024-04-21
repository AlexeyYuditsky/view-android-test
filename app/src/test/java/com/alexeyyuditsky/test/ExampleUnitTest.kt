package com.alexeyyuditsky.test

import com.alexeyyuditsky.test.test.getListDays
import org.junit.Assert
import org.junit.Test
import java.util.Calendar

class Test {

    @Test
    fun januaryPrevYear() {
        val actual = getListDays(
            month = Calendar.JANUARY,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected = (26..31).map { it.toString() } +
                (1..31).map { it.toString() } +
                (1..5).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun februaryPrevYear() {
        val actual = getListDays(
            month = Calendar.FEBRUARY,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected =
            (30..31).map { it.toString() } +
                    (1..28).map { it.toString() } +
                    (1..12).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun marchPrevYear() {
        val actual = getListDays(
            month = Calendar.MARCH,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected =
            (27..28).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..9).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun aprilPrevYear() {
        val actual = getListDays(
            month = Calendar.APRIL,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected =
            (27..31).map { it.toString() } +
                    (1..30).map { it.toString() } +
                    (1..7).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun mayPrevYear() {
        val actual = getListDays(
            month = Calendar.MAY,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected =
            (1..31).map { it.toString() } +
                    (1..11).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun junePrevYear() {
        val actual = getListDays(
            month = Calendar.JUNE,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected =
            (29..31).map { it.toString() } +
                    (1..30).map { it.toString() } +
                    (1..9).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun julyPrevYear() {
        val actual = getListDays(
            month = Calendar.JULY,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected =
            (26..30).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..6).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun augustPrevYear() {
        val actual = getListDays(
            month = Calendar.AUGUST,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected =
            (31..31).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..10).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun septemberPrevYear() {
        val actual = getListDays(
            month = Calendar.SEPTEMBER,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected =
            (28..31).map { it.toString() } +
                    (1..30).map { it.toString() } +
                    (1..8).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun octoberPrevYear() {
        val actual = getListDays(
            month = Calendar.OCTOBER,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected =
            (25..30).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..5).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun novemberPrevYear() {
        val actual = getListDays(
            month = Calendar.NOVEMBER,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected =
            (30..31).map { it.toString() } +
                    (1..30).map { it.toString() } +
                    (1..10).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun decemberPrevYear() {
        val actual = getListDays(
            month = Calendar.DECEMBER,
            year = Calendar.getInstance().get(Calendar.YEAR) - 1
        ).map { it.value }

        val expected =
            (27..30).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..7).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun januaryCurrentYear() {
        val actual = getListDays(
            month = Calendar.JANUARY,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (1..31).map { it.toString() } +
                    (1..11).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun februaryCurrentYear() {
        val actual = getListDays(
            month = Calendar.FEBRUARY,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (29..31).map { it.toString() } +
                    (1..29).map { it.toString() } +
                    (1..10).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun marchCurrentYear() {
        val actual = getListDays(
            month = Calendar.MARCH,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (26..29).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..7).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun aprilCurrentYear() {
        val actual = getListDays(
            month = Calendar.APRIL,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (1..30).map { it.toString() } +
                    (1..12).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun mayCurrentYear() {
        val actual = getListDays(
            month = Calendar.MAY,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (29..30).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..9).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun juneCurrentYear() {
        val actual = getListDays(
            month = Calendar.JUNE,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (27..31).map { it.toString() } +
                    (1..30).map { it.toString() } +
                    (1..7).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun julyCurrentYear() {
        val actual = getListDays(
            month = Calendar.JULY,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (1..31).map { it.toString() } +
                    (1..11).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun augustCurrentYear() {
        val actual = getListDays(
            month = Calendar.AUGUST,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (29..31).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..8).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun septemberCurrentYear() {
        val actual = getListDays(
            month = Calendar.SEPTEMBER,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (26..31).map { it.toString() } +
                    (1..30).map { it.toString() } +
                    (1..6).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun octoberCurrentYear() {
        val actual = getListDays(
            month = Calendar.OCTOBER,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (30..30).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..10).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun novemberCurrentYear() {
        val actual = getListDays(
            month = Calendar.NOVEMBER,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (28..31).map { it.toString() } +
                    (1..30).map { it.toString() } +
                    (1..8).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun decemberCurrentYear() {
        val actual = getListDays(
            month = Calendar.DECEMBER,
            year = Calendar.getInstance().get(Calendar.YEAR)
        ).map { it.value }

        val expected =
            (25..30).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..5).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun januaryNextYear() {
        val actual = getListDays(
            month = Calendar.JANUARY,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (30..31).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..9).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun februaryNextYear() {
        val actual = getListDays(
            month = Calendar.FEBRUARY,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (27..31).map { it.toString() } +
                    (1..28).map { it.toString() } +
                    (1..9).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun marchNextYear() {
        val actual = getListDays(
            month = Calendar.MARCH,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (24..28).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..6).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun aprilNextYear() {
        val actual = getListDays(
            month = Calendar.APRIL,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (31..31).map { it.toString() } +
                    (1..30).map { it.toString() } +
                    (1..11).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun mayNextYear() {
        val actual = getListDays(
            month = Calendar.MAY,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (28..30).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..8).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun juneNextYear() {
        val actual = getListDays(
            month = Calendar.JUNE,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (26..31).map { it.toString() } +
                    (1..30).map { it.toString() } +
                    (1..6).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun julyNextYear() {
        val actual = getListDays(
            month = Calendar.JULY,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (30..30).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..10).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun augustNextYear() {
        val actual = getListDays(
            month = Calendar.AUGUST,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (28..31).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..7).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun septemberNextYear() {
        val actual = getListDays(
            month = Calendar.SEPTEMBER,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (1..30).map { it.toString() } +
                    (1..12).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun octoberNextYear() {
        val actual = getListDays(
            month = Calendar.OCTOBER,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (29..30).map { it.toString() } +
                    (1..31).map { it.toString() } +
                    (1..9).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun novemberNextYear() {
        val actual = getListDays(
            month = Calendar.NOVEMBER,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (27..31).map { it.toString() } +
                    (1..30).map { it.toString() } +
                    (1..7).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun decemberNextYear() {
        val actual = getListDays(
            month = Calendar.DECEMBER,
            year = Calendar.getInstance().get(Calendar.YEAR) + 1
        ).map { it.value }

        val expected =
            (1..31).map { it.toString() } +
                    (1..11).map { it.toString() }

        Assert.assertEquals(expected, actual)
    }
}