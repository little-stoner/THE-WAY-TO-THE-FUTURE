package _typeinfo;

class EmptyTitleException extends RuntimeException {}

public class Position {

    private String title;
    private Person person;
    Position(String jobTitle, Person employee) {
        setPerson(employee);
        setTitle(jobTitle);
    }
    Position(String jobTitle) {
        this(jobTitle, null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", person=" + person +
                '}';
    }
}
