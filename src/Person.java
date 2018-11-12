import java.util.ArrayList;
public class Person {

        String name = "";
        String mom = "";
        String dad = "";
        String gender = "";
        String[] parents = new String[2];

        ArrayList<String> children = new ArrayList();
        public void setName(String newName) {
            this.name = newName;
        }

        public void setMother(String newMom) {
            this.mom = newMom;
        }

        public void setFather(String newDad) {
            this.dad = newDad;
        }

        public void setParent(String parentName) {
            if (this.parents[0]==null) {
                this.parents[0] = parentName;
            }
            else if (this.parents[1]==null) {
                this.parents[1] = parentName;
            }
            else {

            }
        }

        public void addChild(String child) {
            this.children.add(child);
        }

        public void setGender(String newGender) {
            this.gender = newGender;
        }

        public String getName() {
            return this.name;
        }

        public String getMother() {
            return this.mom;
        }

        public String getFather() {
            return this.dad;
        }

        public String getGender() {
            return this.gender;
        }
        public String[] getParents() {
            return this.parents;
        }
        public ArrayList<String> getChildren() {
            return this.children;
        }
}
