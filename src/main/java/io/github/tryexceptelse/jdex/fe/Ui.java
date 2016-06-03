package io.github.tryexceptelse.jdex.fe;

/**
 * UI interface implemented by either GUI or TUI
 */
public interface Ui {
    /**
     * method called in order to maintain user interface
     * This method should be called each iteration of the main loop.
      */
    void run(String[] args);
}
