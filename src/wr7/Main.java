package wr7;
public class Main {
    private static int time=0;
    public static void main(String[] args) {

        Cat[] cat=new Cat[3];
        cat[0]=new Cat("Барсик", 150,2);
        cat[1]=new Cat("Мурзик",100,3);
        cat[2]=new Cat("Амур",200,5);
        Plate plate = new Plate(1000);
        System.out.println("There is 3 cats: "+cat[0].getName()+", " + cat[1].getName()+" and "+cat[2].getName()+" eat every "+cat[0].getSatietyTime()+" and "+cat[1].getSatietyTime()+" and also "+cat[2].getSatietyTime());
        System.out.println("\n now there is " +plate.getFood()+"gram of cat food");

        do{
            for(Cat i: cat){
                if(i.getSatiety()==0){
                    if(!plate.checkFood(i.getAppetite())){
                        plate.increaseFood();

                    }
                    i.eat(plate);
                    System.out.println("\nCat"+i.getName()+" ate "+i.getAppetite()+" gram of cat food in"+(i.getSatiety())+" hours ");
                }
                i.setSatiety(i.getSatiety()-1);


            }
            System.out.println("\nFood remaining "+ plate.getFood()+" gram, time went"+time+"\n");
            time++;
        }while(time<=24);

    }
}


class Plate {
    private int food;

    int getFood(){
        return food;

    }
    public Plate(int food) {
        this.food = food;

    }
    public void decreaseFood(int n) {
        food -= n;
    }
    void increaseFood(){
        this.food+=400;
        System.out.println("\n\nAdd 400g\n\n");


    }
    public void info() {
        System.out.println("\nplate: " + food);
    }
    boolean checkFood(int n){
        return (food-n)>=0;
    }

}
class Cat {
    private String name;
    private int appetite;
    private int satietyTime;
    private int satiety;

    String getName() {
        return name;
    }

    int getAppetite() {
        return appetite;
    }

    int getSatietyTime() {
        return satietyTime;
    }

    int getSatiety() {
        return satiety;
    }

    void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    Cat(String name, int appetite, int satietyTime) {

        this.name = name;
        this.appetite = appetite;
        this.satietyTime = satietyTime;
        this.satiety = 0;
    }

    void eat(Plate p) {
        p.decreaseFood(appetite);
        satiety += satietyTime;
    }
}

