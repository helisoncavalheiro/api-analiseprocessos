package br.com.helison.core.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.helison.core.models.Issue;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class IssueService implements PanacheRepository<Issue> {

    @Inject
    EntityManager em;

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

    public List<Issue> getUserInteractions(String userID) throws SQLException {
        List<Issue> issues = new ArrayList<>();
        List<Long> journalizedIssues;
        journalizedIssues = em.createNativeQuery("SELECT i.id FROM issues i, journals j WHERE i.id = j.journalized_id AND j.journalized_type = 'Issue' AND notes LIKE '@108466%';").getResultList();
        
        for(int i = 0;i<journalizedIssues.size();i++){
            issues.add(find("id = " + journalizedIssues.get(i)).firstResult());
        } 
        return issues;

        /* FIXME: Otimizar esse JOIN */
        /*
        issues = find(
            "SELECT i FROM Issue i, Journal " + 
                "WHERE Issue.id = Journal.journalizedId " +
                    "AND Journal.journalizedType = 'Issue' " +
                    "AND notes LIKE '@" + userID + "%'").list();*/
        
    }
}