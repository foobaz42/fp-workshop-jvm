package org.artrev.workshop.fp.part2.practice;

import org.artrev.workshop.fp.tools.Function1;
import org.artrev.workshop.fp.tools.collections.Lists;
import org.artrev.workshop.fp.tools.Predicate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice {
    static <A> Boolean forAll(final List<A> list,
                              final Predicate<A> predicate) {
        return Lists.foldLeft(list, true, (all, element) -> all && predicate.test(element));
    }

    static <A, B> List<B> map(final List<A> list,
                              final Function1<A, B> mapper) {
        return Lists.foldLeft(list, Collections.emptyList(),
                (result, element) -> Lists.append(result, mapper.apply(element))
        );
    }

    static <A> Function1<A, A> compose(final Function1<A, A>... functions) {
        return Lists.foldLeft(
                Arrays.asList(functions),
                Function1.identity(),
                Function1::andThen
        );
    }
}
