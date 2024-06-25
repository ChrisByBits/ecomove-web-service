package com.ecogo.ecomove_web_service.user_management.domain.model.aggregates;

import com.ecogo.ecomove_web_service.user_management.domain.model.commands.CreateUserCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class) // it is used to automatically populate the createdAt and updatedAt fields
public class User extends AbstractAggregateRoot<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    /** The username of the user. */
    @Column(nullable = false)
    @Getter
    private String username;

    /** The email of the user. */
    @Column(nullable = false)
    @Getter
    private String email;

    /** The password of the user. */
    @Column(nullable = false)
    @Getter
    private String password;

    /** The first name of the user. */
    @Column(nullable = false)
    @Getter
    private String firstName;

    /** The last name of the user. */
    @Column(nullable = false)
    @Getter
    private String lastName;

    /** The date and time when the favorite source was created. */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    /** The date and time when the favorite source was last updated. */
    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    protected User() {}

    /**
     *
     * @param command The command to create a user.
     */
    public User(CreateUserCommand command) {
        this.username = command.username();
        this.email = command.email();
        this.password = command.password();
        this.firstName = command.firstName();
        this.lastName = command.lastName();
    }
}
