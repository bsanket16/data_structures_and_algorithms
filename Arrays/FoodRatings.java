package Arrays;

import java.util.*;

public class FoodRatings {

    // First map -> Food | Cuisine
    // Second map - > Cuisines -> Cuisines | [Foods]
    // Third map -> Rating -> Food | Rating

    Map<String, String> foodCuisines;
    Map<String, TreeSet<String>> cuisines;
    Map<String, Integer> ratings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        this.foodCuisines = new HashMap<>();
        this.cuisines = new HashMap<>();
        this.ratings = new HashMap<>();

        for (int i=0; i<foods.length; i++) {

            if (!this.cuisines.containsKey(cuisines[i])) {
                this.cuisines.put(cuisines[i], new TreeSet<String>((food1, food2)-> Objects.equals(this.ratings.get(food2), this.ratings.get(food1))
                        ? food1.compareTo(food2)
                        : Integer.compare(this.ratings.get(food2), this.ratings.get(food1))));
            }

            this.foodCuisines.put(foods[i], cuisines[i]);
            this.ratings.put(foods[i], ratings[i]);
            this.cuisines.get(cuisines[i]).add(foods[i]);
        }

    }

    public void changeRating(String food, int newRating) {

        String cuisine = this.foodCuisines.get(food);

        cuisines.get(cuisine).remove(food);
        ratings.put(food, newRating);
        cuisines.get(cuisine).add(food);
    }

    public String highestRated(String cuisine) {
        TreeSet<String> temp = this.cuisines.get(cuisine);
        return temp.first();
    }

    public static void main(String[] args) {

        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};

        FoodRatings obj = new FoodRatings(foods, cuisines, ratings);

        System.out.println(obj.highestRated("korean"));
        System.out.println(obj.highestRated("japanese"));
        obj.changeRating("sushi", 16);
        System.out.println(obj.highestRated("japanese"));
        obj.changeRating("ramen", 16);
        System.out.println(obj.highestRated("japanese"));
    }
}
