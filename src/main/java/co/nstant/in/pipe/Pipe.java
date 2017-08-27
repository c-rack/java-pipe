/**
 * Implementation of the Elixir pipe operator behavior in Java.
 *
 * Copyright (c) 2017 Constantin Rack
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.nstant.in.pipe;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Pipe<A> {

    @FunctionalInterface
    public interface TriFunction<A, B, C, R> {

        R apply(A a, B b, C c);

    }

    @FunctionalInterface
    public interface QuadriFunction<A, B, C, D, R> {

        R apply(A a, B b, C c, D d);

    }

    public final A a;

    private Pipe(A a) {
        this.a = a;
    }

    public static <A> Pipe<A> apply(A a) {
        return new Pipe<A>(a);
    }

    public <R> Pipe<R> pipe(Function<A, R> f) {
        return new Pipe<R>(f.apply(a));
    }

    public <R, B> Pipe<R> pipe(BiFunction<A, B, R> f, B b) {
        return new Pipe<R>(f.apply(a, b));
    }

    public <R, B, C> Pipe<R> pipe(TriFunction<A, B, C, R> f, B b, C c) {
        return new Pipe<R>(f.apply(a, b, c));
    }

    public <R, B, C, D> Pipe<R> pipe(QuadriFunction<A, B, C, D, R> f, B b, C c, D d) {
        return new Pipe<R>(f.apply(a, b, c, d));
    }

    public A result() {
        return a;
    }

}
