package ru.test.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
