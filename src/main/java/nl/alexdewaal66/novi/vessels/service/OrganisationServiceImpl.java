package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Organisation;
import nl.alexdewaal66.novi.vessels.repository.OrganisationRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganisationServiceImpl
        extends GenericServiceImpl<Organisation>
    implements OrganisationService
{
    public OrganisationServiceImpl(OrganisationRepository repository) {
        super(repository);
    }
}
