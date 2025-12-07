public class MealPlanDemo {

    interface MealPlan {
        String getPlanDetails();
    }

    static class VegetarianMeal implements MealPlan {
        @Override
        public String getPlanDetails() {
            return "Vegetarian Meal: Includes vegetables, fruits, grains, and dairy.";
        }
    }

    static class VeganMeal implements MealPlan {
        @Override
        public String getPlanDetails() {
            return "Vegan Meal: Plant-based only, excludes all animal products.";
        }
    }

    static class KetoMeal implements MealPlan {
        @Override
        public String getPlanDetails() {
            return "Keto Meal: High-fat, low-carb, moderate protein.";
        }
    }

    static class HighProteinMeal implements MealPlan {
        @Override
        public String getPlanDetails() {
            return "High-Protein Meal: Focuses on lean meats, legumes, and protein-rich foods.";
        }
    }

    static class Meal<T extends MealPlan> {
        private T mealPlan;

        public Meal(T mealPlan) {
            this.mealPlan = mealPlan;
        }

        public T getMealPlan() {
            return mealPlan;
        }

        @Override
        public String toString() {
            return mealPlan.getPlanDetails();
        }
    }

    static class MealPlanUtils {
        public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
            
            if (mealPlan == null) {
                throw new IllegalArgumentException("Invalid meal plan!");
            }
            System.out.println("Meal plan generated successfully!");
            return new Meal<>(mealPlan);
        }
    }

    public static void main(String[] args) {
        
        Meal<VegetarianMeal> vegMeal = MealPlanUtils.generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealPlanUtils.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealPlanUtils.generateMealPlan(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = MealPlanUtils.generateMealPlan(new HighProteinMeal());

        System.out.println("\nPersonalized Meal Plans:");
        System.out.println(vegMeal);
        System.out.println(veganMeal);
        System.out.println(ketoMeal);
        System.out.println(proteinMeal);
    }
}
