package com.springspark.training.spark;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {
    protected String country;
    protected Integer ageMidPoint;
    protected String occupation;
    protected Integer salaryMidPoint;

    @Override
    public String toString() {
        return "Response{" +
                "country='" + country + '\'' +
                ", ageMidPoint=" + ageMidPoint +
                ", occupation='" + occupation + '\'' +
                ", salaryMidPoint=" + salaryMidPoint +
                '}';
    }
}
