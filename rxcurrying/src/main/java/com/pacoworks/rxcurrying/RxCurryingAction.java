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

    @SuppressWarnings("unchecked")
    private static <T> T proxyFunction(Action action, int times) {
        return CompositeFunctionBuilder.<T>compose(action).into(times, Func1.class, Action1.class);
    }

    public static <A, B> Func1<A, Action1<B>> curry(final Action2<A, B> action) {
        return proxyFunction(action, 1);
    }

    public static <A, B, C> Func1<A, Func1<B, Action1<C>>> curry(final Action3<A, B, C> action) {
        return proxyFunction(action, 2);
    }

    public static <A, B, C, D> Func1<A, Func1<B, Func1<C, Action1<D>>>> curry(
            final Action4<A, B, C, D> action) {
        return new Func1<A, Func1<B, Func1<C, Action1<D>>>>() {
            @Override
            public Func1<B, Func1<C, Action1<D>>> call(final A a) {
                return new Func1<B, Func1<C, Action1<D>>>() {
                    @Override
                    public Func1<C, Action1<D>> call(final B b) {
                        return new Func1<C, Action1<D>>() {
                            @Override
                            public Action1<D> call(final C c) {
                                return new Action1<D>() {
                                    @Override
                                    public void call(final D d) {
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

    public static <A, B, C, D, E> Func1<A, Func1<B, Func1<C, Func1<D, Action1<E>>>>> curry(
            final Action5<A, B, C, D, E> action) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Action1<E>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Action1<E>>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Action1<E>>>>() {
                    @Override
                    public Func1<C, Func1<D, Action1<E>>> call(final B b) {
                        return new Func1<C, Func1<D, Action1<E>>>() {
                            @Override
                            public Func1<D, Action1<E>> call(final C c) {
                                return new Func1<D, Action1<E>>() {
                                    @Override
                                    public Action1<E> call(final D d) {
                                        return new Action1<E>() {
                                            @Override
                                            public void call(final E e) {
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

    public static <A, B, C, D, E, F> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Action1<F>>>>>> curry(
            final Action6<A, B, C, D, E, F> action) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Action1<F>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Action1<F>>>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Action1<F>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Action1<F>>>> call(final B b) {
                        return new Func1<C, Func1<D, Func1<E, Action1<F>>>>() {
                            @Override
                            public Func1<D, Func1<E, Action1<F>>> call(final C c) {
                                return new Func1<D, Func1<E, Action1<F>>>() {
                                    @Override
                                    public Func1<E, Action1<F>> call(final D d) {
                                        return new Func1<E, Action1<F>>() {
                                            @Override
                                            public Action1<F> call(final E e) {
                                                return new Action1<F>() {
                                                    @Override
                                                    public void call(final F f) {
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

    public static <A, B, C, D, E, F, G> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Action1<G>>>>>>> curry(
            final Action7<A, B, C, D, E, F, G> action) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Action1<G>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Action1<G>>>>>> call(final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Action1<G>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Action1<G>>>>> call(final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Action1<G>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Action1<G>>>> call(final C c) {
                                return new Func1<D, Func1<E, Func1<F, Action1<G>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Action1<G>>> call(final D d) {
                                        return new Func1<E, Func1<F, Action1<G>>>() {
                                            @Override
                                            public Func1<F, Action1<G>> call(final E e) {
                                                return new Func1<F, Action1<G>>() {
                                                    @Override
                                                    public Action1<G> call(final F f) {
                                                        return new Action1<G>() {
                                                            @Override
                                                            public void call(final G g) {
                                                                action.call(a, b, c, d, e, f, g);
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

    public static <A, B, C, D, E, F, G, H> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action1<H>>>>>>>> curry(
            final Action8<A, B, C, D, E, F, G, H> action) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action1<H>>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action1<H>>>>>>> call(
                    final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action1<H>>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action1<H>>>>>> call(
                            final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Action1<H>>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func1<G, Action1<H>>>>> call(
                                    final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func1<G, Action1<H>>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func1<G, Action1<H>>>> call(
                                            final D d) {
                                        return new Func1<E, Func1<F, Func1<G, Action1<H>>>>() {
                                            @Override
                                            public Func1<F, Func1<G, Action1<H>>> call(final E e) {
                                                return new Func1<F, Func1<G, Action1<H>>>() {
                                                    @Override
                                                    public Func1<G, Action1<H>> call(final F f) {
                                                        return new Func1<G, Action1<H>>() {
                                                            @Override
                                                            public Action1<H> call(final G g) {
                                                                return new Action1<H>() {
                                                                    @Override
                                                                    public void call(final H h) {
                                                                        action.call(a, b, c, d, e,
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

    public static <A, B, C, D, E, F, G, H, I> Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action1<I>>>>>>>>> curry(
            final Action9<A, B, C, D, E, F, G, H, I> action) {
        return new Func1<A, Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action1<I>>>>>>>>>() {
            @Override
            public Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action1<I>>>>>>>> call(
                    final A a) {
                return new Func1<B, Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action1<I>>>>>>>>() {
                    @Override
                    public Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action1<I>>>>>>> call(
                            final B b) {
                        return new Func1<C, Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action1<I>>>>>>>() {
                            @Override
                            public Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action1<I>>>>>> call(
                                    final C c) {
                                return new Func1<D, Func1<E, Func1<F, Func1<G, Func1<H, Action1<I>>>>>>() {
                                    @Override
                                    public Func1<E, Func1<F, Func1<G, Func1<H, Action1<I>>>>> call(
                                            final D d) {
                                        return new Func1<E, Func1<F, Func1<G, Func1<H, Action1<I>>>>>() {
                                            @Override
                                            public Func1<F, Func1<G, Func1<H, Action1<I>>>> call(
                                                    final E e) {
                                                return new Func1<F, Func1<G, Func1<H, Action1<I>>>>() {
                                                    @Override
                                                    public Func1<G, Func1<H, Action1<I>>> call(
                                                            final F f) {
                                                        return new Func1<G, Func1<H, Action1<I>>>() {
                                                            @Override
                                                            public Func1<H, Action1<I>> call(
                                                                    final G g) {
                                                                return new Func1<H, Action1<I>>() {
                                                                    @Override
                                                                    public Action1<I> call(
                                                                            final H h) {
                                                                        return new Action1<I>() {
                                                                            @Override
                                                                            public void call(
                                                                                    final I i) {
                                                                                action.call(a, b, c,
                                                                                        d, e, f, g,
                                                                                        h, i);
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
