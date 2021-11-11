package Designs;

interface   Icecream{
    double cost();

}
class Icecream_decorator implements Icecream{
    private Icecream icecream;
public Icecream_decorator(Icecream icecream){
    this.icecream=icecream;
}
    @Override
    public double cost() {
        return this.icecream.cost();
    }
}
