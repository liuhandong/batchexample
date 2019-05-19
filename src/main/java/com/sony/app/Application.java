package com.sony.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sony.config.BatchConfig;
import com.sony.config.DBConfig;

public class Application implements CommandLineRunner {
	public static AnnotationConfigApplicationContext context = null;
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main( String[] args ) {
		try {
			new Application().run(args);
		} catch (Exception e) {
			logger.error("Has config exception occur! ",e);
		}
	}

	@Override
	public void run(String... jobname) throws Exception {
		context = new AnnotationConfigApplicationContext();
        context.register(DBConfig.class,BatchConfig.class);
        context.refresh();
        JobLauncher  jobLauncher = context.getBean(JobLauncher.class);
        //case: one job name 
        Job job = (Job)context.getBean(jobname[0]);
        try {
            jobLauncher.run(job, new JobParameters());
        } catch (Exception e) {
        	logger.error("Has job exception occur! ",e);
        }
        context.close();
	}

}
