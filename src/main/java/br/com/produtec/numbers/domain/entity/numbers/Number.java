package br.com.produtec.numbers.domain.entity.numbers;

import br.com.produtec.numbers.domain.entity.AbstractEntity;
import br.com.produtec.numbers.domain.entity.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",
        scope = Number.class,
        resolver = EntityIdResolver.class)
public class Number extends AbstractEntity {

    /**
     *
     */
    @NotBlank
    @Length(max = 3)
    @Column(nullable = false, unique = true, length = 50)
    private String digit;

    /**
     *
     */
    @Column(nullable = false)
    private long processingTime;

}
