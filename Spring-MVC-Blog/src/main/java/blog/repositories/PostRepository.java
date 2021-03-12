package blog.repositories;

import blog.models.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("Select p from Post p LEFT JOIN FETCH p.author order by p.date DESC")
    List<Post> findLatest5Posts(Pageable pageable);
}
