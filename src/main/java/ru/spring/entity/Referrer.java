package ru.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "referrers")
public class Referrer {
	@Id
	@Column(name = "referrer_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referrer_seq")
	@SequenceGenerator(sequenceName = "referrer_seq", name = "referrer_gen")
	private Integer id;
	private Integer num_of_followers;
	private String ref_name;
	@OneToMany(mappedBy = "referrer", fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.MERGE})
	private List<Profile> profiles;
}
