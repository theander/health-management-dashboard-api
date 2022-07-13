package com.healthmanagement.dashboardapi.resolver;

import com.healthmanagement.dashboardapi.model.Imc;
import com.healthmanagement.dashboardapi.service.ImcService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImcQuery implements GraphQLQueryResolver {
    private ImcService imcService;

    public ImcQuery(ImcService imcService) {
        this.imcService = imcService;
    }

    public List<Imc> findAllImc() {
        return this.imcService.findAll();
    }

    public Long countImc() {
        return this.imcService.countImc();
    }


}
