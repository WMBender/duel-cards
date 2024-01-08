package br.com.weslei.bender.api.duelcards.repository;

import br.com.weslei.bender.api.duelcards.domain.card.details.SpellCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellRepository extends JpaRepository<SpellCard, Long> {
}
