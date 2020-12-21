package _onjava8._exceptions;

import _practice.Base;

class BaseException extends Exception {}
class DerivedException extends BaseException {}

public class PreciseRethrow {

    void catcher() throws DerivedException {
        try {
            throw new DerivedException();
        } catch (BaseException e) {
            throw e;
        }
    }

}
