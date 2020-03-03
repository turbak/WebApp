package ru.spring.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "profiles")
public class Profile {
	@Id
	@Column(name = "profile_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_gen")
	@SequenceGenerator(sequenceName = "profile_seq", name = "profile_gen")
	private Integer id;
	@Column(unique = true)
	private String login;
	private String password;
	private String name;
	private String surname;
	@ColumnDefault(value = "false")
	private boolean admin;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "referrer_id")
	private Referrer referrer;

	@Override
	public String toString() {
		return String.format("%s %s\n", name, surname);
	}
}
