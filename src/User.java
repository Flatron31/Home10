public class User {
    private String name;
    private String typeCard;

    // private Card card;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(Card card) {
        this.typeCard = card.getNameCard();
    }
}
