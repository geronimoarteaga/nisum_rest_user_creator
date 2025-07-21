package com.nisum.cl.springboot.rest.usercreation.entities;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public final class UserInfo
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_SEQ")
    @EqualsAndHashCode.Include
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column
    private String password;

    @Builder.Default
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_info_id")
    private List<UserPhone> phones = new ArrayList<>();

    @Builder.Default
    @Column
    private Date created = new Date();
    @Column
    private Date modified;
    @Builder.Default
    @Column(name = "last_login")
    private Date lastLogin = new Date();
    @Builder.Default
    @Column
    private String token = UUID.randomUUID().toString();
    @Builder.Default
    @Column
    private Boolean isactive = true;
}
