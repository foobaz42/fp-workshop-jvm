@file:Suppress("UNUSED_PARAMETER", "unused")

package io.github.ajoz.workshop.fp.kotlin.part_1.solutions.practice_2

import io.github.ajoz.workshop.fp.kotlin.tools.and
import io.github.ajoz.workshop.fp.kotlin.tools.or

// Part 1:
fun <A : Any, B : Any> instanceOf(type: Class<out A>): (B) -> Boolean =
        { b: B -> type.isAssignableFrom(b::class.java) }

// Part 2:
fun <A> alwaysTrue(): (A) -> Boolean = { true }

// Part 3:
fun <A> alwaysFalse(): (A) -> Boolean = { false }

// Part 4:
fun <A> isEqualTo(value: A): (A) -> Boolean = { it == value }

// Part 5:
fun isLargerThen(value: Int): (Int) -> Boolean = { it > value }

// Part 6:
fun isLowerThen(value: Int): (Int) -> Boolean = { it < value }

// Part 7:
val isAllowed: (Int) -> Boolean =
        (isLargerThen(0) and isLowerThen(6)) or isEqualTo(42)