package cvr.simple.vaadin.repo;

import cvr.simple.vaadin.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;


@Repository
@EntityScan(basePackageClasses = Picture.class)
public class PictureRepository implements IPictureRepository {
    private static final String KEY ="Picture";
    private RedisTemplate<String,Object> redisTemplate;
    private HashOperations<String,String, Picture> hashOperations;

    @Override
    public void save(Picture picture) {
        hashOperations.put(KEY,picture.getName(),picture);
    }

    @Override
    public Picture find(String name) {
        return hashOperations.get(KEY,name);
    }

    @Autowired
    public PictureRepository(RedisTemplate _redisTemplate) {
        this.redisTemplate = _redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }
}
