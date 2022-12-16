public class a2 {
    public class Main {
        public static void main(String[] args) {
            final var studyOffice = StudyOffice.getInstance();

            final var persons = List.of(new Person("Alex"), new Person("Chris"),
                    new Person("Mike"));

            studyOffice.enroll(persons).forEach(System.out::println);
        }
    }

    class StudyOffice {
        private static StudyOffice instance;

        public List<Student> enroll(List<Person> persons) {
            var students = new ArrayList<Student>();

            for (final var person : persons)
                if (satisfiesRequirements(person))
                    students.add(new Student((int) (Math.random() * 10000), person));

            return students;
        }

        private boolean satisfiesRequirements(Person p) { return … }

        public static StudyOffice getInstance() {
            if (instance == null)
                instance = new StudyOffice();

            return instance;
        }
    }

    record Person(String name) {
    }

    record Student(int matrikelnummer, Person person) {
    }
}
