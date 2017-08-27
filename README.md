# java-pipe

Implementation of the [Elixir pipe operator](https://elixirschool.com/en/lessons/basics/pipe-operator/) behavior in Java.

Functions with up to 3 (TriFunction) respectively 4 (QuadriFunction) arguments are supported.

## Description

In [Elixir](https://elixir-lang.org/),
a value can be passed to a function using the pipe operator (`|>`),
where the value is automatically used as first argument of the function.

While Java 8 has introduced [function composition](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html) with `.andThen()`, it is not exactly what I was searching for when trying to mimic
Elixir's pipe operator in Java. So I wrote this small class and hope someone finds it useful.

## Usage example

```java
apply("ab")
  .pipe((a) -> a.toUpperCase())                 // "AB"
  .pipe((a, b) -> a.replace('A', b), '1')       // "1B"
  .pipe((a, b, c) -> a.replace(b, c), 'B', '2') // "12"
  .pipe((a) -> Integer.valueOf(a))              // 12
  .pipe((a, b, c, d) -> a + b * c - d, 1, 2, 3) // 11
  .pipe((a) -> a.toString())                    // "11"
  .result()
```
