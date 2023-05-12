package com.epam.rd.autotasks;

import java.util.ArrayList;

public class TaskCarousel {
    private final int capacity;
    private final ArrayList<Task> tasks = new ArrayList<>();
    private int currentIndex = 0;
    private int counter = -1;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
    }

    public boolean addTask(Task task) {
        /*You may add tasks to the carousel via `addTask` method.
                It returns `true` if the task is accepted and `false` otherwise.
                Task may be not accepted due to following reasons:
        - Task argument is null.
                - Task is already finished.
                - Carousel is full.*/
        if(task == null || task.isFinished() || isFull())
        {
            return false;
        }
        tasks.add(task);
        return true;
    }

    public boolean execute() {
        /*if (isEmpty()){
            return  false;
        }

        Task currentTask = tasks.get(currentIndex);
        currentTask.execute();

        if (currentTask.isFinished()){
            tasks.remove(currentIndex);
            currentIndex--;
        }

        currentIndex = (currentIndex + 1) % tasks.size();
        return true;*/

        if (!isEmpty()) {
            counter++;
            if(counter == tasks.size()) counter = 0;
            Task task = tasks.get(counter);

            task.execute();

            if(task.isFinished()) {
                tasks.remove(task);
                counter--;
            }
            return true;
        }
        return false;

    }

    public boolean isFull() {

        return tasks.size()  == capacity;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

}
