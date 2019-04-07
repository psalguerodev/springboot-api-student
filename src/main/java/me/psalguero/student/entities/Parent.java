package me.psalguero.student.entities;

import lombok.*;
import me.psalguero.student.types.Gender;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "parent")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Parent {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "parent_id")
  private int parentId;

  @Column(name = "gender", nullable = false)
  private Gender gender;

  @Column(name = "first_name", nullable = false)
  @Size(max = 60)
  private String firstName;

  @Column(name = "middle_name")
  @Size(max = 60)
  private String middleName;

  @Column(name = "last_name")
  @Size(max = 60)
  private String lastName;

  @Column(name = "other_parent_detail")
  @Size(max = 100)
  private String otherParentDetail;

}
