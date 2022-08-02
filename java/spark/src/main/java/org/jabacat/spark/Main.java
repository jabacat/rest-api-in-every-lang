package org.jabacat.spark;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/intro", (req, res) -> "Welp this is Spark ig");
    }
}
