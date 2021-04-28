package prac_6.prototype;

public class Root {
    public static void main(String[] args) {
        Project project = new Project(14535555,"Mirea", "VIG");
        Project copy = project.copy();
        System.out.println(copy);
    }
}
