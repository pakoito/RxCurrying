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

import rx.functions.*;

/**
 * Helper class to curry FuncN objects
 *
 * @author pakoito
 */
public class RxCurryingFunc {
    private RxCurryingFunc() {
    }

    public static <A, R> Func1<A, Func0<R>> curry(final Func1<A, R> func) {
        return new Func1<A, Func0<R>>() {
            @Override
            public Func0<R> call(final A a) {
                return new Func0<R>() {
                    @Override
                    public R call() {
                        return func.call(a);
                    }
                };
            }
        };
    }

    public static <A, B, R> Func1<A, Func1<B, Func0<R>>> curry(final Func2<A, B, R> func) {
        return new Func1<A, Func1<B, Func0<R>>>() {
            @Override
            public Func1<B, Func0<R>> call(final A a) {
                return new Func1<B, Func0<R>>() {
                    @Override
                    public Func0<R> call(final B b) {
                        return new Func0<R>() {
                            @Override
                            public R call() {
                                return func.call(a, b);
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, R> Func1<A, Func1<B, Func1<C, Func0<R>>>> curry(
            final Func3<A, B, C, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func0<R>>>>() {
            @Override
            public Func1<B, Func1<C, Func0<R>>> call(final A a) {
                return new Func1<B, Func1<C, Func0<R>>>() {
                    @Override
                    public Func1<C, Func0<R>> call(final B b) {
                        return new Func1<C, Func0<R>>() {
                            @Override
                            public Func0<R> call(final C c) {
                                return new Func0<R>() {
                                    @Override
                                    public R call() {
                                        return func.call(a, b, c);
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, R> Func1<A, Func1<B, Func1<C, Func1<D, Func0<R>>>>> curry(
            final Func4<A, B, C, D, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func0<R>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func0<R>>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Func0<R>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func0<R>>> call(final B b) {
                        return new Func1<C, Func1<D, Func0<R>>>() {
                            @Override
                            public Func1<D, Func0<R>> call(final C c) {
                                return new Func1<D, Func0<R>>() {
                                    @Override
                                    public Func0<R> call(final D d) {
                                        return new Func0<R>() {
                                            @Override
                                            public R call() {
                                                return func.call(a, b, c, d);
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, E, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func0<R>>>>>> curry(
            final Func5<A, B, C, D, E, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func0<R>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func0<R>>>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func0<R>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func0<R>>>> call(final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func0<R>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func0<R>>> call(final C c) {
                                return new Func1<D, Func1<E, Func0<R>>>() {
                                    @Override
                                    public Func1<E, Func0<R>> call(final D d) {
                                        return new Func1<E, Func0<R>>() {
                                            @Override
                                            public Func0<R> call(final E e) {
                                                return new Func0<R>() {
                                                    @Override
                                                    public R call() {
                                                        return func.call(a, b, c, d, e);
                                                    }
                                                };
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, E, F, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func0<R>>>>>>> curry(
            final Func6<A, B, C, D, E, F, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func0<R>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func0<R>>>>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func0<R>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func0<R>>>>> call(final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func0<R>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func0<R>>>> call(final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func0<R>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func0<R>>> call(final D d) {
                                        return new Func1<E, Func1<F, Func0<R>>>() {
                                            @Override
                                            public Func1<F, Func0<R>> call(final E e) {
                                                return new Func1<F, Func0<R>>() {
                                                    @Override
                                                    public Func0<R> call(final F f) {
                                                        return new Func0<R>() {
                                                            @Override
                                                            public R call() {
                                                                return func.call(a, b, c, d, e, f);
                                                            }
                                                        };
                                                    }
                                                };
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, E, F, G, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func0<R>>>>>>>> curry(
            final Func7<A, B, C, D, E, F, G, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func0<R>>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func0<R>>>>>>> call(
                    final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func0<R>>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func0<R>>>>>> call(
                            final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func0<R>>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func1<G, Func0<R>>>>> call(
                                    final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func1<G, Func0<R>>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func1<G, Func0<R>>>> call(final D d) {
                                        return new Func1<E, Func1<F, Func1<G, Func0<R>>>>() {
                                            @Override
                                            public Func1<F, Func1<G, Func0<R>>> call(final E e) {
                                                return new Func1<F, Func1<G, Func0<R>>>() {
                                                    @Override
                                                    public Func1<G, Func0<R>> call(final F f) {
                                                        return new Func1<G, Func0<R>>() {
                                                            @Override
                                                            public Func0<R> call(final G g) {
                                                                return new Func0<R>() {
                                                                    @Override
                                                                    public R call() {
                                                                        return func.call(a, b, c, d,
                                                                                e, f, g);
                                                                    }
                                                                };
                                                            }
                                                        };
                                                    }
                                                };
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, E, F, G, H, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func0<R>>>>>>>>> curry(
            final Func8<A, B, C, D, E, F, G, H, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func0<R>>>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func0<R>>>>>>>> call(
                    final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func0<R>>>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func0<R>>>>>>> call(
                            final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func0<R>>>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func0<R>>>>>> call(
                                    final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func0<R>>>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func1<G, Func1<H, Func0<R>>>>> call(
                                            final D d) {
                                        return new Func1<E, Func1<F, Func1<G, Func1<H, Func0<R>>>>>() {
                                            @Override
                                            public Func1<F, Func1<G, Func1<H, Func0<R>>>> call(
                                                    final E e) {
                                                return new Func1<F, Func1<G, Func1<H, Func0<R>>>>() {
                                                    @Override
                                                    public Func1<G, Func1<H, Func0<R>>> call(
                                                            final F f) {
                                                        return new Func1<G, Func1<H, Func0<R>>>() {
                                                            @Override
                                                            public Func1<H, Func0<R>> call(
                                                                    final G g) {
                                                                return new Func1<H, Func0<R>>() {
                                                                    @Override
                                                                    public Func0<R> call(
                                                                            final H h) {
                                                                        return new Func0<R>() {
                                                                            @Override
                                                                            public R call() {
                                                                                return func.call(a,
                                                                                        b, c, d, e,
                                                                                        f, g, h);
                                                                            }
                                                                        };
                                                                    }
                                                                };
                                                            }
                                                        };
                                                    }
                                                };
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, E, F, G, H, I, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>>>>>>> curry(
            final Func9<A, B, C, D, E, F, G, H, I, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>>>>>> call(
                    final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>>>>> call(
                            final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>>>> call(
                                    final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>>> call(
                                            final D d) {
                                        return new Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>>>() {
                                            @Override
                                            public Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>> call(
                                                    final E e) {
                                                return new Func1<F, Func1<G, Func1<H, Func1<I, Func0<R>>>>>() {
                                                    @Override
                                                    public Func1<G, Func1<H, Func1<I, Func0<R>>>> call(
                                                            final F f) {
                                                        return new Func1<G, Func1<H, Func1<I, Func0<R>>>>() {
                                                            @Override
                                                            public Func1<H, Func1<I, Func0<R>>> call(
                                                                    final G g) {
                                                                return new Func1<H, Func1<I, Func0<R>>>() {
                                                                    @Override
                                                                    public Func1<I, Func0<R>> call(
                                                                            final H h) {
                                                                        return new Func1<I, Func0<R>>() {
                                                                            @Override
                                                                            public Func0<R> call(
                                                                                    final I i) {
                                                                                return new Func0<R>() {
                                                                                    @Override
                                                                                    public R call() {
                                                                                        return func
                                                                                                .call(a, b,
                                                                                                        c,
                                                                                                        d,
                                                                                                        e,
                                                                                                        f,
                                                                                                        g,
                                                                                                        h,
                                                                                                        i);
                                                                                    }
                                                                                };
                                                                            }
                                                                        };
                                                                    }
                                                                };
                                                            }
                                                        };
                                                    }
                                                };
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }
}
