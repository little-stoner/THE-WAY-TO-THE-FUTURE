package _8.pattern;

public class Strategy {

    public interface ValidationStrategy {
        boolean execute(String s);
    }

    public class IsAllLowerCase implements ValidationStrategy {
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }

    public class IsNumeric implements ValidationStrategy {
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }

    public class Validator {
        private final ValidationStrategy strategy;

        public Validator(ValidationStrategy v) {
            this.strategy = v;
        }

        public boolean validate(String s) {
            return strategy.execute(s);
        }
    }

    public void m1() {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase ());
        boolean b2 = lowerCaseValidator.validate("bbbb");
    }

    public void m2() {
        Validator numericValidator =
                new Validator((String s) -> s.matches("[a-z]+"));
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator =
                new Validator((String s) -> s.matches("\\d+"));
        boolean b2 = lowerCaseValidator.validate("bbbb");
    }

    public static void main(String[] args) {
        System.out.println(1);
    }

}
