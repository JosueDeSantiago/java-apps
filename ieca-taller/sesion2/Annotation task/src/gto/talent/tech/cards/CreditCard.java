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

    // Método para obtener el valor de 'amount' desde la anotación 'Debt'
    private Double getAmountFromAnnotation() {
        try {
            // Obtener la clase de la instancia actual
            Class<?> clazz = this.getClass();
            // Verificar si la anotación 'Debt' está presente en la clase
            if (clazz.isAnnotationPresent(Debt.class)) {
                // Obtener la anotación 'Debt'
                Debt debt = clazz.getAnnotation(Debt.class);
                // Retornar el valor de 'amount' desde la anotación
                return debt.amount();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    // Método para obtener el valor de 'type' desde la anotación 'Debt'
    private String getTypeFromAnnotation() {
        try {
            // Obtener la clase de la instancia actual
            Class<?> clazz = this.getClass();
            // Verificar si la anotación 'Debt' está presente en la clase
            if (clazz.isAnnotationPresent(Debt.class)) {
                // Obtener la anotación 'Debt'
                Debt debt = clazz.getAnnotation(Debt.class);
                // Retornar el valor de 'type' desde la anotación
                return debt.type();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        // Crear una instancia de CreditCard y confirmar que se creó imprimiendo en consola
        CreditCard creditCard = new CreditCard("Bank of America");
        System.out.println(creditCard);
    }
}

