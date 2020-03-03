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
	@Column(name = "num_of_followers")
	private Integer numOfFollowers;
	@Column(name = "ref_name")
	private String refName;
	@OneToMany(mappedBy = "referrer", fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.MERGE})
	private List<Profile> profiles;
}
