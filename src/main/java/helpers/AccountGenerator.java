package helpers;
public class AccountGenerator {
    public static String staticUser() {
        String userName = "";
        String possible[] = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String possibleName[] = {"Jon","Stanis","Walter","Frodo","Luke","Darth","Vader","C3PO","R2D2","Chewbacca","ObiWan","Yoda","DarthVader","Robert","Harry","Smith","Neo","Gandalf","Merry","Aragorn"};

        userName = possibleName[(int) (Math.random() * possibleName.length)];
        for(int i=0;i<8;i++) {
            int index = (int)(Math.random()*possible.length);
            userName += possible[index];
        }
        return userName;
    }
    public static String staticPass() {
        String password = "";
        String possible[] = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for(int i=0;i<8;i++) {
            int index = (int)(Math.random()*possible.length);
            password += possible[index];
        }
        password = "password" + (int) (Math.random() * 100);
        return password;
    }
}
