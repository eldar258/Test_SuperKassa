package org.example.sk.model.entity;


import com.fasterxml.jackson.databind.JsonNode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;

@Entity
@Table(name = "sk_example_table")
@Getter
@Setter
@TypeDef(name = "jsonb", typeClass = JsonNodeBinaryType.class)
public class ExampleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "jsonb")
    @Column(name = "obj", nullable = false)
    private JsonNode obj;
}
