package io.github.ajoz.workshop.fp.kotlin.tools.flow

import io.github.ajoz.workshop.fp.kotlin.tools.Try

/**
 *
 */
fun <A, B> Flow<A>.map(function: (A) -> B): Flow<B> {
    class MapFlow<A, B>(val upstream: Flow<A>,
                        val mapper: (A) -> B) : Flow<B> {

        override fun next(): Try<B> =
                upstream.next().map(mapper)
    }

    return MapFlow(this, function)
}
