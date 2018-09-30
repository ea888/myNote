package note.multithreading;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

public class CompletableFutureExample {
  public Future<String> calculateAsync() throws InterruptedException {
    CompletableFuture<String> completableFuture
      = new CompletableFuture<>();

    Executors.newCachedThreadPool().submit(() -> {
      Thread.sleep(500);
      completableFuture.complete("Hello");
      completableFuture.cancel(false);
      return null;
    });

    return completableFuture;
  }

  public Future<String> calculateAsync2(int sleepTime) throws InterruptedException {
    CompletableFuture<String> completableFuture
      = new CompletableFuture<>();

    Executors.newCachedThreadPool().submit(() -> {
      Thread.sleep(sleepTime);
      completableFuture.complete("Hello2 with passed in sleep time");
      completableFuture.cancel(false);
      return null;
    });

    return completableFuture;
  }

  public Optional<Integer> optionalAdd(Optional<Integer> val1, Optional<Integer> val2) {
    if (val1.isPresent() && val2.isPresent()) {
      return Optional.of(val1.get() + val2.get());
    }

    return Optional.empty();

  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFutureExample cfe = new CompletableFutureExample();
    Future<String> result = null;
    Future<String> result2 = null;
    try {
      result = cfe.calculateAsync();
      result2 = cfe.calculateAsync2(300);
      System.out.println(result.get());
      System.out.println(result2.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }


    CompletableFuture<String> future
      = CompletableFuture.supplyAsync(() -> "Hello").thenApply((s) -> s + "!!");

    System.out.println(future.get());
    future.thenAccept((s) -> System.out.println("Using consumer:" + s));


    CompletableFuture<String> completableFuture
      = CompletableFuture.supplyAsync(() -> "Hello to be composed")
      .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
    System.out.println(completableFuture.get());

    CompletableFuture<String> completableFuture2
      = CompletableFuture.supplyAsync(() -> "Hello")
      .thenCombine(CompletableFuture.supplyAsync(
        () -> " World"), (s1, s2) -> s1 + s2);

    System.out.println(completableFuture2.get());

    System.out.println(cfe.optionalAdd(Optional.of(50), Optional.ofNullable(100)));

    System.out.println(cfe.optionalAdd(Optional.of(50), Optional.ofNullable(null)));


    CompletableFuture<String> future1
      = CompletableFuture.supplyAsync(() -> "Hello");
    CompletableFuture<String> future2
      = CompletableFuture.supplyAsync(() -> "Beautiful");
    CompletableFuture<String> future3
      = CompletableFuture.supplyAsync(() -> "World");

//    CompletableFuture<Void> combinedFuture
//      = CompletableFuture.allOf(future1, future2, future3);

    String combined = Stream.of(future1, future2, future3)
      .map(CompletableFuture::join)
      .collect(Collectors.joining(" "));

    System.out.println(combined);


    String name = null;

    CompletableFuture<String> completableFuture3
      = CompletableFuture.supplyAsync(() -> {
      if (name == null) {
        throw new RuntimeException("Computation error!");
      }
      return "Hello, " + name;
    }).handle((s, t) -> s != null ? s : "Hello, Stranger!");

//    completableFuture3.completeExceptionally(new RuntimeException("Calculation failed!"));

    System.out.println(completableFuture3.get());
  }
}
