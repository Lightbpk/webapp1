package app.model;

import app.entities.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model inctance = new Model();

    private List<Animal> model;

    public static Model getInstance(){
        return inctance;
    }
    private Model(){
        model = new ArrayList<>();
    }
    public void add(Animal animal){
        model.add(animal);
    }

    public List<String> list(){
        return model.stream()
                .map(Animal::getReqLine)
                .collect(Collectors.toList());
    }
}
