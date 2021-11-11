class SingleObject {

    private static SingleObject instance = new SingleObject();


    private SingleObject(){}

    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello there!");
    }
}
public class SingletonDesign {
    public static void main(String[] args){
        SingleObject object = SingleObject.getInstance();
        object.showMessage();
    }
}