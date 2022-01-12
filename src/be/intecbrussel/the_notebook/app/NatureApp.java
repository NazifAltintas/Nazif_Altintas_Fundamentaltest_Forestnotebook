package be.intecbrussel.the_notebook.app;

import be.intecbrussel.the_notebook.entities.animal_entities.*;
import be.intecbrussel.the_notebook.entities.plant_entities.*;
import be.intecbrussel.the_notebook.service.ForestNoteBook;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class NatureApp {
    public static void main(String[] args) {

        ForestNoteBook noteBook = new ForestNoteBook();

        // plants

        Flower myFlower1 = new Flower("Amaryllis", 60);
        myFlower1.setSmell(Scent.MUSKY);

        Flower myFlower2 = new Flower("Gardenia", 50);
        myFlower2.setSmell(Scent.SWEET);

        Tree myTree1 = new Tree("Chestnut", 450);
        myTree1.setLeafType(LeafType.ROUND);

        Tree myTree2 = new Tree("Willow", 400);
        myTree2.setLeafType(LeafType.HAND);

        Bush myBush1 = new Bush("Japanese Laurel", 150);
        myBush1.setFruit("Red Drupe");
        myBush1.setLeafType(LeafType.NEEDLE);

        Bush myBush2 = new Bush("Andromeda", 100);
        myBush2.setFruit("Lilly");
        myBush2.setLeafType(LeafType.ROUND);

        Weed myWeed1 = new Weed("Ruderalis", 10);
        myWeed1.setArea(200);

        Weed myWeed2 = new Weed("Sativa", 5);
        myWeed2.setArea(800);

        //plant diets

        Set<Plant> plantDiet1 = new LinkedHashSet<>();
        plantDiet1.add(myFlower1);
        plantDiet1.add(myBush1);
        plantDiet1.add(myWeed2);

        Set<Plant> plantDiet2 = new LinkedHashSet<>();
        plantDiet2.add(myTree2);
        plantDiet2.add(myBush2);
        plantDiet2.add(myWeed2);
        plantDiet2.add(myTree1);

        //animals

        Carnivore eagle = new Carnivore("Golden Eagle", 6, 50, 100);
        eagle.setMaxFoodSize(5);

        Carnivore snake = new Carnivore("Black Rat Snake", 7, 5, 200);
        snake.setLength(225);  // to change the length of snake
        snake.setMaxFoodSize(3);

        Carnivore spider = new Carnivore("Wolf Spider");
        spider.setWeight(0.01);
        spider.setHeight(2);
        spider.setLength(8);
        spider.setMaxFoodSize(12);

        Herbivore deer = new Herbivore("Red Dier", 105, 140, 160);
        deer.setPlantDiet(plantDiet2);

        Herbivore caterpillar = new Herbivore("Tomato Horn Worm", 0.01, 0.05, 4);
        caterpillar.setPlantDiet(plantDiet1);
        caterpillar.addPlantToDiet(myWeed1); // to add new plant to diet
        caterpillar.addPlantToDiet(myWeed2); // to try adding same plant to diet (unsuccessful)
        System.out.println("The size of caterpillar plant diet:" + caterpillar.getPlantDiet().size());

        Herbivore rodent = new Herbivore("Capybara", 2.5, 20, 45);
        rodent.setPlantDiet(plantDiet1);

        Herbivore elephant = new Herbivore("Asian Elephant");
        elephant.setWeight(450);
        elephant.setHeight(250);
        elephant.setLength(220);
        elephant.setPlantDiet(plantDiet2);

        Omnivore monkey = new Omnivore("White-Face Saki", 120, 150, 215);
        monkey.setMaxFoodSize(1);
        monkey.setPlantDiet(plantDiet2);

        Omnivore parrot = new Omnivore("Toucan");
        parrot.setWeight(1.6);
        parrot.setLength(35);
        parrot.setHeight(75);
        parrot.setMaxFoodSize(4);
        parrot.setPlantDiet(plantDiet1);

        // notebook

        noteBook.addAnimal(eagle);
        noteBook.addAnimal(snake);
        noteBook.addAnimal(spider);
        noteBook.addAnimal(deer);
        noteBook.addAnimal(caterpillar);
        noteBook.addAnimal(rodent);
        noteBook.addAnimal(elephant);
        noteBook.addAnimal(monkey);
        noteBook.addAnimal(parrot);
        noteBook.addPlant(myBush1);
        noteBook.addPlant(myBush2);
        noteBook.addPlant(myFlower1);
        noteBook.addPlant(myFlower2);
        noteBook.addPlant(myTree1);
        noteBook.addPlant(myTree2);
        noteBook.addPlant(myWeed1);
        noteBook.addPlant(myWeed2);

        // part 2

        System.out.println("\nIn my notebook, animal count: " + ForestNoteBook.getAnimalCount() +
                "\nIn my notebook, plant count: " + ForestNoteBook.getPlantCount());

        System.out.println("\nIn my notebook, plants and animals: ");

        noteBook.printNotebook();

        System.out.println("\nIn my notebook, carnivores: \n");

        for (Carnivore w : noteBook.getCarnivores()) {
            System.out.println(noteBook.getCarnivores().indexOf(w) + 1 + ")" + w);
            ;
        }
        System.out.println("\nIn my notebook, herbivores: \n");

        for (Herbivore w : noteBook.getHerbivores()) {
            System.out.println(noteBook.getHerbivores().indexOf(w) + 1 + ")" + w);
            ;
        }
        System.out.println("\nIn my notebook, omnivores: \n");

        for (Omnivore w : noteBook.getOmnivores()) {
            System.out.println(noteBook.getOmnivores().indexOf(w) + 1 + ")" + w);
            ;
        }

        noteBook.sortPlantsByName();
        noteBook.sortAnimalsByName();

        System.out.println("\nMy notebook was sorted by name, plants and animals: ");

        noteBook.printNotebook();


        noteBook.sortAnimalsByHeight();
        noteBook.sortPlantsByHeight();

        System.out.println("\nMy notebook was sorted by height, plants and animals: ");

        noteBook.printNotebook();

        // to try adding exist element

        noteBook.addPlant(myBush1);
        noteBook.addAnimal(spider);

        //to print plant diet of any herbivore.

        System.out.println("\nThe plant diet of deer:\n");
        deer.printDiet();


    }

}
