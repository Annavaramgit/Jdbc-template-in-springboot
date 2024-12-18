package com.jdbctemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchedulerPractice {

	public static void main(String[] args) {
		List<Boolean> list = new ArrayList<>();
		list.add(true);
		list.add(true);
		list.add(true);
		System.out.println(list);

		SchedulerPractice t = new SchedulerPractice();
		t.m1(list);

	}

	int currentRetry = 0;
	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
	int maxRetries = 10; // Maximum number of retries
	boolean status = false;

	public void m1(List<Boolean> ar) {
		log.info("m1 entered");

		scheduler.scheduleAtFixedRate(() -> {
			if (currentRetry < maxRetries) {
				System.out.println("Executing retry " + (currentRetry + 1) + " at " + LocalDateTime.now());

				boolean hasFalse = ar.contains(false);
				if (hasFalse) {
					log.info("if block means not all in list are true");
					currentRetry++;

				} else {
					log.info("else block means all in list are true");
					scheduler.shutdown();
				}

			} else {
				System.out.println("Maximum retries reached. Shutting down scheduler.");
				scheduler.shutdown(); // Stop further executions
			}
		}, 0, 5, TimeUnit.SECONDS);

	}

}
