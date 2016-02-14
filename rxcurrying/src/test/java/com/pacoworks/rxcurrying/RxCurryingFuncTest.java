
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

import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func5;

/**
 * Created by Paco on 14/02/2016. See LICENSE.md
 */
public class RxCurryingFuncTest {
    @Test
    public void curry() throws Exception {
        Func1<String, Func1<String, Func1<String, Func1<String, Func1<String, Func0<String>>>>>> secondVariable = RxCurryingFunc
                .curry(new Func5<String, String, String, String, String, String>() {
                    @Override
                    public String call(String first, String second, String third, String fourth,
                            String fifth) {
                        return first + second + third + fourth + fifth;
                    }
                });
        Func0<String> last = secondVariable.call("Hello ").call("This ").call("Is ")
                .call("Curried ").call("Func");
        Assert.assertEquals("Hello This Is Curried Func", last.call());
    }
}
