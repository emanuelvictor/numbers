package br.com.produtec.numbers.domain.entity;

import br.com.produtec.numbers.Application;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Emanuel Victor
 * @version 1.0.0
 * @since 1.0.0, 10/09/2019
 */
@Data
@Entity
@NoArgsConstructor
@RevisionEntity(EntityTrackingRevisionListener.class)
class Revision implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1770838608009757264L;

    /**
     *
     */
    @Id
    @RevisionNumber
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    /**
     *
     */
    @RevisionTimestamp
    private long timestamp;

    /**
     *
     */
    private Long userId;

}
