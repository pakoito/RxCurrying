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
