package refactor.java.ch06;

public class SubstituteAlgorithm {
    String foundPerson(String[] people) {
        for (String person : people) {
            if (person.equals("Don")) {
                return person;
            }
            if (person.equals("John")) {
                return person;
            }
            if (person.equals("Kent")) {
                return person;
            }
        }
        return "";
    }
    
    String foundPerson0(String[] people){
        List candidates = Arrays.asList(new String[] {"Don", "John", "Kent"});
        for (String person : people) {
            if (candidates.contains(person)) {
                return person;
            }
        }
    }
}
