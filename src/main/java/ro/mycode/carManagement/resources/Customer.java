package ro.mycode.carManagement.resources;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;

import javax.persistence.*;
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
            fetch = FetchType.LAZY
    )
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

}

