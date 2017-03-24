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

import org.junit.Assert;
import org.junit.Test;

import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;

/**
 * Created by Paco on 14/02/2016. See LICENSE.md
 */
public class RxCurryingFuncTest {

    @Test
    public void curry_whenUsingFunc2() throws Exception {
        Func1<String, Func1<String, String>> curried = RxCurryingFunc
            .curry(new Func2<String, String, String>() {
                @Override
                public String call(String first, String second) {
                    return first + second;
                }
            });

        String result = curried.call("Hello ").call("World");
        Assert.assertEquals("Hello World", result);
    }

    @Test
    public void curry_whenUsingFunc3() throws Exception {
        Func1<String, Func1<String, Func1<String, String>>> curried = RxCurryingFunc
            .curry(new Func3<String, String, String, String>() {
                @Override
                public String call(String first, String second, String third) {
                    return first + second + third;
                }
            });

        String result = curried.call("One").call("Two").call("Three");
        Assert.assertEquals("OneTwoThree", result);
    }

    @Test
    public void curry_whenUsingFunc4() throws Exception {
        Func1<String, Func1<String, Func1<String, Func1<String, String>>>> curried = RxCurryingFunc
            .curry(new Func4<String, String, String, String, String>() {
                @Override
                public String call(String first, String second, String third, String fourth) {
                    return first + second + third + fourth;
                }
            });

        String result = curried.call("One").call("Two").call("Three").call("Four");
        Assert.assertEquals("OneTwoThreeFour", result);
    }

    @Test
    public void curry_whenUsingFunc5() throws Exception {
        Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>> curried = RxCurryingFunc
            .curry(new Func5<String, String, String, String, String, String>() {
                @Override
                public String call(String first, String second, String third, String fourth, String fifth) {
                    return first + second + third + fourth + fifth;
                }
            });

        String result = curried.call("One").call("Two").call("Three").call("Four").call("Five");
        Assert.assertEquals("OneTwoThreeFourFive", result);
    }

    @Test
    public void curry_whenUsingFunc6() throws Exception {
        Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>> curried = RxCurryingFunc
            .curry(new Func6<String, String, String, String, String, String, String>() {
                @Override
                public String call(String first, String second, String third, String fourth, String fifth, String sixth) {
                    return first + second + third + fourth + fifth + sixth;
                }
            });
        String result = curried.call("One").call("Two").call("Three").call("Four").call("Five").call("Six");
        Assert.assertEquals("OneTwoThreeFourFiveSix", result);
    }

    @Test
    public void curry_whenUsingFunc7() throws Exception {
        Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>> curried = RxCurryingFunc
            .curry(new Func7<String, String, String, String, String, String, String, String>() {
                @Override
                public String call(String first, String second, String third, String fourth, String fifth, String sixth, String seventh) {
                    return first + second + third + fourth + fifth + sixth + seventh;
                }
            });
        String result = curried.call("One").call("Two").call("Three").call("Four").call("Five").call("Six").call("Seven");
        Assert.assertEquals("OneTwoThreeFourFiveSixSeven", result);
    }

    @Test
    public void curry_whenUsingFunc8() throws Exception {
        Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>>> curried = RxCurryingFunc
            .curry(new Func8<String, String, String, String, String, String, String, String, String>() {
                @Override
                public String call(String first, String second, String third, String fourth, String fifth, String sixth, String seventh, String eight) {
                    return first + second + third + fourth + fifth + sixth + seventh + eight;
                }
            });
        String result = curried.call("One").call("Two").call("Three").call("Four").call("Five").call("Six").call("Seven").call("Eight");
        Assert.assertEquals("OneTwoThreeFourFiveSixSevenEight", result);
    }

    @Test
    public void curry_whenUsingFunc9() throws Exception {
        Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, String>>>>>>>>> curried = RxCurryingFunc
            .curry(new Func9<String, String, String, String, String, String, String, String, String, String>() {
                @Override
                public String call(String first, String second, String third, String fourth, String fifth, String sixth, String seventh, String eight, String ninth) {
                    return first + second + third + fourth + fifth + sixth + seventh + eight + ninth;
                }
            });
        String result = curried.call("One").call("Two").call("Three").call("Four").call("Five").call("Six").call("Seven").call("Eight").call("Nine");
        Assert.assertEquals("OneTwoThreeFourFiveSixSevenEightNine", result);
    }

}
