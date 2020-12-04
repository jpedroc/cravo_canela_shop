package com.example.cravocanela.servico.filtro;

import com.example.cravocanela.dominio.Produto;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProdutoFiltro implements EntityFiltro {

    private Long id;
    private String nome;
    private Double valor;
    private Boolean status;

    @Override
    public Specification filter() {
        return (root, query, builder) -> builder.and(getPredicates(root, builder).toArray(new Predicate[0]));
    }

    private List<Predicate> getPredicates(Root root, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
//        if(ObjectUtils.isNotEmpty(id)) {
//            Predicate predicate = builder.equal(root.get(Produto_.id), id);
//            predicates.add(predicate);
//        }
//        if(StringUtils.isNotEmpty(nome)) {
//            Predicate predicate = builder.like(root.get(Produto_.nomeProduto), "%" + nome.toLowerCase() + "%");
//            predicates.add(predicate);
//        }
//        if(ObjectUtils.isNotEmpty(valor)) {
//            Predicate predicate = builder.equal(root.get(Produto_.valorProduto), valor);
//            predicates.add(predicate);
//        }
        return predicates;
    }
}
