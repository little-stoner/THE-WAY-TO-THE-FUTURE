package refactor.java.ch011;

public class ExtractSubclass {
    class JobItem {
        public JobItem(int unitPrice, int quantity, boolean isLabor, Employee employee) {
            _unitPrice = unitPrice;
            _quantity = quantity;
            _isLabor = isLabor;
            _employee = employee;
        }

        public JobItem(int unitPrice, int quantity) {
            this(unitPrice, quantity, false, null);
        }

        protected JobItem(int unitPrice, int quantity, boolean isLabor) {
            _unitPrice = unitPrice;
            _quantity = quantity;
            _isLabor = isLabor;
        }

        public int getTotalPrice() {
            return getUnitPrice() * _quantity;
        }

        public int getUnitPrice() {
            return (_isLabor) ? _employee.getRate() : _unitPrice;
        }

        public int getUnitPrice() {
            return (isLabor()) ? _employee.getRate() : _unitPrice;
        }

        public int getUnitPrice() {
            return _unitPrice;
        }

        public int getQuantity() {
            return _quantity;
        }

        public Employee getEmployee() {
            return _employee;
        }

        private int _unitPrice;
        private int _quantity;
        protected Employee _employee;
        private boolean _isLabor;

        protected boolean isLabor() {
            return false;
        }

    }

    class Employee {
        public Employee(String name, String id) {
            _name = name;
            _id = id;
        }

        public int getRate() {
            return _rate;
        }

        public String getName() {
            return _name;
        }

        public String getId() {
            return _id;
        }

        private String _name;
        private String _id;
        private int _rate;
    }

    class LaborItem extends JobItem {
        public LaborItem(int unitPrice, int quantity, Employee employee) {
            super(unitPrice, quantity, true, employee);
        }

        public LaborItem(int quantity, Employee employee) {
            super(0, quantity, true, employee);
        }

        public LaborItem(int quantity, Employee employee) {
            super(0, quantity, true);
            _employee = employee;
        }

        public Employee getEmployee() {
            return _employee;
        }

        protected boolean isLabor() {
            return true;
        }

        public int getUnitPrice() {
            return _employee.getRate();
        }
    }
}
