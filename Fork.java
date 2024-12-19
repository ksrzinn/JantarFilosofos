
public class Fork {
    private boolean isAvailable;
    
    public Fork (){
        this.isAvailable = true;
    }

    public synchronized void pickup(int forkPosition) throws InterruptedException{
        while (!this.isAvailable){
            System.out.println("THE FORK " + forkPosition + "ISNT AVAILABLE! PLEASE WAIT");
            wait();
        }
        this.isAvailable = false;
    }

    public synchronized void pickdown() {
        this.isAvailable = true;
        notifyAll();
    }
}



