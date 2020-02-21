package br.com.helison.core.services;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import br.com.helison.core.models.Issue;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class IssueService implements PanacheRepository<Issue> {

    public List<Issue> getIssues() {
        List<Issue> issues = new ArrayList<>();
        try{
            issues = listAll();
        }catch(Exception ex){
            System.out.println("Não foi possível retornar um resultado da base de dados. Erro :" + ex.getMessage());
        }
        return issues;
    }

    public Issue getIssue(Long id) {
        Issue issue = new Issue();
        try{
            issue = findById(id);
        }catch(Exception ex){
            System.out.println("Não foi possível retornar um resultado da base de dados. Erro :" + ex.getMessage());
        }
        return issue;
    }
}