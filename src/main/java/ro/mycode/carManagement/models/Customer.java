package ro.mycode.carManagement.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Table(name = "customers")
@Entity(name = "Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "fullName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty
    private String fullName;


    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty
    private String email;

    @Column(
            name = "age",
            nullable = false,
            columnDefinition = "INT"
    )
    private int age;

    @Column(
            name = "adress",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty
    private String adress;

    @Column(
            name = "domain",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty
    private String domain;


    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JsonManagedReference
    private List<Car> carList= new ArrayList<>();


    public Customer(String fullName, String email, int age, String adress, String domain) {
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.adress = adress;
        this.domain = domain;
    }

    @Override
    public String toString(){
        return id+","+fullName+","+email+","+age+","+adress+","+domain;
    }


    //addCar

    public void addCar(Car car){
       this.loadLazzyCollection();
        car.setCustomer(this);
        for(Car c: carList) {
            if(!c.equals(car)){
            this.carList.add(car);
        }
        }
    }

    public void eraseCar(Car car) {
        for (Car c : carList) {
            if(c.equals(car)){
            this.carList.remove(car);
        }
        }
    }


    @Transactional
    public void loadLazzyCollection(){

        this.carList.size();
    }



}

