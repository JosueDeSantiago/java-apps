package gto.talent.tech.cars;

import gto.talent.tech.annotations.Team;

import java.lang.reflect.Constructor;

public class F1WilliamsCar {
    private String color;

    @Team(name="Ferrari", id=1)
    public F1WilliamsCar() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String name = "no team assigned";
        try {
            Class<F1WilliamsCar> car = F1WilliamsCar.class;
            Constructor<F1WilliamsCar> williams = car.getDeclaredConstructor();
            if(williams.isAnnotationPresent(Team.class)){
                Team team = williams.getAnnotation(Team.class);
                name = team.name();
            }
        } catch (Exception e) {
            //TODO: manage exception properly
            System.out.println(e.getMessage());
        }

        return "F1WilliamsCar{" +
                "name='" + name + '\'' +
                "color='" + color + '\'' +
                '}';
    }
}
