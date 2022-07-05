package refactor.java.ch08;

public class ReplaceTypeCodeWithSubclasses {

    class Employee {
        private int _type;
        static final int ENGINEER = 0;
        static final int SALESMAN = 1;
        static final int MANAGER = 2;

        Employee(int type) {
            _type = type;
        }

        public int getType() {
            return _type;
        }

        public abstract int getType();

        Employee create(int type) {
            return new Employee(type);
        }

        static Employee create(int type) { 
            switch (type) {
                case ENGINEER:
                    return new Engineer();
                case SALESMAN:
                        return new Salesman();
                case MANAGER:
                        return new Manager();
                default: 
                    throw new IllegalArgumentException("Invalid type code");
        }
    }

        class Engineer extends Employee {
            @Override
            public int getType() {
                return ENGINEER;
            }
        }

}
