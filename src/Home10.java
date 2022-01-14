import java.io.IOException;

public class Home10 {




    public static void main(String[] args) throws IOException {
        ATM atm = new ATM(5000, true, new String[]{"Belcard", "Visa", "Maestro"});
        User user = new User("Vova");
        Card maestro = new Card("Maestro", 564334, 2400);
        Card mtb = new Card("MTB", 335454, 6232);
        maestro.setUserName(user);
        user.setTypeCard(maestro);
        System.out.println(maestro.getUserName());
        System.out.println(user.getTypeCard());
        
        atm.startingWorkAtm(maestro);
        atm.startingWorkAtm(mtb);



















    }
}
