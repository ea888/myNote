package note.designPattern.fpVisitor;


import java.util.function.Consumer;

public interface Transaction {

    void accept(Consumer<Transaction> consumer);
}
