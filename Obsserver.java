package Designs;

import java.util.ArrayList;
import java.util.List;

interface Subject{
void register(Observer observer);
void unregister(Observer observer);
public void notifyObservers();
Object getUpdate(Observer observer);
}
interface Observer{
  void update();
  void setSubject(Subject subject);
}
class EmailTopic implements Subject{
 private List<Observer >observers;
 private String message;
 public EmailTopic(){
  this.observers=new ArrayList<>();
 }
 @Override
 public void register(Observer observer) {
if (observer==null) throw new NullPointerException("Null Object/Observer");
if(!observers.contains(observer))
 observers.add(observer);

 }

 @Override
 public void unregister(Observer observer) {
observers.remove(observer);
 }

 @Override
 public void notifyObservers() {
for(Observer observer: observers){
 observer.update();

}
 }

 @Override
 public Object getUpdate(Observer observer) {
  return this.message;
 }
 public void postMessage(String msg){
  System.out.println("Message posted to my topic:"+ msg);
  this.message= msg;
  notifyObservers();
 }
}
class EmailTopicSubscriber implements Observer{
 private String name;
 private Subject topic;
 public EmailTopicSubscriber(String name){
  this.name=name;
 }
 @Override
 public void update() {
  String msg= (String)topic.getUpdate(this);
  if(msg==null)
   System.out.println(name+" : no new message on this topic");
  else System.out.println(name+"Retreiving message"+msg);



 }

 @Override
 public void setSubject(Subject subject) {
this.topic=subject;
 }
}
public class Obsserver {
 public static void main(String[] args) {
  EmailTopic topic= new EmailTopic();
  Observer firstObserver=new EmailTopicSubscriber("First Observer");
  Observer secondObserver=new EmailTopicSubscriber("Second Observer");
  Observer thirdObserver=new EmailTopicSubscriber("Third Observer");
  topic.register(firstObserver);
  topic.register(secondObserver);
  topic.register(thirdObserver);
  firstObserver.setSubject(topic);
  firstObserver.setSubject(topic);
  firstObserver.setSubject(topic);

  firstObserver.update();
  thirdObserver.update();
  topic.postMessage("hello subscribers");
  topic.unregister(firstObserver);
  topic.postMessage("Hello Subscribers");
 }
}