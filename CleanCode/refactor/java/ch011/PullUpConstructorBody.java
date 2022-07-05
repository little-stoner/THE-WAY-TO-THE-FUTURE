package refactor.java.ch011;

public class PullUpConstructorBody {
    class Manager extends Employee {
        public Manager(String name, String id, int grade) {
            _name = name;
            _id = id;
            _grade = grade;
        }
    }

    public Manager (String name, String id, int grade) { 
        super (name, id);
        _grade = grade;
    }
}
