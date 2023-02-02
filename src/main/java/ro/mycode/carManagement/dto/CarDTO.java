package ro.mycode.carManagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String make;
    private String owner;
    private int year;
    private String engineType;
    private int horsePower;
    private String color;

    @Override
    public String toString(){
        return make+","+owner+","+year+","+engineType+","+horsePower+","+color;
    }
}
