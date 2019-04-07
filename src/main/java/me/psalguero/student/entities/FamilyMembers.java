package me.psalguero.student.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.psalguero.student.types.ParentOrStudent;

import javax.persistence.*;

@Entity
@Table(name = "family_members")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FamilyMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "family_members_id", nullable = false)
    private int familyMembersId;

    @Column(name = "parent_or_student_member", nullable = false)
    private ParentOrStudent parentOrStudent;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id", nullable = false)
    private Parent parent;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
