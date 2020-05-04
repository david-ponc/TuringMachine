package davidponce.utils;

import davidponce.controllers.AppController;
import javafx.application.Platform;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ResultsDesk {
    public static void showStepsList(List<String> steps, AppController appController) {
        Runnable task = () -> {
            steps.forEach(step -> {
                try {
                    Thread.sleep(1000);
                }catch(Exception e) { e.printStackTrace(); }
                Platform.runLater(() -> {
                    appController.addStep(step);
                });
            });
            //appController.validationNotify();
        };
        new Thread(task).start();
    }

    public static void showStatesTape(List<List<String>> states, List<Integer> pointerPositions, AppController appController) {
        Runnable task = () -> {
            AtomicReference<Integer> index = new AtomicReference<>(0);
            states.forEach(state -> {
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e) { e.printStackTrace(); }
                Platform.runLater(() -> {
                        appController.updateStateTape(state, pointerPositions.get(index.get()));
                        index.getAndSet(index.get() + 1);
                });
            });
        };
        new Thread(task).start();
    }
}
