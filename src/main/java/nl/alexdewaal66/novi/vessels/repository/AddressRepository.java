package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Address;
import nl.alexdewaal66.novi.vessels.model.AddressSummary;

import java.util.Collection;

public interface AddressRepository extends GenericRepository<Address> {

    Collection<AddressSummary> findAllSummariesBy();

    Collection<AddressSummary> findSummariesByIdIn(Collection<Long> ids);

}
