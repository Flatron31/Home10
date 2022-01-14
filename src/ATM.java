import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
    private int atmMoney;
    private boolean isWork;
    private String[] typeCard;
    private boolean checkTypeCard;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String numberConsole;
    private int moneyCard;

    public ATM(int allMoney, boolean isWork, String[] typeCard) {
        this.atmMoney = allMoney;
        this.isWork = isWork;
        this.typeCard = typeCard;
    }

    public int getAtmMoney() {
        return atmMoney;
    }

    public void setAtmMoney(int atmMoney) {
        this.atmMoney = atmMoney;
    }

    public boolean isWork() {
        return isWork;
    }

    public void setWork(boolean work) {
        this.isWork = work;
    }

    public String[] getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(String[] typeCard) {
        this.typeCard = typeCard;
    }

    public void startingWorkAtm(Card card) {
        if (isWork) {
            checkTypeCard(card);
            if (checkTypeCard) {
                menuAtm(card);
            } else {
                System.out.println("Банкомат не использует эту карту");
            }
        } else {
            System.out.println("Банкомат не работает. Приносим извинения");
        }
    }

    private void menuAtm(Card card) {
        while (true) {
            System.out.println("Выберите операцию нажав на клавишу\n" +
                    "1 - снять деньги\n" +
                    "2 - посмотреть оставшиеся средства\n" +
                    "3 - конец работы");
            String numberMenu = numberConsole();
            if (numberMenu.equals("1")) {
                userGetMoney(card);
            } else if (numberMenu.equals("2")) {
                lookMoneyCard(card);
            } else if (numberMenu.equals("3")) {
                endWorkBankomat();
            } else {
                System.out.println("Повторите попытку. Введите нужную операцию");
            }
        }
    }

    private void endWorkBankomat() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private boolean checkTypeCard(Card card) {
        for (int i = 0; i < typeCard.length; i++) {
            if (typeCard[i].equals(card.getNameCard())) {
                checkTypeCard = true;
                break;
            } else {
                checkTypeCard = false;
            }
        }
        return checkTypeCard;
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private String numberConsole() {
        try {
            numberConsole = reader.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberConsole;
    }

    private int userGetMoney(Card card) {
        System.out.println("\nВведите сумму денег которую хотите снять");
        String userGetMoneyString = numberConsole();
        while (!isNumber(userGetMoneyString)) {
            System.out.println("\nВведите сумму денег которую хотите снять");
            userGetMoneyString = numberConsole();
        }
        int userGetMoney = Integer.parseInt(userGetMoneyString);
        if (userGetMoney < atmMoney) {
            moneyCard = card.getUserAllMoney();
            if (userGetMoney < moneyCard) {
                moneyCard -= userGetMoney;
                atmMoney -= userGetMoney;
                card.setUserAllMoney(moneyCard);
            } else if (card.getUserAllMoney() < userGetMoney) {
                System.out.println("На карточке недостаточно средств");
            }
        } else {
            try {
                throw new WrongCardTypeException();
            } catch (WrongCardTypeException e) {
                System.out.println("В банкомате недостаточно средств");
            }
        }
        return atmMoney;
    }

    private void lookMoneyCard(Card card) {
        System.out.println();
        System.out.println(card.getUserAllMoney());
    }

}