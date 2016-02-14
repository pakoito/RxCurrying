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
 * Helper class to curry ActionN objects
 *
 * @author pakoito
 */
public class RxCurryingAction {
    private RxCurryingAction() {
    }

    public static <A> Func1<A, Action0> curry(final Action1<A> action) {
        return new Func1<A, Action0>() {
            @Override
            public Action0 call(final A a) {
                return new Action0() {
                    @Override
                    public void call() {
                        action.call(a);
                    }
                };
            }
        };
    }

    public static <A, B> Func1<A, Func1<B, Action0>> curry(final Action2<A, B> action) {
        return new Func1<A, Func1<B, Action0>>() {
            @Override
            public Func1<B, Action0> call(final A a) {
                return new Func1<B, Action0>() {
                    @Override
                    public Action0 call(final B b) {
                        return new Action0() {
                            @Override
                            public void call() {
                                action.call(a, b);
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C> Func1<A, Func1<B, Func1<C, Action0>>> curry(
            final Action3<A, B, C> action) {
        return new Func1<A, Func1<B, Func1<C, Action0>>>() {
            @Override
            public Func1<B, Func1<C, Action0>> call(final A a) {
                return new Func1<B, Func1<C, Action0>>() {
                    @Override
                    public Func1<C, Action0> call(final B b) {
                        return new Func1<C, Action0>() {
                            @Override
                            public Action0 call(final C c) {
                                return new Action0() {
                                    @Override
                                    public void call() {
                                        action.call(a, b, c);
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B, C, D> Func1<A, Func1<B, Func1<C, Func1<D, Action0>>>> curry(
            final Action4<A, B, C, D> action) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Action0>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Action0>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Action0>>>() {
                    @Override
                    public Func1<C, Func1<D, Action0>> call(final B b) {
                        return new Func1<C, Func1<D, Action0>>() {
                            @Override
                            public Func1<D, Action0> call(final C c) {
                                return new Func1<D, Action0>() {
                                    @Override
                                    public Action0 call(final D d) {
                                        return new Action0() {
                                            @Override
                                            public void call() {
                                                action.call(a, b, c, d);
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

    public static <A, B, C, D, E> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Action0>>>>> curry(
            final Action5<A, B, C, D, E> action) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Action0>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Action0>>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Action0>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Action0>>> call(final B b) {
                        return new Func1<C, Func1<D, Func1<E, Action0>>>() {
                            @Override
                            public Func1<D, Func1<E, Action0>> call(final C c) {
                                return new Func1<D, Func1<E, Action0>>() {
                                    @Override
                                    public Func1<E, Action0> call(final D d) {
                                        return new Func1<E, Action0>() {
                                            @Override
                                            public Action0 call(final E e) {
                                                return new Action0() {
                                                    @Override
                                                    public void call() {
                                                        action.call(a, b, c, d, e);
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

    public static <A, B, C, D, E, F> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Action0>>>>>> curry(
            final Action6<A, B, C, D, E, F> action) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Action0>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Action0>>>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Action0>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Action0>>>> call(final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Action0>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Action0>>> call(final C c) {
                                return new Func1<D, Func1<E, Func1<F, Action0>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Action0>> call(final D d) {
                                        return new Func1<E, Func1<F, Action0>>() {
                                            @Override
                                            public Func1<F, Action0> call(final E e) {
                                                return new Func1<F, Action0>() {
                                                    @Override
                                                    public Action0 call(final F f) {
                                                        return new Action0() {
                                                            @Override
                                                            public void call() {
                                                                action.call(a, b, c, d, e, f);
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

    public static <A, B, C, D, E, F, G> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action0>>>>>>> curry(
            final Action7<A, B, C, D, E, F, G> action) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action0>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action0>>>>>> call(
                    final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action0>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action0>>>>> call(
                            final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action0>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func1<G, Action0>>>> call(final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func1<G, Action0>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func1<G, Action0>>> call(final D d) {
                                        return new Func1<E, Func1<F, Func1<G, Action0>>>() {
                                            @Override
                                            public Func1<F, Func1<G, Action0>> call(final E e) {
                                                return new Func1<F, Func1<G, Action0>>() {
                                                    @Override
                                                    public Func1<G, Action0> call(final F f) {
                                                        return new Func1<G, Action0>() {
                                                            @Override
                                                            public Action0 call(final G g) {
                                                                return new Action0() {
                                                                    @Override
                                                                    public void call() {
                                                                        action.call(a, b, c, d, e,
                                                                                f, g);
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

    public static <A, B, C, D, E, F, G, H> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action0>>>>>>>> curry(
            final Action8<A, B, C, D, E, F, G, H> action) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action0>>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action0>>>>>>> call(
                    final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action0>>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action0>>>>>> call(
                            final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action0>>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action0>>>>> call(
                                    final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action0>>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func1<G, Func1<H, Action0>>>> call(
                                            final D d) {
                                        return new Func1<E, Func1<F, Func1<G, Func1<H, Action0>>>>() {
                                            @Override
                                            public Func1<F, Func1<G, Func1<H, Action0>>> call(
                                                    final E e) {
                                                return new Func1<F, Func1<G, Func1<H, Action0>>>() {
                                                    @Override
                                                    public Func1<G, Func1<H, Action0>> call(
                                                            final F f) {
                                                        return new Func1<G, Func1<H, Action0>>() {
                                                            @Override
                                                            public Func1<H, Action0> call(
                                                                    final G g) {
                                                                return new Func1<H, Action0>() {
                                                                    @Override
                                                                    public Action0 call(final H h) {
                                                                        return new Action0() {
                                                                            @Override
                                                                            public void call() {
                                                                                action.call(a, b, c,
                                                                                        d, e, f, g,
                                                                                        h);
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

    public static <A, B, C, D, E, F, G, H, I> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>>>>>>> curry(
            final Action9<A, B, C, D, E, F, G, H, I> action) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>>>>>> call(
                    final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>>>>> call(
                            final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>>>> call(
                                    final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>>> call(
                                            final D d) {
                                        return new Func1<E, Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>>>() {
                                            @Override
                                            public Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>> call(
                                                    final E e) {
                                                return new Func1<F, Func1<G, Func1<H, Func1<I, Action0>>>>() {
                                                    @Override
                                                    public Func1<G, Func1<H, Func1<I, Action0>>> call(
                                                            final F f) {
                                                        return new Func1<G, Func1<H, Func1<I, Action0>>>() {
                                                            @Override
                                                            public Func1<H, Func1<I, Action0>> call(
                                                                    final G g) {
                                                                return new Func1<H, Func1<I, Action0>>() {
                                                                    @Override
                                                                    public Func1<I, Action0> call(
                                                                            final H h) {
                                                                        return new Func1<I, Action0>() {
                                                                            @Override
                                                                            public Action0 call(
                                                                                    final I i) {
                                                                                return new Action0() {
                                                                                    @Override
                                                                                    public void call() {
                                                                                        action.call(
                                                                                                a,
                                                                                                b,
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
