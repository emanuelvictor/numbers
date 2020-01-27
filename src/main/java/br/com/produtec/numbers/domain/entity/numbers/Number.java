package br.com.produtec.numbers.domain.entity.numbers;

import br.com.produtec.numbers.domain.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Emanuel Victor
 * @version 1.0.0
 * @since 1.0.0, 10/09/2019
 */
@Data
@Entity
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Number extends AbstractEntity {

    /**
     *
     */
    @NotNull
    @Column(nullable = false, unique = true)
    private Short digit;

    /**
     *
     */
    @Column(nullable = false)
    private Integer processingTime;

    /**
     *
     */
    @Transient
    private Set<Short> numbers;

    /**
     *
     */
    @PreUpdate
    @PrePersist
    public void calculateNumbers() {
        final LocalDateTime init = LocalDateTime.now();

        if (digit == 0)
            return;

        this.numbers = new HashSet<>();

        for (int i = 0; i < digit; i++) {
            this.numbers.add((short) i);
        }

        final LocalDateTime finall = LocalDateTime.now();
        this.processingTime = finall.getNano() - init.getNano();
    }
}
