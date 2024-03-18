package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 2),
                new Job("Fix bugs", 4),
                new Job("Reboot server", 1),
                new Job("Fix bug", 1),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );

        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        Collections.sort(jobs, new JobByName());
        System.out.println(jobs);
        jobs.sort(new JobDescByName());
        System.out.println(jobs);
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);

        Comparator<Job> combine = new JobDescByNameLength()
                .thenComparing(new JobDescByName())
                .thenComparing(new JobDescByPriority());
        Collections.sort(jobs, combine);
    }
}
