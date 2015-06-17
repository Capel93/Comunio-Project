package cat.udl.eps.softarch.hello.repository;



import cat.udl.eps.softarch.hello.model.TeamSquad;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by joanmarc on 20/05/15.
 */
public interface TeamSquadRepository extends PagingAndSortingRepository<TeamSquad, Long> {
    //TeamSquad findTeamSquadByUserName(@Param("username") String userName);
    //TeamSquad findTeamSquadByManagerName(@Param("manager") String manager);
    TeamSquad findTeamSquadByName(@Param("name") String name);
    TeamSquad findTeamSquadById(@Param("id") Long id);

}