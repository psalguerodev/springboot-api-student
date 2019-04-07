package me.psalguero.student.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Role")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "role_id")
  private int id;

  @Column(name = "role")
  private String role;
}
