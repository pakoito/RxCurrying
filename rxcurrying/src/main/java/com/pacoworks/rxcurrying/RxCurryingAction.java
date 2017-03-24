/*
 * Copyright (c) pakoito 2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.rxcurrying;

import java.lang.reflect.Method;

import rx.functions.*;

/**
 * Helper class to curry ActionN objects
 *
 * @author pakoito
 */
public class RxCurryingAction {

    private static final Method[] ACTION_CALL_METHODS = {
        Action0.class.getMethods()[0],
        Action1.class.getMethods()[0],
        Action2.class.getMethods()[0],
        Action3.class.getMethods()[0],
        Action4.class.getMethods()[0],
        Action5.class.getMethods()[0],
        Action6.class.getMethods()[0],
        Action7.class.getMethods()[0],
        Action8.class.getMethods()[0],
        Action9.class.getMethods()[0]
    };

    private RxCurryingAction() {
    }

    public static <A, B> Func1<A, Action1<B>> curry(final Action2<A, B> action) {
        return fuzzyFunction(action, 2); //proxyFunction(action, 1);
    }

    public static <A, B, C> Func1<A, Func1<B, Action1<C>>> curry(final Action3<A, B, C> action) {
        return fuzzyFunction(action, 3);
    }

    public static <A, B, C, D> Func1<A, Func1<B, Func1<C, Action1<D>>>> curry(
            final Action4<A, B, C, D> action) {
        return fuzzyFunction(action, 4);
    }

    public static <A, B, C, D, E> Func1<A, Func1<B, Func1<C, Func1<D, Action1<E>>>>> curry(
            final Action5<A, B, C, D, E> action) {
        return fuzzyFunction(action, 5);
    }

    public static <A, B, C, D, E, F> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Action1<F>>>>>> curry(
            final Action6<A, B, C, D, E, F> action) {
        return fuzzyFunction(action, 6);
    }

    public static <A, B, C, D, E, F, G> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Action1<G>>>>>>> curry(
            final Action7<A, B, C, D, E, F, G> action) {
        return fuzzyFunction(action, 7);
    }

    public static <A, B, C, D, E, F, G, H> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action1<H>>>>>>>> curry(
            final Action8<A, B, C, D, E, F, G, H> action) {
        return fuzzyFunction(action, 8);
    }

    public static <A, B, C, D, E, F, G, H, I> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action1<I>>>>>>>>> curry(
            final Action9<A, B, C, D, E, F, G, H, I> action) {
        return fuzzyFunction(action, 9);
    }

    private static <T> ArgumentConsumer consumeFunction(final T func, final Method method) {
        return new ArgumentConsumer() {
            @Override
            public Object onArgumentsReady(Object[] a) {
                try {
                    return method.invoke(func, a);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    private static <T extends Func1, P extends Action> T fuzzyFunction(P finalFunction, int targetLevel) {
        return (T) new FuzzyAction(targetLevel, consumeFunction(finalFunction, ACTION_CALL_METHODS[targetLevel]));
    }

}
