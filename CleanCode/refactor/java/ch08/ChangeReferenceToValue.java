package refactor.java.ch08;

public class ChangeReferenceToValue {
    class Currency {
        private String _code;

        public String getCode() {
            return _code;
        }

        public Currency(String code) {
            _code = code;
        }

        public boolean equals(Object arg) {
            if (!(arg instanceof Currency))
                return false;
            Currency other = (Currency) arg;
            return (_code.equals(other._code));
        }

        public int hashCode() {
            return _code.hashCode();
        }
    }
}
