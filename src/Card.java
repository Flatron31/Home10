public class Card {
    private String nameCard;
    private int numberCard;
    private String userName;
    private int userAllMoney;

    public Card(String nameCard, int nomberCard, int userAllMoney) {
        this.nameCard = nameCard;
        this.numberCard = nomberCard;
        this.userAllMoney = userAllMoney;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(User user) {
        this.userName = user.getName();
    }

    public int getUserAllMoney() {
        return userAllMoney;
    }

    public void setUserAllMoney(int userAllMoney) {
        this.userAllMoney = userAllMoney;
    }
}
