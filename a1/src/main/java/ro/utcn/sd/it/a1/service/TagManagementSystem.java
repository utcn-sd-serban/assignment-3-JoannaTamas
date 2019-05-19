package ro.utcn.sd.it.a1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.utcn.sd.it.a1.model.Tag;
import ro.utcn.sd.it.a1.persistance.api.RepositoryFactory;

import javax.transaction.Transactional;


@Component
@Service
@RequiredArgsConstructor
public class TagManagementSystem {
    private final RepositoryFactory repositoryFactory;


    @Transactional
    public Tag addTag(Tag tag){
        return repositoryFactory.createTagRepository().save(tag);

    }
}
