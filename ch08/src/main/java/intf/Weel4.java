package intf;

public class Weel4 implements move{
    private int weel4 = 4;
    public void drive(){
        System.out.println("weel4 driving");
    }

    @Override
    public void move() {
        System.out.println("weel4 Movin2g");
    }

    @Override
    public void FastMove() {
        System.out.println("weel4 fast Moving");
    }

    @Override
    public void SlowMove() {
        System.out.println("weel4 slow Moving");
    }
}
