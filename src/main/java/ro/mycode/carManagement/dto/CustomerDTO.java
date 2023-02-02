package ro.mycode.carManagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String fullName;
    private String email;
    private int age;
    private String adress;
    private String domain;

    @Override
    public String toString(){
        return fullName+","+email+","+age+","+adress+","+domain;
    }
}
