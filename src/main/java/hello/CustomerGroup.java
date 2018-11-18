package hello;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CustomerGroup {

    public CustomerGroup() {
    }

    public CustomerGroup(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
    },fetch = FetchType.EAGER)
    @JoinTable(name = "group_customer",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> customers = new HashSet<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.getGroups().add(this);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        customer.getGroups().remove(this);
    }

    @Override
    public String toString() {
        String string= "CustomerGroup{" +
                "id=" + id +
                ", name='" + name +"\' customers=[";
        for (Customer customer:customers) {
            string+=customer.toString()+',';
        }
        return string;
    }
}
