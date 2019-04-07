package me.psalguero.student.entities;


import lombok.*;
import me.psalguero.student.types.Gender;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "student_id")
  private int studentId;

  @Column(name = "gender")
  private Gender gender;

  @Column(name = "firts_name")
  @Size(max = 60)
  private String firstName;

  @Column(name = "middle_name")
  @Size(max = 60)
  private String middleName;

  @Column(name = "last_name")
  @Size(max = 60)
  private String lastName;

  @Column(name = "other_student_detail")
  @Size(max = 100)
  private String otherStudentDetail;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "student_parent", joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "parent_id"))
  private Set<Parent> parent;

}
