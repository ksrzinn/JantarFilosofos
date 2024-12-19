public class Philosopher {
    private int id;
    private int meals;
    private int thoughts;

    public Philosopher(int id){
        this.id = id;
        this.meals = 0;
        this.thoughts = 0;
    }

    public int getId(){
        return this.id;
    }

    public void think(){
        this.thoughts++;
    }

    public void eat(){
        this.meals++;
    }
    
    public int getMeals(){
        return this.meals;
    }

    public int getThoughts(){
        return this.thoughts;
    }
}
