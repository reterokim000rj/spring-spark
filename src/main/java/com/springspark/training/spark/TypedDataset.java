package com.springspark.training.spark;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.Serializable;

import static org.apache.spark.sql.functions.col;

@AllArgsConstructor
@NoArgsConstructor
public class TypedDataset implements Serializable {
    /*private static final String AGE_MIDPOINT = "ageMidpoint";
    private static final String SALARY_MIDPOINT = "salaryMidPoint";
    private static final String SALARY_MIDPOINT_BUCKET = "salaryMidpointBucket";*/

    private SparkSession sparkSession;

    Dataset<Row> responses = sparkSession.read().option("header", "true").csv("in/2016-stack-overflow-survey-responses.csv");

    Dataset<Row> responseWithSelectedColumns = responses.select(
            col("country"),
            col("age_midpoint").as("ageMidPoint").cast("integer"),
            col("occupation"),
            col("salary_midpoint").as("salaryMidPoint").cast("integer"));

    Dataset<Response> typedDataset = responseWithSelectedColumns.as(Encoders.bean(Response.class));

    public TypedDataset(SparkSession sparkSession) {

    }
}
