package Tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    public Map<String, List<String>> phonebook = new HashMap<>();
    public List<String> phones;

    public void add(String Surname, String Number) {
        if (phonebook.containsKey(Surname)) {
            phones = phonebook.get(Surname);
            phones.add(Number);
            phonebook.put(Surname, phones);
        } else {
            phones = new ArrayList<>();
            phones.add(Number);
            phonebook.put(Surname, phones);
        }
    }

    public void get(String Surname) {
        System.out.println(phonebook.get(Surname));
    }
}
