package Designs;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

interface ChatRoom {

    public void showMsg(String msg, Participant p);

}



 class ChatRoomImpl implements ChatRoom{

    DateFormat dateFormat = new SimpleDateFormat("E dd-MM-yyyy hh:mm a");
    Date date = new Date();
    @Override
    public void showMsg(String msg, Participant p) {

        System.out.println(p.getName()+"'gets message: "+msg);
        System.out.println("\t\t\t\t"+"["+dateFormat.format(date).toString()+"]");
    }
}



 abstract class Participant {
    public abstract void sendMsg(String msg);
    public abstract void setname(String name);
    public abstract String getName();
}


 class User1 extends Participant {

    private String name;
    private ChatRoom chat;

    @Override
    public void sendMsg(String msg) {
        chat.showMsg(msg,this);

    }

    @Override
    public void setname(String name) {
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    public User1(ChatRoom chat){
        this.chat=chat;
    }

}

 class User2 extends Participant {

    private String name;
    private ChatRoom chat;

    @Override
    public void sendMsg(String msg) {
        this.chat.showMsg(msg,this);

    }

    @Override
    public void setname(String name) {
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    public User2(ChatRoom chat){
        this.chat=chat;
    }



}




public class MediatorDesign {

    public static void main(String args[])
    {

        ChatRoom chat = new ChatRoomImpl();

        User1 u1=new User1(chat);
        u1.setname("Anushka Rajput");
        u1.sendMsg("Hi Anushka! how are you?");


        User2 u2=new User2(chat);
        u2.setname("Sonu Jaiswal");
        u2.sendMsg("I am Fine ! tell me about you");
    }

}