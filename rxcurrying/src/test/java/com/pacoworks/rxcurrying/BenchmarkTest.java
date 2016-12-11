package com.pacoworks.rxcurrying;

import org.junit.Test;

import rx.functions.Func1;
import rx.functions.Func9;

import static org.junit.Assert.assertEquals;

public class BenchmarkTest {

    private Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>>>> nestedCurry(Func9<String, String, String, String, String, String, String, String, String, String> func) {
        return new Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>>>>() {
            @Override
            public Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>>> call(String a) {
                return new Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>>>() {
                    @Override
                    public Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>> call(String b) {
                        return new Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>>() {
                            @Override
                            public Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>> call(String c) {
                                return new Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>() {
                                    @Override
                                    public Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>> call(String d) {
                                        return new Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>() {
                                            @Override
                                            public Func1<String, Func1<String, Func1<String, Func1<String, String>>>> call(String e) {
                                                return new Func1<String, Func1<String, Func1<String, Func1<String, String>>>>() {
                                                    @Override
                                                    public Func1<String, Func1<String, Func1<String, String>>> call(String f) {
                                                        return new Func1<String, Func1<String, Func1<String, String>>>() {
                                                            @Override
                                                            public Func1<String, Func1<String, String>> call(String g) {
                                                                return new Func1<String, Func1<String, String>>() {
                                                                    @Override
                                                                    public Func1<String, String> call(String h) {
                                                                        return new Func1<String, String>() {
                                                                            @Override
                                                                            public String call(String i) {
                                                                                return func.call(a, b, c, d, e, f, g, h, i);
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


    
    @Test
    public void benchmark_func9Curry() throws Exception {
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            doReflexionFunc9Curry();
        }
        System.out.println("Reflexion curry time: " + (int) ((System.nanoTime() - start) / 1e6) + "ms");

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            doImplicitFunc9Curry();
        }
        System.out.println("Implicit curry time: " + (int) ((System.nanoTime() - start) / 1e6) + "ms");
    }

    private void doImplicitFunc9Curry() {
        Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>>>> curried = nestedCurry(new Func9<String, String, String, String, String, String, String, String, String, String>() {
                @Override
                public String call(String first, String second, String third, String fourth, String fifth, String sixth, String seventh, String eight, String ninth) {
                    return first + second + third + fourth + fifth + sixth + seventh + eight + ninth;
                }
            });

        String result = callAll(curried);
        assertEquals("OneTwoThreeFourFiveSixSevenEightNine", result);
    }

    private void doReflexionFunc9Curry() {
        Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>>>> curried = RxCurryingFunc
            .curry(new Func9<String, String, String, String, String, String, String, String, String, String>() {
                @Override
                public String call(String first, String second, String third, String fourth, String fifth, String sixth, String seventh, String eight, String ninth) {
                    return first + second + third + fourth + fifth + sixth + seventh + eight + ninth;
                }
            });

        String result = callAll(curried);
        assertEquals("OneTwoThreeFourFiveSixSevenEightNine", result);
    }

    private String callAll(Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>>>> curried) {
        return curried.call("One").call("Two").call("Three").call("Four").call("Five").call("Six").call("Seven").call("Eight").call("Nine");
    }

}
