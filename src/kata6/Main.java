package kata6;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        PersonLoader loader = createPersonLoader();
        HistogramBuilder<Person> builder = createBuilder(loader.load());
        HistogramViewer<String> viewer = createHistogramViewer(builder.build(createAttibuteExtractor()));
        viewer.show();
    }

    private static PersonLoader createPersonLoader() {
        return new PersonLoader() {

            @Override
            public Person[] load() {
                ArrayList<Person> list = new ArrayList<>();
                list.add(new Person("Luis", new Email("luis@gmail.com"), Sex.MALE));
                list.add(new Person("Alba", new Email("alba@yahoo.fr"), Sex.FEMALE));
                list.add(new Person("Tony", new Email("tony@gmail.com"), Sex.MALE));
                list.add(new Person("Jackie", new Email("jackie@hotmail.com"), Sex.FEMALE));
                list.add(new Person("John", new Email("jfk@gmail.com"), Sex.MALE));
                return list.toArray(new Person[0]);
            }
        };
    }

    private static HistogramBuilder<Person> createBuilder(Person[] collection) {
        return new HistogramBuilder<>(collection);
    }

    private static ChartHistogramViewer<String> createHistogramViewer(Histogram<String> histogram) {
        return new ChartHistogramViewer<>(histogram);
    }

    private static AttributeExtractor<Person,String> createAttibuteExtractor() {
            return new AttributeExtractor<Person,String>() {

                @Override
                public String extract(Person person) {
                    return person.getEmail().getDomain();
                }
            };
    }
}
