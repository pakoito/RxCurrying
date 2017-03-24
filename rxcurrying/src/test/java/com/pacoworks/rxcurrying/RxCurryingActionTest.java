
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

import org.junit.Test;

import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Action3;
import rx.functions.Action4;
import rx.functions.Action5;
import rx.functions.Action6;
import rx.functions.Action7;
import rx.functions.Action8;
import rx.functions.Action9;
import rx.functions.Func1;

import static org.junit.Assert.assertSame;

/**
 * Created by Paco on 14/02/2016. See LICENSE.md
 */
public class RxCurryingActionTest {

    private Integer sum;

    @Test
    public void curry_withAction2() throws Exception {
        Func1<Integer, Action1<Integer>> variable = RxCurryingAction
            .curry(new Action2<Integer, Integer>() {
                @Override
                public void call(Integer first, Integer second) {
                    sum = first + second;
                }
            });
        variable.call(1).call(1);
        assertSame(2, sum);
    }

    @Test
    public void curry_withAction3() throws Exception {
        Func1<Integer, Func1<Integer, Action1<Integer>>> variable = RxCurryingAction
            .curry(new Action3<Integer, Integer, Integer>() {
                @Override
                public void call(Integer first, Integer second, Integer third) {
                    sum = first + second + third;
                }
            });
        variable.call(1).call(1).call(2);
        assertSame(4, sum);
    }

    @Test
    public void curry_withAction4() throws Exception {
        Func1<Integer, Func1<Integer, Func1<Integer, Action1<Integer>>>> variable = RxCurryingAction
            .curry(new Action4<Integer, Integer, Integer, Integer>() {
                @Override
                public void call(Integer first, Integer second, Integer third, Integer fourth) {
                    sum = first + second + third +fourth;
                }
            });
        variable.call(1).call(1).call(2).call(3);
        assertSame(7, sum);
    }

    @Test
    public void curry_withAction5() throws Exception {
        Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Action1<Integer>>>>> variable = RxCurryingAction
            .curry(new Action5<Integer, Integer, Integer, Integer, Integer>() {
                @Override
                public void call(Integer first, Integer second, Integer third, Integer fourth, Integer fifth) {
                    sum = first + second + third +fourth + fifth;
                }
            });
        variable.call(1).call(1).call(2).call(3).call(5);
        assertSame(12, sum);
    }

    @Test
    public void curry_withAction6() throws Exception {
        Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Action1<Integer>>>>>> variable = RxCurryingAction
            .curry(new Action6<Integer, Integer, Integer, Integer, Integer, Integer>() {
                @Override
                public void call(Integer first, Integer second, Integer third, Integer fourth, Integer fifth, Integer sixth) {
                    sum = first + second + third +fourth + fifth + sixth;
                }
            });
        variable.call(1).call(1).call(2).call(3).call(5).call(8);
        assertSame(20, sum);
    }

    @Test
    public void curry_withAction7() throws Exception {
        Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Action1<Integer>>>>>>> variable = RxCurryingAction
            .curry(new Action7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>() {
                @Override
                public void call(Integer first, Integer second, Integer third, Integer fourth, Integer fifth, Integer sixth, Integer seventh) {
                    sum = first + second + third +fourth + fifth + sixth + seventh;
                }
            });
        variable.call(1).call(1).call(2).call(3).call(5).call(8).call(13);
        assertSame(33, sum);
    }

    @Test
    public void curry_withAction8() throws Exception {
        Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Action1<Integer>>>>>>>> variable = RxCurryingAction
            .curry(new Action8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer>() {
                @Override
                public void call(Integer first, Integer second, Integer third, Integer fourth, Integer fifth, Integer sixth, Integer seventh, Integer eighth) {
                    sum = first + second + third +fourth + fifth + sixth + seventh + eighth;
                }
            });
        variable.call(1).call(1).call(2).call(3).call(5).call(8).call(13).call(21);
        assertSame(54, sum);
    }

    @Test
    public void curry_withAction9() throws Exception {
        Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Func1<Integer, Action1<Integer>>>>>>>>> variable = RxCurryingAction
            .curry(new Action9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer>() {
                @Override
                public void call(Integer first, Integer second, Integer third, Integer fourth, Integer fifth, Integer sixth, Integer seventh, Integer eighth, Integer nine) {
                    sum = first + second + third +fourth + fifth + sixth + seventh + eighth + nine;
                }
            });
        variable.call(1).call(1).call(2).call(3).call(5).call(8).call(13).call(21).call(34);
        assertSame(88, sum);
    }

}
