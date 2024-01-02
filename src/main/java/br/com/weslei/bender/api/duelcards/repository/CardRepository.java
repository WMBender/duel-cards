package br.com.weslei.bender.api.duelcards.repository;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
