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

    public static <A, B, R> Func1<A, Func1<B, R>> curry(final Func2<A, B, R> func) {
        return new Func1<A, Func1<B, R>>() {
            @Override
            public Func1<B, R> call(final A a) {
                return new Func1<B, R>() {
                    @Override
                    public R call(final B b) {
                        return func.call(a, b);
                    }
                };
            }
        };
    }

    public static <A, B, C, R> Func1<A, Func1<B, Func1<C, R>>> curry(final Func3<A, B, C, R> func) {
        return new Func1<A, Func1<B, Func1<C, R>>>() {
            @Override
            public Func1<B, Func1<C, R>> call(final A a) {
                return new Func1<B, Func1<C, R>>() {
                    @Override
                    public Func1<C, R> call(final B b) {
                        return new Func1<C, R>() {
                            @Override
                            public R call(final C c) {
                                return func.call(a, b, c);
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D, R> Func1<A, Func1<B, Func1<C, Func1<D, R>>>> curry(
            final Func4<A, B, C, D, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, R>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, R>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, R>>>() {
                    @Override
                    public Func1<C, Func1<D, R>> call(final B b) {
                        return new Func1<C, Func1<D, R>>() {
                            @Override
                            public Func1<D, R> call(final C c) {
                                return new Func1<D, R>() {
                                    @Override
                                    public R call(final D d) {
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

    public static <A, B, C, D, E, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, R>>>>> curry(
            final Func5<A, B, C, D, E, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, R>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, R>>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, R>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, R>>> call(final B b) {
                        return new Func1<C, Func1<D, Func1<E, R>>>() {
                            @Override
                            public Func1<D, Func1<E, R>> call(final C c) {
                                return new Func1<D, Func1<E, R>>() {
                                    @Override
                                    public Func1<E, R> call(final D d) {
                                        return new Func1<E, R>() {
                                            @Override
                                            public R call(final E e) {
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

    public static <A, B, C, D, E, F, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, R>>>>>> curry(
            final Func6<A, B, C, D, E, F, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, R>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, R>>>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, R>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, R>>>> call(final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, R>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, R>>> call(final C c) {
                                return new Func1<D, Func1<E, Func1<F, R>>>() {
                                    @Override
                                    public Func1<E, Func1<F, R>> call(final D d) {
                                        return new Func1<E, Func1<F, R>>() {
                                            @Override
                                            public Func1<F, R> call(final E e) {
                                                return new Func1<F, R>() {
                                                    @Override
                                                    public R call(final F f) {
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

    public static <A, B, C, D, E, F, G, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, R>>>>>>> curry(
            final Func7<A, B, C, D, E, F, G, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, R>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, R>>>>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, R>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, R>>>>> call(final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, R>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func1<G, R>>>> call(final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func1<G, R>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func1<G, R>>> call(final D d) {
                                        return new Func1<E, Func1<F, Func1<G, R>>>() {
                                            @Override
                                            public Func1<F, Func1<G, R>> call(final E e) {
                                                return new Func1<F, Func1<G, R>>() {
                                                    @Override
                                                    public Func1<G, R> call(final F f) {
                                                        return new Func1<G, R>() {
                                                            @Override
                                                            public R call(final G g) {
                                                                return func.call(a, b, c, d, e, f,
                                                                        g);
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

    public static <A, B, C, D, E, F, G, H, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, R>>>>>>>> curry(
            final Func8<A, B, C, D, E, F, G, H, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, R>>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, R>>>>>>> call(
                    final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, R>>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, R>>>>>> call(
                            final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, R>>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, R>>>>> call(
                                    final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, R>>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func1<G, Func1<H, R>>>> call(
                                            final D d) {
                                        return new Func1<E, Func1<F, Func1<G, Func1<H, R>>>>() {
                                            @Override
                                            public Func1<F, Func1<G, Func1<H, R>>> call(final E e) {
                                                return new Func1<F, Func1<G, Func1<H, R>>>() {
                                                    @Override
                                                    public Func1<G, Func1<H, R>> call(final F f) {
                                                        return new Func1<G, Func1<H, R>>() {
                                                            @Override
                                                            public Func1<H, R> call(final G g) {
                                                                return new Func1<H, R>() {
                                                                    @Override
                                                                    public R call(final H h) {
                                                                        return func.call(a, b, c, d,
                                                                                e, f, g, h);
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

    public static <A, B, C, D, E, F, G, H, I, R> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>>>>>> curry(
            final Func9<A, B, C, D, E, F, G, H, I, R> func) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>>>>> call(
                    final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>>>> call(
                            final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>>> call(
                                    final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>> call(
                                            final D d) {
                                        return new Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, R>>>>>() {
                                            @Override
                                            public Func1<F, Func1<G, Func1<H, Func1<I, R>>>> call(
                                                    final E e) {
                                                return new Func1<F, Func1<G, Func1<H, Func1<I, R>>>>() {
                                                    @Override
                                                    public Func1<G, Func1<H, Func1<I, R>>> call(
                                                            final F f) {
                                                        return new Func1<G, Func1<H, Func1<I, R>>>() {
                                                            @Override
                                                            public Func1<H, Func1<I, R>> call(
                                                                    final G g) {
                                                                return new Func1<H, Func1<I, R>>() {
                                                                    @Override
                                                                    public Func1<I, R> call(
                                                                            final H h) {
                                                                        return new Func1<I, R>() {
                                                                            @Override
                                                                            public R call(
                                                                                    final I i) {
                                                                                return func.call(a,
                                                                                        b, c, d, e,
                                                                                        f, g, h, i);
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
