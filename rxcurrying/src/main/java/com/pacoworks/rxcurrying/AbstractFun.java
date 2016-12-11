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

abstract class AbstractFun {

    private final ArgumentConsumer argumentConsumer;
    private final int targetLevel;
    private final AbstractFun original;
    private final Object argument;
    private final int level;

    AbstractFun(int targetLevel, ArgumentConsumer argumentConsumer) {
        this.targetLevel = targetLevel;
        this.argumentConsumer = argumentConsumer;
        this.original = null;
        this.argument = null;
        this.level = 0;
    }

    AbstractFun(AbstractFun original, Object argument) {
        this.targetLevel = original.targetLevel;
        this.original = original;
        this.argument = argument;
        this.level = original.level + 1;
        this.argumentConsumer = original.argumentConsumer;
    }

    int reversePosition() {
        return (targetLevel - 1) - level;
    }

    Object finalCall(Object o) {
        return argumentConsumer.onArgumentsReady(collectArguments(o));
    }

    private Object[] collectArguments(Object lastArgument) {
        return new ArgumentCollector(lastArgument).args;
    }

    private class ArgumentCollector {
        Object[] args = new Object[targetLevel];

        private ArgumentCollector(Object lastArgument) {
            args[targetLevel - 1] = lastArgument;
            args[targetLevel - 2] = argument;
            if (original != null) {
                collectArguments();
            }
        }

        private void collectArguments() {
            AbstractFun currentFunction = original;
            for (int i = targetLevel - 3; currentFunction.original != null; i--) {
                args[i] = currentFunction.argument;
                currentFunction = currentFunction.original;
            }
        }

    }

}
