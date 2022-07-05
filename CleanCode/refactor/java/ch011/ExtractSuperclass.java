package refactor.java.ch011;

public class ExtractSuperclass {

    class Employee {
        public Employee(String name, String id, int annualCost) {
            _name = name;
            _id = id;
            _annualCost = annualCost;
        }

        public int getAnnualCost() {
            return _annualCost;
        }

        public String getId() {
            return _id;
        }

        public String getName() {
            return _name;
        }

        private String _name;
        private int _annualCost;
        private String _id;
    }

    public class Department {
        public Department(String name) {
            _name = name;
        }

        public int getTotalAnnualCost() {
            Enumeration e = getStaff();
            int result = 0;
            while (e.hasMoreElements()) {
                Employee each = (Employee) e.nextElement();
                result += each.getAnnualCost();
            }
            return result;
        }

        public int getHeadCount() {
            return _staff.size();
        }

        public Enumeration getStaff() {
            return _staff.elements();
        }

        public void addStaff(Employee arg) {
            _staff.addElement(arg);
        }

        public String getName() {
            return _name;
        }

        private String _name;
        private Vector _staff = new Vector();
    }

    abstract class Party {
        protected Party(String name) {
            _name = name;
        }

        private String _name;

        public String getName() {
            return _name;
        }
        abstract public int getAnnualCost()
    }

    class Employee extends Party {
    }

    class Department extends Party {

        public int getAnnualCost(){
            Enumeration e = getStaff(); int result = 0;
            while (e.hasMoreElements()) {
            Employee each = (Employee) e.nextElement();
            result += each.getAnnualCost(); }
            return result;
        }
    }
}
