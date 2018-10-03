package note.lambok;

import lombok.Builder;

/**
 * Can wither check the source code in .class using decompiler or refactor->delombok(this will change the actual code)
 */
@Builder
public class Person {
  private String name;
  private int age;
}
