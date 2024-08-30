package emaliapp;

public class EmailApp {
    public static void main(String[] args) {
        Email eml1 = new Email("Gagana","Hansika");
        eml1.setPassword("Gagana@123");
        String newP = eml1.getPassword();
        System.out.println("Your new password is " + newP + "\n");
        System.out.println(eml1.showInfo());
    }
}
