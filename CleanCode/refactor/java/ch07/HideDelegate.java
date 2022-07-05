package refactor.java.ch07;

public class HideDelegate {
    class Person {
        Department _department;

        public Department getDepartment() {
            return _department;
        }

        public void setDepartment(Department arg) {
            _department = arg;
        }
    }

    class Department {
        private String _chargeCode;
        private Person _manager;

        public Department(Person manager) {
            _manager = manager;
        }

        public Person getManager() {
            return _manager;
        }
    }

}
