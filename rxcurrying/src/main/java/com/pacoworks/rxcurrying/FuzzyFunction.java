package com.pacoworks.rxcurrying;

import rx.functions.Func1;
import rx.functions.Function;

class FuzzyFunction<T extends Function> extends AbstractFun implements Func1 {

    FuzzyFunction(int targetLevel, ArgumentConsumer argumentConsumer) {
        super(targetLevel, argumentConsumer);
    }

    private FuzzyFunction(FuzzyFunction<T> original, Object argument) {
        super(original, argument);
    }

    @Override
    public Object call(Object o) {
        if (reversePosition() == 0) {
            return finalCall(o);
        } else {
            return new FuzzyFunction<>(this, o);
        }
    }

}
