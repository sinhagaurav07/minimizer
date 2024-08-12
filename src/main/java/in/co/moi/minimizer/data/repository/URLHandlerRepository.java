package in.co.moi.minimizer.data.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import in.co.moi.minimizer.data.model.URLDetailDO;
import in.co.moi.minimizer.data.model.URLDetailPrimaryKey;


@Repository
public interface URLHandlerRepository extends CassandraRepository<URLDetailDO, URLDetailPrimaryKey> {

	//void deleteById(URLDetailDO urlDetailDO);

}
