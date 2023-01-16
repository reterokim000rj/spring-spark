package com.springspark.training.spark;

import lombok.extern.slf4j.Slf4j;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SparkConfig {
    private static final String LOCAL_MASTER = "Local[*]";

    @Bean
    public JavaSparkContext sparkContext(SparkSession session) {
        return JavaSparkContext.fromSparkContext(session.sparkContext());
    }

    @Bean
    public SparkSession sparkSession() {
        return SparkSession.builder()
                .master(new SparkConf().get("spark.master", LOCAL_MASTER))
                .appName("Spring Spark Training")
                .getOrCreate();
    }

    @Bean
    public TypedDataset typedDataset(
            /*String AGE_MIDPOINT,
            String SALARY_MIDPOINT,
            String SALARY_MIDPOINT_BUCKET,*/
            SparkSession sparkSession) {
        return new TypedDataset(
                /*AGE_MIDPOINT,
                SALARY_MIDPOINT,
                SALARY_MIDPOINT_BUCKET,*/
                sparkSession);
    }
}
