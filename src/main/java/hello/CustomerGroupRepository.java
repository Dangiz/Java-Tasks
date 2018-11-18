package hello;


import org.springframework.data.repository.CrudRepository;

public interface CustomerGroupRepository extends CrudRepository<CustomerGroup,Long> {
}
