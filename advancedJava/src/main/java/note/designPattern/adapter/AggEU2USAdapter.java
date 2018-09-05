package note.designPattern.adapter;

public class AggEU2USAdapter {
    private EuroPlug ep = new EuroPlug();

    public void connect(){
        this.ep.plug();
    }
}
