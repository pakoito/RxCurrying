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

import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Function;

class FuzzyAction<T extends Function> extends AbstractFun implements Func1 {

    FuzzyAction(int targetLevel, ArgumentConsumer argumentConsumer) {
        super(targetLevel, argumentConsumer);
    }

    private FuzzyAction(FuzzyAction<T> original, Object argument) {
        super(original, argument);
    }

    @Override
    public Object call(Object o) {
        if (reversePosition() == 0) {
            return finalCall(o);
        } else if(reversePosition() == 1) {
            return new AsAction(new FuzzyAction<>(this, o));
        } else {
            return new FuzzyAction<>(this, o);
        }
    }

    private class AsAction implements Action1 {

        private final FuzzyAction<?> action;

        private AsAction(FuzzyAction<?> action) {
            this.action = action;
        }

        @Override
        public void call(Object o) {
            action.call(o);
        }

    }

}
