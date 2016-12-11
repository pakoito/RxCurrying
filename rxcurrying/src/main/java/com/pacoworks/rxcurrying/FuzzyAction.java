package com.pacoworks.rxcurrying;

import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Function;

class FuzzyAction<T extends Function> implements Func1 {

    private final ArgumentConsumer argumentConsumer;
    private final int targetLevel;
    private final FuzzyAction<T> original;
    private final Object argument;
    private final int level;

    FuzzyAction(int targetLevel, ArgumentConsumer argumentConsumer) {
        this.targetLevel = targetLevel;
        this.argumentConsumer = argumentConsumer;
        this.original = null;
        this.argument = null;
        this.level = 0;
    }

    private FuzzyAction(FuzzyAction<T> original, Object argument) {
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
        } else if(level == targetLevel - 2) {
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
            FuzzyAction<T> currentFunction = original;
            for (int i = targetLevel - 3; currentFunction.original != null; i--) {
                args[i] = currentFunction.argument;
                currentFunction = currentFunction.original;
            }
        }

    }

}
