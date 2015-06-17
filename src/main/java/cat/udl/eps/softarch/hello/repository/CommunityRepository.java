package cat.udl.eps.softarch.hello.repository;


import cat.udl.eps.softarch.hello.model.Community;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by joanmarc on 21/05/15.
 */
public interface CommunityRepository extends PagingAndSortingRepository<Community, String> {
}
