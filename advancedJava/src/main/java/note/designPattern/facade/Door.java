package note.designPattern.facade;

public class Door {
    public void start(){
        System.out.println("Start "+this.getClass().getSimpleName());
    }

    public void shutdown(){
        System.out.println("Shutdown "+this.getClass().getSimpleName());
    }
}
