package ru.test.entity;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "referer_generator", sequenceName = "referrer_seq")
	private Integer id;
	private Integer num_of_followers;
	private String ref_name;
	@OneToMany(mappedBy = "referrer", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<Profile> profiles;
}
