package ro.mycode.carManagement.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Car")
@Table (name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Car {
  @Id
    @SequenceGenerator(
            name =  "cars_sequence",
            sequenceName = "cars_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =  SEQUENCE,
            generator = "cars_sequence"
    )
  @Column(
          name = "id"
  )
  private Long id;
    @Column(
            name = "make",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty
    private String make;

  @Column(
          name = "owner",
          nullable = false,
          columnDefinition = "TEXT"
  )
  @NotEmpty
    private String owner;

  @Column(
          name = "year",
          nullable = false,
          columnDefinition = "INT"
  )

  private int year;

  @Column(
          name = "engineType",
          nullable = false,
          columnDefinition = "TEXT"
  )
  @NotEmpty
  private String engineType;

  @Column(
          name = "horsePower",
          nullable = false,
          columnDefinition = "INT"
  )
  private int horsePower;

  @Column(
          name = "color",
          nullable = false,
          columnDefinition = "TEXT"
  )
  @NotEmpty
  private String color;


  @ManyToOne
  @JoinColumn(name="customer_id",
          referencedColumnName = "id",
          foreignKey = @ForeignKey(name="customer_id_fk")
  )
  @JsonBackReference
  private  Customer customer;

  public Car(String make, String owner, int year, String engineType, int horsePower, String color) {
    this.make = make;
    this.owner = owner;
    this.year = year;
    this.engineType = engineType;
    this.horsePower = horsePower;
    this.color = color;
  }


  @Override
  public String toString(){
    return id +","+make+","+owner+","+year+","+engineType+","+horsePower+","+color;
  }

}
