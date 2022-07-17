package investimentos.crypto.repository;

import investimentos.crypto.domain.investimentos.entity.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, UUID> {
}
