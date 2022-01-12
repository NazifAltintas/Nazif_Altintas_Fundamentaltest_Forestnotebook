package be.intecbrussel.the_notebook.service;

import be.intecbrussel.the_notebook.entities.animal_entities.*;
import be.intecbrussel.the_notebook.entities.plant_entities.Plant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ForestNoteBook {
    private List<Carnivore> carnivores;
    private List<Herbivore> herbivores;
    private List<Omnivore> omnivores;
    private static int plantCount;
    private static int animalCount;
    private List<Animal> animals;
    private List<Plant> plants;

    {
        carnivores = new LinkedList<>();
        herbivores = new LinkedList<>();
        omnivores = new LinkedList<>();
        plants = new ArrayList<>();
        animals = new ArrayList<>();
    }

    public List<Carnivore> getCarnivores() {
        return carnivores;
    }

    public void setCarnivores(List<Carnivore> carnivores) {
        this.carnivores = carnivores;
    }

    public List<Herbivore> getHerbivores() {
        return herbivores;
    }

    public void setHerbivores(List<Herbivore> herbivores) {
        this.herbivores = herbivores;
    }

    public List<Omnivore> getOmnivores() {
        return omnivores;
    }

    public void setOmnivores(List<Omnivore> omnivores) {
        this.omnivores = omnivores;
    }

    public static int getPlantCount() {
        return plantCount;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void addAnimal(Animal animal) {

        if (!animals.contains(animal)) {
            animals.add(animal);
            animalCount++;
            if (animal.getClass() == Carnivore.class) {
                carnivores.add((Carnivore) animal);
            } else if (animal.getClass() == Herbivore.class) {
                herbivores.add((Herbivore) animal);
            } else {
                omnivores.add((Omnivore) animal);
            }
        } else {
            System.out.printf("\n[\"%s\" height:%.2f length:%.2f weight:%.2f] is already exist in animal notebook.\n",
                    animal.getName(), animal.getHeight(), animal.getLength(), animal.getWeight());
        }

    }

    public void addPlant(Plant plant) {

        if (!plants.contains(plant)) {
            plants.add(plant);
            plantCount++;
        } else {
            System.out.printf("\n[\"%s\" height:%.2f] is already exist in plant notebook.\n",
                    plant.getName(), plant.getHeight());
        }

    }

    public void printNotebook() {
        System.out.println("\nPlants: \n");
        plants.forEach(System.out::println);

        System.out.println("\nAnimals: \n");
        animals.forEach(System.out::println);

    }

    public void sortAnimalsByName() {
        animals = animals.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .collect(Collectors.toList());

    }

    public void sortPlantsByName() {
        plants = plants.stream()
                .sorted(Comparator.comparing(Plant::getName))
                .collect(Collectors.toList());
    }

    public void sortAnimalsByHeight() {
        animals = animals.stream()
                .sorted(Comparator.comparing(Animal::getHeight))
                .collect(Collectors.toList());

    }

    public void sortPlantsByHeight() {
        plants = plants.stream()
                .sorted(Comparator.comparing(Plant::getHeight))
                .collect(Collectors.toList());
    }
}
