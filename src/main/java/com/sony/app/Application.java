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
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(DBConfig.class,BatchConfig.class);
        ctx.refresh();
        JobLauncher  jobLauncher = ctx.getBean(JobLauncher.class);
        //case: one job name 
        Job job = (Job)ctx.getBean(jobname[0]);
        try {
            jobLauncher.run(job, new JobParameters());
        } catch (Exception e) {
        	logger.error("Has job exception occur! ",e);
        }
        ctx.close();
	}

}
