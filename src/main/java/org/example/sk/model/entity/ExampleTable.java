package org.example.sk.model.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
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

@Entity
@Table(name = "sk_example_table")
@Getter
@Setter
@TypeDef(name = "json", typeClass = JsonType.class)
public class ExampleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    private Obj obj;
}
