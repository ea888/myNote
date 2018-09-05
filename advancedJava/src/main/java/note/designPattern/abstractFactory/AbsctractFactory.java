package note.designPattern.abstractFactory;

public interface AbsctractFactory {
    Suv produceSuv(String brand);
    Sedan produceSedan(String brand);
}
