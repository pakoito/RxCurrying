package com.pacoworks.rxcurrying;

import rx.functions.Func1;
import rx.functions.Function;

class FuzzyFunction<T extends Function> implements Func1 {

    private final ArgumentConsumer argumentConsumer;
    private final int targetLevel;
    private final FuzzyFunction<T> original;
    private final Object argument;
    private final int level;

    FuzzyFunction(int targetLevel, ArgumentConsumer argumentConsumer) {
        this.targetLevel = targetLevel;
        this.argumentConsumer = argumentConsumer;
        this.original = null;
        this.argument = null;
        this.level = 0;
    }

    private FuzzyFunction(FuzzyFunction<T> original, Object argument) {
        this.targetLevel = original.targetLevel;
        this.original = original;
        this.argument = argument;
        this.level = original.level + 1;
        this.argumentConsumer = original.argumentConsumer;
    }

    @Override
    public Object call(Object o) {
        if (level == targetLevel - 1) {
            return argumentConsumer.onArgumentsReady(new ArgumentCollector(o).args);
        } else {
            return new FuzzyFunction<>(this, o);
        }
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
            FuzzyFunction<T> currentFunction = original;
            for (int i = targetLevel - 3; currentFunction.original != null; i--) {
                args[i] = currentFunction.argument;
                currentFunction = currentFunction.original;
            }
        }

    }

    interface ArgumentConsumer {
        Object onArgumentsReady(Object[] arguments);
    }

}
