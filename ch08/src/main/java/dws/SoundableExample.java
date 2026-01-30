package dws;

public class SoundableExample {
    public static void printSound(Soundable soundable){
        System.out.println(soundable.sound());
    }

    static void main(){
        printSound(new Cat());
        printSound(new Dog());
    }
}
