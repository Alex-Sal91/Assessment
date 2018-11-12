import java.util.ArrayList;
import java.util.Arrays;
public class Family {

    ArrayList<Person> tree = new ArrayList();
    public static void main(String[] args) {
        // create and object of the Family class and call the runner method
        Family fam = new Family();
        fam.runner();
    }

    public void runner() {
        System.out.println(this.setParentOf("Frank", "Morgan"));
        System.out.println(this.setParentOf("Frank", "Dylan"));
        System.out.println(this.male("Dylan"));
        System.out.println(this.setParentOf("Joy", "Frank"));
        System.out.println(this.male("Frank"));
        System.out.println(this.male("Morgan"));
        System.out.println(this.setParentOf("July", "Morgan"));
        System.out.println(this.isMale("Joy") || this.isFemale("Joy"));
        System.out.println(Arrays.toString(this.getChildrenOf("Morgan")));
        System.out.println(this.setParentOf("Jennifer", "Morgan"));
        System.out.println(Arrays.toString(this.getChildrenOf("Morgan")));
        System.out.println(Arrays.toString(this.getChildrenOf("Dylan")));
        System.out.println(Arrays.toString(this.getParents("Frank")));
        System.out.println(Arrays.toString(this.getParents("July")));
        System.out.println(this.setParentOf("Morgan", "Frank"));
    }
    // Set person as male
    public boolean male(String name) {
        if (getPerson(name) == null) {
            Person newPerson = new Person();
            newPerson.setName(name);
            newPerson.setGender("male");
            tree.add(newPerson);
            return true;
        } else {
            Person person = getPerson(name);
            if (person.gender.isEmpty()) {
                person.setGender("male");
                return true;
            } else {
                System.out.println("Gender is already " + person.getGender());
                return false;
            }

        }
    }
    //Set person as female
    public boolean female(String name) {
        if (getPerson(name) == null) {
            Person newPerson = new Person();
            newPerson.setName(name);
            newPerson.setGender("female");
            tree.add(newPerson);
            return true;
        } else {
            Person person = getPerson(name);
            if (person.gender.isEmpty()) {
                person.setGender("female");
                return true;
            } else {
                System.out.println("Gender is already " + person.getGender());
                return false;
            }

        }
    }
    // check if male
    public boolean isMale(String name) {
        Person person = getPerson(name);
        if (person.getGender().equals("male")) {
            return true;
        }
        return false;
    }
    // check if female
    public boolean isFemale(String name) {
        Person person = getPerson(name);
        if (person.getGender() == "female") {
            return true;
        }
        return false;
    }

    public boolean setParentOf(String childName, String parentName) {
        Person person = getPerson(parentName);
        Person child = getPerson(childName);


        if (person == null) {
            person = new Person();
            person.setName(parentName);
            this.tree.add(person);
        }
        if (child == null) {
            child = new Person();
            child.setName(childName);
            this.tree.add(child);
        }

        if ((person.getGender().equals("male") && !child.getFather().isEmpty()) || (person.getGender().equals("female") && !child.getMother().isEmpty())) {
            System.out.println(childName + "  has a parent of that gender");
            return false;
        }

        if (child.parents[0]!=null && child.parents[1]!=null) {
            System.out.println(childName + " already have parents");
            return false;
        }

        if (((person.getGender() == "female" && (child.getMother().isEmpty()))) || (person.getGender().isEmpty() && child.getMother().isEmpty() && !child.getFather().isEmpty())) {
            child.setMother(parentName);
        }
        if ((person.getGender() == "male" && (child.getMother().isEmpty())) || (person.getGender().isEmpty() && child.getFather().isEmpty() && !child.getMother().isEmpty())) {
            child.setFather(parentName);
        }
        child.setParent(parentName);
        person.addChild(childName);
        return true;

    }
    //Gets parents of the child
    public String[] getParents(String name) {
        Person person = getPerson(name);
        return person.getParents();
    }
    //Gets children of a person
    public String[] getChildrenOf(String name) {
        Person person = getPerson(name);
        String[] children = person.getChildren().toArray(new String[person.getChildren().size()]);
        return children;
    }
    //Finds a specified member of the family
    private Person getPerson(String name) {
        // for all the people in the family tree
        for (Person person : this.tree) {
            // if said name is found return the person object
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }