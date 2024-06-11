package gto.talent.tech.cards;

import gto.talent.tech.annotations.Debt;

@Debt(amount=37957.38, type="credit")
public class CreditCard {
    private String bank;

    public CreditCard(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        Double amount = getAmountFromAnnotation();
        String type = getTypeFromAnnotation();

        return "CreditCard{" +
                "amount='" + amount + '\'' +
                ", type='" + type + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }

    //complete these methods using reflection
    private Double getAmountFromAnnotation() { return 0.0;}

    private String getTypeFromAnnotation() { return "";}
}
