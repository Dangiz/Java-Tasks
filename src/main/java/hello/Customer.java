// tag::sample[]
package hello;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    @ManyToMany(mappedBy = "customers",fetch = FetchType.EAGER)
    private Set<CustomerGroup> groups = new HashSet<>();


	public Long getId() {
		return id;
	}

	public String getFirstName() { return firstName; }

	public String getLastName() {
		return lastName;
	}

	public Set<CustomerGroup> getGroups() { return groups; }
}

