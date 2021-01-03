package level.threads;

import level.Level;
import level.customer.CustomerState;
import level.customer.Order;
import level.recipe.Recipe;

import java.util.Iterator;
import java.util.Random;

public class CustommerThread extends Thread {

    private Level level;
    private double timer;
    private boolean isRunning;
    private double timeBetweenCustomer;

    public CustommerThread(Level level) {
        this.level = level;
        this.isRunning = true;
        this.timer = 0;
        this.setTimeBetweenCustomer();

    }
    public void run() {
        while (isRunning) {
            try {
                sleep(25);
                this.timer += 0.025;
                this.timer = (double) Math.round(this.timer * 1000.0) / 1000.0;
                if (level.getCustommers().size() < 3) {
                    if (timer%this.timeBetweenCustomer == 0) {
                        this.addCustomer();
                        this.timer = 0;
                        System.out.println(timer + " " + this.timeBetweenCustomer);
                    }
                }
                if (level.getCustommers().size() == 0) {
                    this.addCustomer();
                    System.out.println(timer + " " + this.timeBetweenCustomer);
                }
                for (Order order: level.getCustommers()) {
                    order.setTime(order.getTime() - 0.025);
                }
                this.removeOutdatedOrders();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private CustomerState generateCustomerState() {
        switch (this.level.getDifficulty()) {
            case EASY -> {
                return CustomerState.PATIENT;
            }

            case NORMAL -> {
                int result = (int) (Math.random()*20);
                if (result >= 19) {
                    return CustomerState.IMPATIENT;
                } else if (result >= 13) {
                    return CustomerState.NORMAL;
                } else {
                    return CustomerState.PATIENT;
                }
            }

            case HARD -> {
                int result = (int) (Math.random()*10);
                if (result >= 7) {
                    return CustomerState.IMPATIENT;
                } else if (result >= 4) {
                    return CustomerState.NORMAL;
                } else {
                    return CustomerState.PATIENT;
                }
            }

            case VERY_HARD -> {
                int result = (int) (Math.random()*20);
                if (result >= 12) {
                    return CustomerState.IMPATIENT;
                } else if (result >= 3) {
                    return CustomerState.NORMAL;
                } else {
                    return CustomerState.PATIENT;
                }
            }

            case INSANE -> {
                return CustomerState.IMPATIENT;
            }

            default -> {
                System.out.println("ZA WORLD");
                return CustomerState.PATIENT;
            }
        }
    }

    private double waitingTime(CustomerState customerState, Recipe recipe) {
        int baseTime = recipe.getListIngredient().size()*5;
        switch (customerState) {
            case NORMAL -> {
                return (13 + baseTime);
            }
            case IMPATIENT -> {
                return (10 + baseTime);
            }
            default -> {
                return (15 + baseTime);
            }
        }
    }

    private void setTimeBetweenCustomer() {
        switch (level.getDifficulty()) {
            case NORMAL -> this.timeBetweenCustomer = 22;
            case HARD -> this.timeBetweenCustomer = 20;
            case VERY_HARD -> this.timeBetweenCustomer = 17;
            case INSANE -> this.timeBetweenCustomer = 15;
            default -> this.timeBetweenCustomer = 25;
        }
    }

    private Recipe randomRecipe() {
        Random r = new Random();
        int low = 0;
        int high = level.getRecipes().size();
        return this.level.getRecipes().get(r.nextInt(high-low) + low);
    }

    private void addCustomer() {
        CustomerState state = this.generateCustomerState();
        Recipe randomRecipe = this.randomRecipe();
        this.level.getCustommers().add(new Order(this.randomRecipe(), this.waitingTime(state, randomRecipe), state));
    }

    private void removeOutdatedOrders() {
        for (Order order : this.level.getCustommers()) {
            if (order.getTime() <= 0) {
                this.level.getCustommers().remove(order);
                switch (this.level.getDifficulty()) {
                    case NORMAL -> this.level.addScore(-7);
                    case HARD -> this.level.addScore(-11);
                    case VERY_HARD -> this.level.addScore(-15);
                    case INSANE -> this.level.addScore(-17);
                    default -> this.level.addScore(-5);
                }
            }
        }
    }

    public void stopRunning() {
        this.isRunning = false;
    }
}
